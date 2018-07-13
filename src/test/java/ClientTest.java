import org.junit.Test;

import java.io.*;
import java.net.Socket;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class ClientTest {

    @Test
    public void getInputFromUserAndCallsGetOutputStream() {
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

    @Test
    public void getsInputStream() {
        Client client = new Client();

        ConsoleSpy consoleSpy = new ConsoleSpy();
        SocketSpy socketSpy = new SocketSpy();
        client.connect(socketSpy, consoleSpy);

        assertTrue(socketSpy.getInputStreamWasCalled);
    }

    private class SocketSpy extends Socket {
        public boolean getOutputStreamWasCalled = false;
        public boolean getInputStreamWasCalled = false;
        private OutputStream outputStream;
        private InputStream inputStream;

        public SocketSpy() {
             outputStream = new ByteArrayOutputStream();
             inputStream = new ByteArrayInputStream("".getBytes());
        }

        public OutputStream getOutputStream() {
            getOutputStreamWasCalled = true;
            return outputStream;
        }

        public String getOutputStreamContents() {
           return outputStream.toString();
        }

        public InputStream getInputStream() {
            getInputStreamWasCalled = true;
            return inputStream;
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
