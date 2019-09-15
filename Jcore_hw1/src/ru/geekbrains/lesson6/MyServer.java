package ru.geekbrains.lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer {
    public static void main(String[] args) {
        Socket socket = null;
        DataInputStream in;
        DataOutputStream out;

        Thread readThread, writeThread;

        try (ServerSocket serverSocket = new ServerSocket(8189)){
            System.out.println("Сервер запущен...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключен...");

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            readThread = new Thread(()->{
               while(true){
                   try {
                       String message = in.readUTF();
                       if (message.equalsIgnoreCase("/end")) {
                           System.out.println("The client closed the connection");
                           out.writeUTF("/end");
                           break;
                       }
                       System.out.println("Client: " + message);
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
        catch(Exception e){
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
