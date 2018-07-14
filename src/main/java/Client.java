import java.io.*;
import java.net.Socket;

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
