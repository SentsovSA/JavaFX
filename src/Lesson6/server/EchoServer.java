package Lesson6.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Locale;
import java.util.Scanner;

public class EchoServer {

    private static final int SERVER_PORT = 8888;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {

            System.out.println("Waiting for connection....");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connection successful!");

                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                try {
                    while (true) {
                        String message = in.readUTF();
                        System.out.println("User's message: " + message);

                        String serverMessage = null;
                        Scanner scanner = new Scanner(System.in);
                        serverMessage = scanner.next();
                        out.writeUTF(serverMessage);

                        if (message.equals("//server-stop")) {
                            break;
                        }
                    }

                    System.out.println("Server stopped!");
                } catch (IOException e) {
                    clientSocket.close();
                    System.out.println("Client disconnected!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
