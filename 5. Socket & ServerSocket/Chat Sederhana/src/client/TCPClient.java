package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import handler.ServerHandler;

public class TCPClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8080;
    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT)) {
            System.out.println("Terhubung ke server");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            Thread bacaPesan = new Thread(new ServerHandler(input));
            bacaPesan.start();

            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            String pesan;
            while ((pesan = console.readLine()) != null) {
                output.println(pesan);
            }
        } catch (Exception e) {
            System.err.println("Error menerima pesan: " + e.getMessage());
        }
    }

}
