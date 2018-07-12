import org.junit.Test;

import java.io.*;
import java.net.Socket;

import static junit.framework.TestCase.assertTrue;

public class ClientTest {

    @Test
    public void getInputFromUser() {
        Client client = new Client();

        ConsoleSpy consoleSpy = new ConsoleSpy();
        SocketSpy socketSpy = new SocketSpy();
        client.connect(socketSpy, consoleSpy);

        assertTrue(consoleSpy.getInputFromUserWasCalled);
        assertTrue(socketSpy.getOutputStreamWasCalled);
    }

    private class SocketSpy extends Socket {
        public boolean getOutputStreamWasCalled = false;

        public OutputStream getOutputStream() {
            getOutputStreamWasCalled = true;
            return null;
        }
    }

    private class ConsoleSpy extends Console {


        public boolean getInputFromUserWasCalled = false;


        public String getInputFromUser() {
            getInputFromUserWasCalled = true;
            return null;
        }
    }
}
