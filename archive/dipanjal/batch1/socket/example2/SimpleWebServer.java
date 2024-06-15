package com.dipanjal.batch1.socket.example2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class SimpleWebServer {

    private ServerSocket server;
    private final int port;
    private final RequestRouter router;

    public SimpleWebServer(int port){
        this.port = port;
        this.router = new RequestRouter();
    }

    public void start() throws IOException {
        this.server = new ServerSocket(port);
        System.out.println("Web Server Started...");
        listenAndRespond();
    }

    private void listenAndRespond() throws IOException {
        Socket client = null;
        BufferedReader request = null;
        PrintWriter response = null;

        try{
            while(!server.isClosed()) {
                client = server.accept(); //accepting the clients
                System.out.println("Client connected...");

                request = new BufferedReader(new InputStreamReader(client.getInputStream()));
                int lineNo = 1;
                String line = request.readLine();
                String path = "";
                while(!line.isEmpty()) {
                    if(lineNo == 1) {
                        path = extractPathFromLine(line);
                    }
                    System.out.println("From Client: "+line);
                    line = request.readLine();
                    lineNo++;
                }
                response = new PrintWriter(client.getOutputStream(), true);
                sendHttpResponse(path, response);
//                Thread.sleep(10000);
                closeClientConnection(client, request, response);
            }
        }catch (SocketException se) {
            closeClientConnection(client, request, response);
            System.out.println("--------------");
            listenAndRespond();
        }
    }

    private String extractPathFromLine(String line) {
        if(line.startsWith("GET") || line.startsWith("POST")) {
            String[] parts = line.trim().split(" ");
            return parts[1];
        }
        return "";
    }

    private void closeClientConnection(Socket client, BufferedReader request, PrintWriter response) throws IOException {
        System.out.println("Client disconnected");
        if(request != null) request.close();
        if(response != null) response.close();
        if(client != null) client.close();
    }

    private void sendHttpResponse(String path, PrintWriter response) {
        router.routePath(path, response);
    }

    public static void main(String[] args) throws IOException {
        SimpleWebServer webServer = new SimpleWebServer(5000);
        webServer.start();;
    }
}
