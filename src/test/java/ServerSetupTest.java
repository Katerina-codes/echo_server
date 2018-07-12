import org.junit.Test;

import java.io.*;
import java.net.Socket;

import static org.junit.Assert.assertEquals;

public class ServerSetupTest {

    @Test
    public void testsClientServerGetsMessage() throws IOException {
        ServerSetup serverSetup = new ServerSetup();

        serverSetup.startServer(1024);
        Socket clientConnection = getAConnectionToServer(1024);
        OutputStream output = clientConnection.getOutputStream();
        output.write("Hello\n".getBytes());

        InputStream input = clientConnection.getInputStream();
        InputStreamReader inputReader = new InputStreamReader(input);
        BufferedReader bufferedReader = new BufferedReader(inputReader);
        String message = bufferedReader.readLine();
        assertEquals("Hello", message);
        clientConnection.close();
    }


    @Test
    public void testServerOutputsNewMessage() throws IOException {
        ServerSetup serverSetup = new ServerSetup();

        serverSetup.startServer(1025);
        Socket clientConnection = getAConnectionToServer(1025);
        OutputStream output = clientConnection.getOutputStream();
        output.write("Bye Bye\n".getBytes());

        InputStream input = clientConnection.getInputStream();
        InputStreamReader inputReader = new InputStreamReader(input);
        BufferedReader bufferedReader = new BufferedReader(inputReader);
        String message = bufferedReader.readLine();
        assertEquals("Bye Bye", message);
        clientConnection.close();
    }

    private Socket getAConnectionToServer(int port) throws IOException {
        return new Socket("localhost", port);
    }
}
