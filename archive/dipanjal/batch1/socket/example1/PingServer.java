package com.dipanjal.batch1.socket.example1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Locale;

public class PingServer {

    private ServerSocket server;
    private final int port;
    private int count;

    public PingServer(int port) {
        this.port = port;
    }

    private void start() throws IOException {
        server = new ServerSocket(port);
        System.out.println("Server started...");
        listenAndRespond();
    }

    private void listenAndRespond() throws IOException {
        Socket clientSocket = null;
        BufferedReader request = null;
        PrintWriter response = null;
        try{
            while(!server.isClosed()) {
                clientSocket = server.accept(); //listening, BLocking I/O
                System.out.println(++count+" Client connected...");

                request = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream())
                );

                response = new PrintWriter(clientSocket.getOutputStream(), true);

                String inputLine;
                while ((inputLine = request.readLine()) != null) {
                    System.out.println("From Client: "+inputLine);
                    response.println("From Server: "+inputLine.toUpperCase());
                }
            }
        }catch (SocketException se){
            releaseDisconnectedClient(clientSocket, request, response);
            listenAndRespond();
        }
    }

    private void releaseDisconnectedClient(Socket clientSocket, BufferedReader request, PrintWriter response) throws IOException {
        count--;
        System.out.println("Client disconnected");
        if(request != null) request.close();
        if(response != null) response.close();
        if(clientSocket != null) clientSocket.close();
    }

    public static void main(String[] args) throws IOException {
        PingServer server1 = new PingServer(5000);
        server1.start();
    }
}
