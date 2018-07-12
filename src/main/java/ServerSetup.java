import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSetup {

    public void startServer(int port) throws IOException {
        ServerSocket socketManager = new ServerSocket(port);
        Thread serverThread = new Thread(
                () -> {
                    Socket clientConnection = null;
                    try {
                        clientConnection = socketManager.accept();
                        OutputStream output = clientConnection.getOutputStream();
                        PrintWriter writer = new PrintWriter(output);
                        writer.println("Hello");
                        writer.flush();
                        clientConnection.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        );
       serverThread.start();
    }

}
