import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSetup {

    public static void main(String[] args) {
       ServerSetup serverSetup = new ServerSetup();
        try {
            serverSetup.startServer(8080);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startServer(int port) throws IOException {
        ServerSocket socketManager = new ServerSocket(port);
        Thread serverThread = new Thread(
                () -> {
                    Socket clientConnection = null;
                    try {
                        clientConnection = socketManager.accept();

                        InputStream input = clientConnection.getInputStream();
                        InputStreamReader inputReader = new InputStreamReader(input);
                        BufferedReader messageReader = new BufferedReader(inputReader);
                        String message = messageReader.readLine();

                        OutputStream output = clientConnection.getOutputStream();
                        PrintWriter writer = new PrintWriter(output);
                        writer.println(message);
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
