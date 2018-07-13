import java.io.*;
import java.net.Socket;

public class Client {

    public void connect(Socket socket, Console console) {
        String message = console.getInputFromUser();
        try {
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream);
            writer.println(message);
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
