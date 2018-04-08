// Base from https://github.com/mbakhoff/sockets-template

import java.lang.*;
import java.nio.charset.Charset;
import java.io.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws Exception {

        int currentPort = 1337;
        ServerSocket ss = new ServerSocket(currentPort);
        System.out.println("now listening on :"+currentPort);

        int clientsServed = 0;
        
        try {
            while(true) {
                
                new SocketRequestHandler(ss.accept()).start();
                
            }
        } catch(IOException e) {
            System.out.println("IOE" + e);
        } finally {
            ss.close();
        }
        
        // System.out.println("cleaned up");
    }

}

