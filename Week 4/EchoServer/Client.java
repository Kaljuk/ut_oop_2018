// Base from https://github.com/mbakhoff/sockets-template

import java.lang.*;
import java.nio.charset.Charset;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws Exception {

        // get message from args
        StringBuilder makeMessage = new StringBuilder();
        for(String i : args) {
            makeMessage.append(i);
            makeMessage.append(" ");
        }
        String sendMessage = makeMessage.toString();

        // string.getBytes(StandardCharsets.UTF_8);

        byte[] b = sendMessage.getBytes(Charset.forName("UTF-8"));
        System.out.println("Sending message: "+sendMessage);
        System.out.println(b);

        System.out.println("connecting to server");
        Socket socket = new Socket("localhost", 1337);
        System.out.println("connected; sending data");
        OutputStream out = socket.getOutputStream();
        int byteToSend = 42;

        // int[] bytesToSend = b;
        int bytesToSend = b.length;
        out.write(b.length);
        for(int i=0; i<bytesToSend; i++) {
            out.write(b[i]);
        }
        System.out.println("Now receiving data");
        // Receive back
        InputStream in = socket.getInputStream();
        int receivedBytes = in.read();
        // System.out.println(receivedBytes);
        StringBuilder receivedMessage = new StringBuilder();
        for (int i=0; i< receivedBytes; i++) {
            int byteIn = in.read();
            receivedMessage.append((char)byteIn);
            //System.out.println("reading"+ (char)byteIn);
        }
        String fullMessage = receivedMessage.toString();
        System.out.println("Received: " + fullMessage);

        in.close();
        out.close();
        socket.close();
        //System.out.println("cleaned up");
    }
}
