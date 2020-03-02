package myPacket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringTokenizer;

class ClientHandler implements Runnable 
{ 
	Scanner scn = new Scanner(System.in); 
	private String name; 
	final DataInputStream dis; 
	final DataOutputStream dos; 
	Socket s; 
	boolean isloggedin; 
	
	// constructor 
	public ClientHandler(Socket s, String name, 
							DataInputStream dis, DataOutputStream dos) { 
		this.dis = dis; 
		this.dos = dos; 
		this.name = name; 
		this.s = s; 
		this.isloggedin=true; 
	} 

	@Override
	public void run() { 

		String received; 
		while (true) 
		{ 
			try
			{ 
				received = dis.readUTF(); 
				
				System.out.println(received); 
				
				if(received.equals("logout")){ 
					this.isloggedin=false; 
					this.s.close(); 
					break; 
				} 
				
				StringTokenizer st = new StringTokenizer(received, "#");
				if(st.hasMoreTokens()) {
					String MsgToSend = st.nextToken(); 
					String recipient = st.nextToken(); 
					for (ClientHandler mc : MyServer.ar) 
					{    
						System.out.println("client name : "+mc.name);
						if (mc.name.equals(recipient) && mc.isloggedin==true) 
						{ 
							mc.dos.writeUTF(this.name+" : "+MsgToSend); 
							break; 
						} 
					} 
				}
				
				// search for the recipient in the connected devices list. 
				// ar is the vector storing client of active users 
				
			} catch (IOException e) { 
				
				e.printStackTrace(); 
			} 
			
		} 
		try
		{ 
			this.dis.close(); 
			this.dos.close(); 
			
		}catch(IOException e){ 
			e.printStackTrace(); 
		} 
	} 
} 
