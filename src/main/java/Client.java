import java.io.IOException;
import java.net.Socket;

public class Client {

    public void connect(Socket socket, Console console) {
        console.getInputFromUser();
        try {
            socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
