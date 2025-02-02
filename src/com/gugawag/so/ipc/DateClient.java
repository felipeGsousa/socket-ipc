package com.gugawag.so.ipc;

/**
 * Client program requesting current date from server.
 *
 * Figure 3.22
 *
 * @author Silberschatz, Gagne and Galvin. Pequenas alterações feitas por Gustavo Wagner (gugawag@gmail.com)
 * Operating System Concepts  - Eighth Edition
 */ 

import java.net.*;
import java.io.*;
import java.util.Date;

public class DateClient {
	public static void main(String[] args)  {
		try {
			// this could be changed to an IP name or address other than the localhost
			Socket sock = new Socket("localhost",6013);
			InputStream in = sock.getInputStream();
			BufferedReader bin = new BufferedReader(new InputStreamReader(in));

			System.out.println("=== Cliente iniciado ===\n");

			PrintWriter pout = new PrintWriter(sock.getOutputStream(), true);
			pout.println("Felipe Galdino de Sousa");

			String line = bin.readLine();
			System.out.println("O servidor me disse:" + line);

			sock.close();
		}
		catch (IOException ioe) {
				System.err.println(ioe);
		}
	}
}
