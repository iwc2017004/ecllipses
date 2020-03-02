package myPacket;

//Java implementation of Server side 
//It contains two classes : Server and ClientHandler 
//Save file as Server.java 

import java.io.*; 
import java.util.*; 
import java.net.*; 

//Server class 
public class MyServer {

	// Vector to store active clients 
	static Vector<ClientHandler> ar = new Vector<>(); 
	
	// counter for clients 
	static int i = 0; 

	public static void main(String[] args) throws IOException 
	{ 
		ServerSocket ss = new ServerSocket(970); 
		
		Socket s; 
	 
		while (true) 
		{ 
			System.out.println("trying to connect ......"); 
			s = ss.accept(); 
			System.out.println("New client request received : " + s); 
			
			DataInputStream dis = new DataInputStream(s.getInputStream()); 
			DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
			
			System.out.println("Creating a new handler for this client..."); 
 
			ClientHandler mtch = new ClientHandler(s,"client " + i, dis, dos); 

			Thread t = new Thread(mtch); 
			
			System.out.println("Adding this client to active client list"); 

			ar.add(mtch); 

			t.start(); 

			// increment i for new client. 
			i++; 
			System.out.println("Server  "+i); 
			//dis.close();
			//dos.close();
			

		} 
	} 
} 

//ClientHandler cl
