package com.multicampus.androidjava202109.multichat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatActivity extends AppCompatActivity {

    private Socket s;
    private BufferedReader fromServer;		// 서버로부터 읽는다.
    private PrintWriter toServer;	// 서버로 보낸다.
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Intent intent = getIntent();
        final String SERVER = intent.getStringExtra("server");
        final String NICKNAME = intent.getStringExtra("nickname");

        System.out.println(SERVER);
        System.out.println(NICKNAME);

        setView();
        setEvent();

        handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                msgOut.append(msg.getData().getString("recvData") + "\n");
            }
        };

        new Thread(){
            public void run(){
                connect(SERVER, NICKNAME);
            }
        }.start();

    }

    private EditText msgOut;
    private EditText msgInput;
    private Button sendBtn;

    // 화면 구성
    private void setView() {
        msgOut = findViewById(R.id.msgOut);
        msgInput = findViewById(R.id.msgInput);
        sendBtn = findViewById(R.id.sendBtn);
    }

    // 이벤트 등록
    private void setEvent() {
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = msgInput.getText().toString();
                sendMsg(msg);
                msgInput.setText("");
                msgInput.requestFocus();
            }
        });
    }

    // 서버에 메세지 전송
    private void sendMsg(String msg){
        new Thread(){
            public void run(){
                toServer.println(msg);
            }
        }.start();
    }

    private void connect(String server, String nickname){
        String host = server.split(":")[0];
        int port = Integer.parseInt(server.split(":")[1]);

        try{
            // 소켓 생성(서버 접속 요청)
            s = new Socket(host, port);
            System.out.println("서버에 접속 완료.");

            // 소켓에서 입출력 스트림 생성
            fromServer = new BufferedReader(new InputStreamReader(s.getInputStream(), "UTF-8"));
            toServer = new PrintWriter(new OutputStreamWriter(s.getOutputStream(), "UTF-8"), true);

            // 로그인 요청
            sendMsg("login " + nickname);

            // 서버로부토 받은 데이터 출력
            String recvData = "";
            while((recvData = fromServer.readLine()) != null) {
                Bundle bundle = new Bundle();
                bundle.putString("recvData", recvData);
                Message msg = handler.obtainMessage();
                msg.setData(bundle);
                handler.sendMessage(msg);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }



}