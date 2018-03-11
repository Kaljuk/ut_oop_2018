// Base from https://github.com/mbakhoff/sockets-template

import java.lang.*;
import java.nio.charset.Charset;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws Exception {

        int currentPort = 1337;
        ServerSocket ss = new ServerSocket(currentPort);
        System.out.println("now listening on :"+currentPort);
        Socket socket = ss.accept();
        System.out.println("client connected; waiting for a byte");
        InputStream in = socket.getInputStream();
        int receivedBytes = in.read();

        StringBuilder receivedMessage = new StringBuilder();
        for (int i=0; i< receivedBytes; i++) {
            int byteIn = in.read();
            receivedMessage.append((char)byteIn);
            //System.out.println("reading"+ (char)byteIn);
        }
        String fullMessage = receivedMessage.toString();
        System.out.println("received " + fullMessage);


        StringBuilder makeMessage = new StringBuilder();
        String sendMessage = fullMessage;
        byte[] b = sendMessage.getBytes(Charset.forName("UTF-8"));

        OutputStream out = socket.getOutputStream();
        int bytesToSend = b.length;
        out.write(b.length);
        for(int i=0; i<bytesToSend; i++) {
            out.write(b[i]);
        }


        in.close();
        out.close();
        socket.close();
        ss.close();
        // System.out.println("cleaned up");
    }
}
