package com.plaxa.http.socket.tcp_test.client;

import java.io.*;
import java.net.Inet4Address;
import java.net.Socket;
import java.util.Scanner;

//        http - 80
//        https - 443
//        TCP
//        Socket - client
//        outputStream - send request
//        inputStream - receive response
public class SocketRunner {
    public static void main(String[] args) throws IOException {

        var inetAddress = Inet4Address.getByName("localhost");
        try (var socket = new Socket(inetAddress, 7777);
             var outputStream = new DataOutputStream(socket.getOutputStream());
             var inputStream = new DataInputStream(socket.getInputStream());
             var scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()){
                var request = scanner.nextLine();
                outputStream.writeUTF(request);
//            Как только вызвали readUTF - ожидаем response от сервера (поток ждет)
                System.out.println("Response from server: " + inputStream.readUTF());
            }
        }
    }
}
