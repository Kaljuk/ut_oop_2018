// Base from https://github.com/mbakhoff/sockets-template

import java.lang.*;
import java.nio.charset.Charset;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws Exception {
        /*
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

        System.out.println("connecting to server");
        */
        Socket socket = new Socket("localhost", 1337);
        
        System.out.println("connected; sending data");
        DataOutputStream dataOut = new DataOutputStream(
            socket.getOutputStream()
        );
        DataInputStream dataIn = new DataInputStream( 
            socket.getInputStream() 
        );
        
        for (String i : args) {
            sendData(dataOut, i);
            receiveData(dataIn);
        }

        socket.close();
        //System.out.println("cleaned up");
    }

    private static void sendData(DataOutputStream dataOut, String sendString) {
        try {
            dataOut.writeUTF(sendString);
        } catch(IOException e) {
            System.out.println("[EXCEPTION] sendData(): IOE"+e);
        }
    }

    private static void receiveData(DataInputStream dataIn) {
        try {
            String receivedString = dataIn.readUTF();
            System.out.println("Feedback from server: "+receivedString);
        } catch(IOException e) {
            System.out.println("[EXCEPTION] receiveData(): IOE"+e);
        }
    }
}
