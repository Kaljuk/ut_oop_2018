import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketRequestHandler extends Thread {

    Socket socket;
    
    public SocketRequestHandler(Socket requestSocket) {
        super();
        this.socket   = requestSocket;
        String sts = requestSocket.toString();
        System.out.println("New connection: "+ sts);
    }

    @Override
    public void run() {
        try {
            
            DataInputStream dataIn   = new DataInputStream(
                socket.getInputStream()
            );
            DataOutputStream dataOut = new DataOutputStream(
                socket.getOutputStream()
            );

            String line;
            boolean done = false;
            while(!done) {
                line = dataIn.readUTF();
                done = (line != null)?false : true;
                // <Respond> Send the same message back
                if (!done) {
                    System.out.println(line);
                    dataOut.writeUTF(line);
                }
            }


        } catch(IOException e) {
            // Catch here so the compiler would shutUp with the IOE catching stuff
            //System.out.println(String.format("Error run(): %s", e.toString()));
        } finally {
            try {
                socket.close();
                System.out.println("[SUCCESS] Socket Connection terminated");
            } catch(Exception e) {
                System.out.println("Socket close error"+e.toString());
            }
        }

    }
}