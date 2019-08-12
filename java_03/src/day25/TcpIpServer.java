package day25;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpIpServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;

		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("서버가 준비 되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}

		while (true) {
			try {
				System.out.println("Client 요청을 기다립니다.");
				Socket socket = serverSocket.accept(); // 기다리고 있는 구문
                new ServerThread(socket).start();
                
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}

	}
}

class ServerThread extends Thread {
	BufferedReader br = null;
	BufferedWriter bw = null;
	Socket socket = null;
	String name = null;

	public ServerThread(Socket socket) {
		this.socket = socket;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			name = br.readLine();
			bw.write("Hello ~~~" + name + "님 \n");
			bw.flush();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	@Override
	public void run() {
		String msg = null;
		try {
			while ((msg = br.readLine()) != null) {
				bw.write(name + " : " + msg + "\n");
				bw.flush();
			}
		} catch (Exception e) {

		} finally {
			try {
				if (socket != null)
					socket.close();
				if (br != null)
					br.close();
				if (bw != null)
					bw.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
