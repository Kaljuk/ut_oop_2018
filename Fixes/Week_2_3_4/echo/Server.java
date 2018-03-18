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
                try {
                    Socket socket = ss.accept();
                    System.out.println("client connected; waiting for a byte");

                    DataInputStream dataIn = new DataInputStream(
                        socket.getInputStream()
                    );

                    DataOutputStream dataOut= new DataOutputStream(
                        //new
                        socket.getOutputStream()
                    );

                    System.out.println("Listening");
                    String line;
                    Boolean done = false;
                    while(!done) {
                        //Thread.sleep(1000);
                        //getDataIn(dataIn);
                        line = dataIn.readUTF();
                        System.out.println("Received: "+line);
                        dataOut.writeUTF("[ServerResponse] "+line);
                        //sendDataOut(dataOut, line);
                    }
                    dataIn.close();
                    socket.close();
                    ss.close();
                } catch(EOFException e) {
                    System.out.println(
                        String.format("Client nr. %d served", ++clientsServed)
                    );
                }
            }
        } catch(IOException e) {
            System.out.println("IOE" + e);
        }
        
        
        // System.out.println("cleaned up");
    }


    /*
    private static String getDataIn(DataInputStream inputStream) {
        try {
            while( inputStream.available() > 0 ) {
                System.out.println("Reading");
                String dataIn = inputStream.readUTF();
                System.out.print(dataIn);
            }
        } catch (IOException e) {
            System.out.println("IOE" + e);
        }
        return "";
    }*/

    private static void sendDataOut(DataOutputStream outputStream, String stringToSend) {
        try {
            int dataLength = stringToSend.length();
            String sendData = String.format("%d%s", dataLength, stringToSend);
            outputStream.writeUTF(sendData);
        } catch(IOException e) {
            System.out.println("IOE" + e);
        }
    }

}
