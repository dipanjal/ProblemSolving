package com.dipanjal.batch1.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {

    private final int port;

    public TCPServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server listening at 127.0.0.1:"+port);
        listenAndRespond(serverSocket);
    }

    public void listenAndRespond (ServerSocket serverSocket) throws IOException {
        Socket clientSocket = null;
        BufferedReader request = null;
        PrintWriter response = null;
        try{
            clientSocket = serverSocket.accept();
            System.out.println("Client connected....");
            response = new PrintWriter(clientSocket.getOutputStream(), true);

            response.println("Welcome New Client, At you service");

            request = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


            String line;
            while((line = request.readLine()) != null) {
                System.out.println(line);
                response.println("Response: "+line.toUpperCase());
            }
        } catch (SocketException e) {
            closeClientConnection(clientSocket, request, response);
            listenAndRespond(serverSocket);
        }
    }

    private void closeClientConnection(Socket clientSocket, BufferedReader request, PrintWriter response) throws IOException {
        if(request != null) request.close();
        if(response != null) response.close();
        if(clientSocket != null) clientSocket.close();
    }


    public static void main(String[] args) throws IOException {
        TCPServer tcpServer = new TCPServer(6000);
        tcpServer.start();
    }
}
