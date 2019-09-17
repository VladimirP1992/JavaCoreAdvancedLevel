package ru.geekbrains.lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args) {
        final String SERVER_ADDR = "localhost";
        final int SERVER_PORT = 8189;

        Socket socket = null;
        DataInputStream in;
        DataOutputStream out;

        Thread readThread, writeThread;

        try{
            socket = new Socket(SERVER_ADDR, SERVER_PORT);
            in = new DataInputStream(socket.getInputStream());
            out =new DataOutputStream(socket.getOutputStream());

            readThread = new Thread(()->{
                while(true){
                    try {
                        String message = in.readUTF();
                        if (message.equalsIgnoreCase("/end")) {
                            System.out.println("The server closed the connection");
                            out.writeUTF("/end");
                            break;
                        }
                        System.out.println("Server: " + message);
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }
                }
            });
            writeThread = new Thread(()->{
                while(true){
                    try {
                        Scanner keyboardIn = new Scanner(System.in);
                        String message = keyboardIn.nextLine();
                        out.writeUTF(message);
                        if (message.equalsIgnoreCase("/end")) {
                            break;
                        }
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }
                }
            });

            readThread.start();
            writeThread.start();

            readThread.join();
            writeThread.join();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                socket.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
