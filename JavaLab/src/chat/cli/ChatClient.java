package chat.cli;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
	private Socket s;
	private BufferedReader fromServer;		// 서버로부터 읽는다.
	private PrintWriter toServer;	// 서버로 보낸다.
	private BufferedReader key;	// 키보드로부터 읽는다.

	// 객체 생성 후 호출할 메소드
	private void onCreate() {
//		final String SERVER = "localhost:8212";
		final String SERVER = "chat.awsins.shop:8212";
		final String NICKNAME = "김철수222";
		connect(SERVER, NICKNAME);
	}
	


	// 서버에 메세지 전송
	private void sendMsg(String msg){
		toServer.println(msg);
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
			
			// 키보드에서 입력한 문자를 꺼내기 위한 입력 스트림 생성
			key = new BufferedReader(new InputStreamReader(System.in));
			
			// 로그인 요청
			sendMsg("login " + nickname);
			
			new Thread() {
				public void run() {
					try {
						// 키보드에서 입력한 데이터를 출력 스트림으로 전송
						String readData = "";
						while((readData = key.readLine()) != null) {
							sendMsg(readData);
						}
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}.start();
			
			// 서버로부토 받은 데이터 출력
			String recvData = "";				
			while((recvData = fromServer.readLine()) != null) {
				System.out.println(recvData);
			}

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ChatClient ec = new ChatClient();
		ec.onCreate();
	}
}




























