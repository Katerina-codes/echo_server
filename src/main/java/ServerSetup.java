import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

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
                    Socket clientConnection;
                    try {
                        clientConnection = socketManager.accept();

                        InputStream input = clientConnection.getInputStream();
                        InputStreamReader streamReader = new InputStreamReader(input);
                        BufferedReader lineReader = new BufferedReader(streamReader);

                        String message = lineReader.readLine();

                        while (!Objects.equals(message, "exit")) {
                            OutputStream output = clientConnection.getOutputStream();
                            PrintWriter writer = new PrintWriter(output);
                            writer.println(message);
                            writer.flush();
                            message = lineReader.readLine();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        );
       serverThread.start();
    }

}
