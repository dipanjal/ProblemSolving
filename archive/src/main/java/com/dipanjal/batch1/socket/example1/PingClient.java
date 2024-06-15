package com.dipanjal.batch1.socket.example1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class PingClient {

    private Socket clientSocket;
    private PrintWriter request;
    private BufferedReader response;


    public void startConnection(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        request = new PrintWriter(clientSocket.getOutputStream(), true);
        response = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public String sendMessage(String msg) throws IOException {
        request.println(msg);
        String serverResponse = response.readLine();
        return serverResponse;
    }

    public static void main(String[] args) throws IOException {
        PingClient client = new PingClient();
        client.startConnection("127.0.0.1", 5000);

        Scanner scanner = new Scanner(System.in);
        while (true){
            String input = scanner.nextLine();
            if(input.equals("bye")) break;
            System.out.println(client.sendMessage(input));
        }

/*        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(client.sendMessage(input));*/
    }
}
