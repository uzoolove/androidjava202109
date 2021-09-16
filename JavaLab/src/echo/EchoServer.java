package echo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	private ServerSocket ss;
	

	private void startServer() {
		try {
			// 서버소켓 생성
			ss = new ServerSocket(8212);
			System.out.println("서버 구동 완료. 8212");
			
			while(true) {
				// 클라이언트 접속 대기
				Socket s = ss.accept();
				System.out.println("클라이언트 접속. " + s.getInetAddress().getHostAddress());
				EchoServerThread t = new EchoServerThread(s);
				t.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new EchoServer().startServer();
	}
}
