package echo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoServerThread extends Thread {
	private Socket s;
	private BufferedReader in;
	private PrintWriter toClient;

	public EchoServerThread(Socket s2) {
		s = s2;
	}

	public void run() {
		try {
			// 소켓에서 입출력 스트림 생성
			in = new BufferedReader(new InputStreamReader(s.getInputStream(), "UTF-8"));
			toClient = new PrintWriter(new OutputStreamWriter(s.getOutputStream(), "UTF-8"), true);
			// 입력 스트림에서 읽고 출력 스트림으로 전송한다.
			String readData = "";
			while ((readData = in.readLine()) != null) {
				System.out.println(readData);
				toClient.println(readData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
