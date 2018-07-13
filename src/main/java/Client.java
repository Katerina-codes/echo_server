import java.io.*;
import java.net.Socket;

public class Client {

    public void connect(Socket socket, Console console) {
        String message = console.getInputFromUser();
        String echo = null;
        try {
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream);
            writer.println(message);
            writer.flush();

            InputStream inputStream = socket.getInputStream();
            InputStreamReader streamReader = new InputStreamReader(inputStream);
            BufferedReader lineReader = new BufferedReader(streamReader);
            echo = lineReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        console.printOutputToUser(echo);
    }

}
