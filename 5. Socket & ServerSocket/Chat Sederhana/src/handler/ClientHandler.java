package handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable{
    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try ( BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
               PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);) {
            
            String clientMessage;

            while ((clientMessage = in.readLine()) != null) {
                System.out.println(clientSocket + ":" + clientMessage);

                out.println("Server menerima: " + clientMessage);
            }
        } catch (IOException e) {
            System.err.println("Error dengan client: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("Error menutup socket: " + e.getMessage());
            }
        }
    }

}
