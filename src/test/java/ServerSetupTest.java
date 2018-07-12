import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import static org.junit.Assert.assertEquals;

public class ServerSetupTest {

    @Test
    public void testsClientServerGetsMessage() throws IOException {
        ServerSetup serverSetup = new ServerSetup();

        serverSetup.startServer(1024);
        Socket clientConnection = getAConnectionToServer();

        InputStream input = clientConnection.getInputStream();
        InputStreamReader inputReader = new InputStreamReader(input);
        BufferedReader bufferedReader = new BufferedReader(inputReader);
        String message = bufferedReader.readLine();
        assertEquals("Hello", message);
        clientConnection.close();
    }

    private Socket getAConnectionToServer() throws IOException {
        return new Socket("localhost", 1024);
    }
}
