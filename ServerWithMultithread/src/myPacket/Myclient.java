package myPacket;

	import java.io.*; 
	import java.net.*; 
	import java.util.Scanner; 

	public class Myclient {
		final static int ServerPort = 970; 

		public static void main(String args[]) throws UnknownHostException, IOException 
		{ 
			Scanner scn = new Scanner(System.in); 
			InetAddress ip = InetAddress.getByName("localhost"); 
			
			Socket s = new Socket(ip, ServerPort); 
			  
			DataInputStream dis = new DataInputStream(s.getInputStream()); 
			DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
			 
			// sendMessage thread 
			Thread sendMessage = new Thread(new Runnable() 
			{ 
				@Override
				public void run() { 
					while (true) {  
						String msg = scn.nextLine(); 
						try {  
							dos.writeUTF(msg);
							//dos.close();
						} catch (IOException e) { 
							e.printStackTrace(); 
						} 
					} 
				} 
			}); 
			
			// readMessage thread 
			Thread readMessage = new Thread(new Runnable() 
			{ 
				@Override
				public void run() { 

					while (true) { 
						try { 
							String msg = dis.readUTF(); 
							System.out.println(msg); 
							//dis.close();
						} catch (IOException e) { 

							e.printStackTrace(); 
						} 
					} 
				} 
			}); 
			
			sendMessage.start(); 
			readMessage.start(); 

		} 
	} 



