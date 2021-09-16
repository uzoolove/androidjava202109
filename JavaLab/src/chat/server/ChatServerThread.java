package chat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatServerThread extends Thread {
	private Socket s;
	private BufferedReader in;
	private PrintWriter toClient;
	// 대화명
	private String nickname;

	public ChatServerThread(Socket s2) {
		s = s2;
	}
	
	// 담당 클라이언트에 지정한 메세지 전송
	private void sendMsg(String msg) {
		toClient.println(msg);
	}
	
	// 모든 클라이언트에 지정한 메세지 전송
	private void broadcast(String msg) {
		for(ChatServerThread t : ChatServer.clients) {
			t.sendMsg(msg);
		}
	}
	
	// 로그인
	private void login(String nickname) {
		if(nickname.length() >= 2) {
			this.nickname = nickname;
			broadcast("시스템: " + nickname + "님이 입장했습니다.");
		}else {
			sendMsg("시스템: 대화명을 2글자 이상 입력하세요.");
		}
	}
	
	// 로그아웃
	private void logout() {
		broadcast("시스템: " + nickname + "님이 퇴장했습니다.");
		
		synchronized(ChatServer.clients) {
			ChatServer.clients.remove(this);
		}
		
		try {
			toClient.close();
			in.close();
			s.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	

	public void run() {
		try {
			// 소켓에서 입출력 스트림 생성
			in = new BufferedReader(new InputStreamReader(s.getInputStream(), "UTF-8"));
			toClient = new PrintWriter(new OutputStreamWriter(s.getOutputStream(), "UTF-8"), true);
			// 입력 스트림에서 읽고 출력 스트림으로 전송한다.
			String readData = "";
			while ((readData = in.readLine()) != null) {
				if(readData.startsWith("login ")) {	// login 김철수
					login(readData.substring(6).trim());
				}else {
					if(nickname == null) {
						sendMsg("시스템: 로그인 후에 이용하세요.");
					}else {
						if(readData.trim().length() == 0) {
							sendMsg("시스템: 메세지를 입력하세요.");
						}else {
							broadcast(nickname + ": " + readData);
						}
					}					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			logout();
		}
	}
}
