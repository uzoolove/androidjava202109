package echo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	private ServerSocket ss;
	private Socket s;
	private BufferedReader in;
	private PrintWriter out;

	private void startServer() {
		try {
			// 서버소켓 생성
			ss = new ServerSocket(1234);
			System.out.println("서버 구동 완료. 1234");
			// 클라이언트 접속 대기
			s = ss.accept();
			System.out.println("클라이언트 접속. " + s.getInetAddress().getHostAddress());

			// 소켓에서 입출력 스트림 생성
			in = new BufferedReader(new InputStreamReader(s.getInputStream(), "UTF-8"));
			out = new PrintWriter(new OutputStreamWriter(s.getOutputStream(), "UTF-8"));
			// 입력 스트림에서 읽고 출력 스트림으로 전송한다.
			int readData = 0;
			while((readData = in.read()) != -1) {
				System.out.write(readData);
				out.write(readData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new EchoServer().startServer();
	}
}
