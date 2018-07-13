import org.junit.Test;

import java.io.*;
import java.net.Socket;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

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

    @Test
    public void socketStreamContainsInput() {
        Client client = new Client();

        ConsoleSpy consoleSpy = new ConsoleSpy();
        SocketSpy socketSpy = new SocketSpy();
        client.connect(socketSpy, consoleSpy);

        assertEquals("Yasss\n", socketSpy.getOutputStreamContents());
    }


    private class SocketSpy extends Socket {
        public boolean getOutputStreamWasCalled = false;
        private OutputStream outputSream;

        public SocketSpy() {
             outputSream = new ByteArrayOutputStream();
        }

        public OutputStream getOutputStream() {
            getOutputStreamWasCalled = true;
            return outputSream;
        }

        public String getOutputStreamContents() {
           return outputSream.toString();
        }
    }

    private class ConsoleSpy extends Console {

        public boolean getInputFromUserWasCalled = false;

        public String getInputFromUser() {
            getInputFromUserWasCalled = true;
            return "Yasss";
        }
    }
}
