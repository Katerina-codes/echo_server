import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    public void run(ServerSocket serverSocket) throws IOException {
        serverSocket.accept();
    }

}
