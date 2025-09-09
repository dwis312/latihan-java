package handler;

import java.io.BufferedReader;
import java.io.IOException;

public class ServerHandler implements Runnable {
    private BufferedReader input;

    public ServerHandler(BufferedReader input) {
        this.input = input;
    }

    public void run() {
        try {
            String pesan;
            while ((pesan = input.readLine()) != null) {
                System.out.println("Server: " + pesan);
            }
        } catch (IOException e) {
            System.out.println("Server terputus.");
        }
    }

}
