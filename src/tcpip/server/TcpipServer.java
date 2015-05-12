package tcpip.server;

import Database.DataHandler;
import Database.Database;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TcpipServer {

    private ServerSocket serverSocket;
    private Socket socket;
    private final int PORT = 8000;
    static int x = 0;
    private RawData rawData;

    private boolean check;

    public TcpipServer() {
        try {
            serverSocket = new ServerSocket(PORT);
            rawData = new RawData();
        } catch (IOException e) {
            System.err.println(e);
            System.exit(0);
        }
    }

    public void runServer() {

        try {
            while (true) {
                System.out.println("Waiting on connection...");
                socket = serverSocket.accept();
                new Thread(new ConnectionHandler(socket, x++, rawData)).start();
            }
        } catch (IOException ex) {
            Logger.getLogger(TcpipServer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {

        

        TcpipServer s = new TcpipServer();
        s.runServer();

    }

}
