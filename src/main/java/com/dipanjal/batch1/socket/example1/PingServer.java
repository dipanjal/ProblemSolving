package com.dipanjal.batch1.socket.example1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

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
        Socket client = null;
        BufferedReader request = null;
        PrintWriter response = null;

        try{
            while(!server.isClosed()) {
                client = server.accept();
                System.out.println(++count+" Client connected...");

                request = new BufferedReader(
                        new InputStreamReader(client.getInputStream())
                );

                response = new PrintWriter(client.getOutputStream(), true);

                String inputLine;
                while ((inputLine = request.readLine()) != null) {
                    response.println(inputLine);
                }
            }
        }catch (SocketException e){
            releaseDisconnectedClient(client, request, response);
            listenAndRespond();
        }
    }

    private void releaseDisconnectedClient(Socket client, BufferedReader request, PrintWriter response) throws IOException {
        count--;
        System.out.println("Client disconnected");
        if(request != null) request.close();
        if(response != null) response.close();
        if(client != null) client.close();
    }

    public static void main(String[] args) throws IOException {
        PingServer server = new PingServer(5000);
        server.start();
    }
}
