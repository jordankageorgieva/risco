package test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Test6 {
    public static void main(String[] args) {
        // write tcp server here
        // it should echo what is sent to it
    	
    	 int port = 12345; // The port the server will listen on

         try (ServerSocket serverSocket = new ServerSocket(port)) {
             System.out.println("Server is listening on port " + port);

             // Continuously accept client connections
             while (true) {
                 try {
                     Socket socket = serverSocket.accept(); // Accept a new client connection
                     System.out.println("New client connected: " + socket.getInetAddress());

                  
                 } catch (IOException e) {
                     System.out.println("Error accepting client connection: " + e.getMessage());
                     e.printStackTrace();
                 }
             }
         } catch (IOException e) {
             System.out.println("Error in server: " + e.getMessage());
             e.printStackTrace();
         }
    }
}
