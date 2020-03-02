package servers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.*;
public class MyServer {

	public static void main(String[] args) {
		try {
			System.out.println("s:server started");
			ServerSocket sk = new ServerSocket(79);
			System.out.println("s:Server is waiting for client req");
			Socket s = sk.accept();
			System.out.println("s:client connected");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String str = br.readLine();
			
			System.out.println("s:client data : "+ str);
			String nickname = str.substring(0,7);
			
			OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
			PrintWriter out = new PrintWriter(os);
			os.write(nickname);
			os.flush();
			System.out.println("s:data sented from serverto client");
			
		}catch(Exception e) {
			System.out.println(e);
			}
		

	}

}
