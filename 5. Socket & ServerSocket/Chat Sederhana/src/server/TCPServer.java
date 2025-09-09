package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

import handler.ClientHandler;

public class TCPServer {
    private static final int PORT = 8080;
    private static Set<ClientHandler> clientHandlers = new HashSet<>();
    
    public static void main(String[] args) {
        System.out.println("Server berjalan di http://localhost: " + PORT + " ...");

        try (ServerSocket serverSocket = new ServerSocket(PORT);) {
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client terhubung: " + socket.getInetAddress());
                
                ClientHandler clientHandler = new ClientHandler(socket);
                clientHandlers.add(clientHandler);

                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }

    
}
