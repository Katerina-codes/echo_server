import java.io.*;
import java.net.Socket;
import java.util.Objects;

public class Client {

    public static void main(String[] args) {
        Client client = new Client();
        try {
            Console console = new Console(System.in, System.out);
            Socket socket = new Socket("localhost", 8080);
            client.connect(socket, console);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void connect(Socket socket, Console console) throws IOException {
        String message = "";
        while (!Objects.equals(message, "exit")) {
            message = console.getInputFromUser();
            writeMessageToSocket(socket, message);
            String echo = readMessageFromSocket(socket);
            console.printOutputToUser(echo);
        }
    }

    private String readMessageFromSocket(Socket socket) throws IOException {
        InputStream inputStream = socket.getInputStream();
        InputStreamReader streamReader = new InputStreamReader(inputStream);
        BufferedReader lineReader = new BufferedReader(streamReader);
        String message = lineReader.readLine();
        return checkUserInput(message);
    }

    private String checkUserInput(String message) {
        if (message == null) {
            return "exit";
        }
        return message;
    }

    private void writeMessageToSocket(Socket socket, String message) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(outputStream);
        writer.println(message);
        writer.flush();
    }

}
