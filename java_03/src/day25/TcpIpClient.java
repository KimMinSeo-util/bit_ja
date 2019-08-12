package day25;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class TcpIpClient {
	public static void main(String[] args) {
//        String serverIp = "127.0.0.1";
//        //String serverIp = "192.168.0.135";
//        
//        BufferedReader br = null;
//        BufferedWriter bw = null;
//        Socket socket = null;
//        Scanner keyboard = null;
//		try {
//			System.out.println(serverIp+"  연결 시도 할께요..");
//			socket =  new Socket(serverIp,7777); 
//			System.out.println("서버와 연결이 되었습니다.");
//			
//			
//			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//
//            keyboard = new Scanner(System.in);
//            
//            System.out.println("이름을 입력하세요.. ");
//            bw.write(keyboard.nextLine()+"\n");
//            bw.flush();
//			System.out.println(br.readLine());
//			
//			while (true) {
//				System.out.println("메세지입력하세요.. ");
//				String msg = keyboard.nextLine();
//				bw.write(msg+"\n");
//				bw.flush();
//				System.out.println(br.readLine());
//				if(msg.equals("q")) break;
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(socket != null) socket.close();
//				if(br != null) br.close();
//				if(bw != null) bw.close();
//			} catch (Exception e2) {
//                e2.printStackTrace();
//			}
//		}
		ServerSocket serverSocket = null;
		List<BufferedWriter> clientList = new ArrayList<BufferedWriter>(); 
		try {
			serverSocket = new ServerSocket(7777); // 포트넘버 저장  // new 하면 7777로 연결시도
			System.out.println("서버가 준비 되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		while (true) { // 들어오는 클라이언트한테 서비스 하고 싶어서 루프돌림
			try {
				System.out.println("Client 요청을 기다립니다.");
//				serverSocket.accept();  // 클라이언트 요청이 올때까지 기다리는것 // 클라이언트가 들어오면 소켓이 만들어짐
				Socket socket = serverSocket.accept();  // 어떤 아이피가 들어왔는지 확인가능함 // 기다리고 있는 구문
				//System.out.println(socket.getInetAddress()+" 와 연결중입니다."); // 나에게 요청한 사람의 아이피주소
				new ServerThread(socket, clientList).start();
				
			} catch (Exception e) {
				e.printStackTrace();
			}  finally { // 여기서 자원반납하면  run전에 끝남
			}
		}
	}
}





