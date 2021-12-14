package assignment.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class HttpClientConnection {
    public static void main(String[] args) throws UnknownHostException, IOException   {
            System.out.println("Creating client socket..");
            Socket socket = new Socket("localhost", 3000);
    
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("Connected to localhost:3000!");
            System.out.println("Please input a command");
            Scanner scan = new Scanner(System.in);
            String serverMsg = "";
            String line = scan.nextLine();
    
            while (!"close".equals(line)) {
                out.println(line);
                out.flush();
                serverMsg = in.readLine();
                System.out.println(serverMsg);
                line = scan.nextLine();
            }
    
            socket.close();
            scan.close();
        }


    }
}
