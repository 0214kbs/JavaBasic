package lec0130.Network;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
	public static void main(String[] args) {
		// ServerSoket - port를 통해서 서비스를 할 수 있는 소켓 프로그램의 서버 part
		// Socket - ip,port를 통해서 서비스 하는 서버에 접속해서 서비스를 이용하는 소켓 프로그램의 클라이언트 part <- browser 이용
		
		try(ServerSocket ss = new ServerSocket(8080)){
			System.out.println("HttpServer is ready!");
			
			while(true) {
				// 클라이언트 소켓 접속(이 예제는 브라우저의 접속)을 기다리면서 대기하다가 접속하면
				// 서비스 실행
				try(Socket client = ss.accept()){
					
					// client <= 접속한 클라이언트 프로그램과 연결된 socket
					String html = "<html><body>Hi. I'm bsk</body></html>";
					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
					bw.write("HTTP/1.1 200 OK \r\n"); // http 통신 프로토콜 
					bw.write("Content-Type : text/html;charset=utf-8\r\n");
					bw.write("\r\n");
					
					bw.write(html);
					bw.write("\r\n");
					bw.flush();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
				
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
