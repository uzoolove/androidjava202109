package chat.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient {
	private Socket s;
	private BufferedReader fromServer;		// 서버로부터 읽는다.
	private PrintWriter toServer;	// 서버로 보낸다.
	private BufferedReader key;	// 키보드로부터 읽는다.

	// 윈도우창
	private JFrame frame;	
	// 메세지 출력 영역
	private JTextArea msgOut;
	private JScrollPane scroller;	
	// 메세지 입력 영역
	private JTextField msgInput;
	private JButton sendBtn;
	private JPanel msgPanel;
	
	// 객체 생성 후 호출할 메소드
	private void onCreate() {
		setView();
		setEvent();
//		final String SERVER = "localhost:8212";
		final String SERVER = "chat.awsins.shop:8212";
		final String NICKNAME = "김철수222";
		connect(SERVER, NICKNAME);
	}
	
	// 화면 구성
	private void setView() {
		frame = new JFrame("멀티챗");
		
		msgOut = new JTextArea("멀티챗에 오신걸 환영합니다.\n", 10, 30);
		msgOut.setLineWrap(true);
		msgOut.setEditable(false);
		scroller = new JScrollPane(msgOut
								, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
								, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		msgInput = new JTextField(35);
		sendBtn = new JButton("전송");
		msgPanel = new JPanel(new BorderLayout());
		msgPanel.add(msgInput, BorderLayout.CENTER);
		msgPanel.add(sendBtn, BorderLayout.EAST);
		
		frame.add(scroller, BorderLayout.CENTER);
		frame.add(msgPanel, BorderLayout.SOUTH);
		
		frame.setSize(400, 300);
		frame.setLocation(600, 300);
		frame.setVisible(true);
		msgInput.requestFocus();
	}
	
	// 이벤트 등록
	private void setEvent() {
		// x 버튼 클릭
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = msgInput.getText();
				sendMsg(msg);
				msgInput.setText("");
				msgInput.requestFocus();
			}
		};
		sendBtn.addActionListener(listener);		
		msgInput.addActionListener(listener);
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

			// 로그인 요청
			sendMsg("login " + nickname);
			
			// 서버로부토 받은 데이터 출력
			String recvData = "";				
			while((recvData = fromServer.readLine()) != null) {
				msgOut.append(recvData + "\n");
				msgOut.setCaretPosition(msgOut.getDocument().getLength());
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




























