package servers;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.*;

public class MyCLient {

	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost", 79);
			System.out.println("socket == "+ s);
			
			String str = "Praveen Chaudhary";
			
			OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
			PrintWriter out = new PrintWriter(os);
			os.write(str);
			os.flush();
			System.out.println("c:data sended from client to server");	
			
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String nickname = br.readLine();
			
			System.out.println("c: data from server " + nickname);
			
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}
