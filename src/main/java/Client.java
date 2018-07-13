import java.io.*;
import java.net.Socket;

public class Client {

    public void connect(Socket socket, Console console) throws IOException {
        String message = console.getInputFromUser();
        writeMessageToSocket(socket, message);
        String echo = readMessageFromSocket(socket);
        console.printOutputToUser(echo);
    }

    private String readMessageFromSocket(Socket socket) throws IOException {
        InputStream inputStream = socket.getInputStream();
        InputStreamReader streamReader = new InputStreamReader(inputStream);
        BufferedReader lineReader = new BufferedReader(streamReader);
        return lineReader.readLine();
    }

    private void writeMessageToSocket(Socket socket, String message) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(outputStream);
        writer.println(message);
        writer.flush();
    }

}
