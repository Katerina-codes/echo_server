import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class ClientTest {

    private Client client;
    private ConsoleSpy consoleSpy;
    private SocketSpy socketSpy;

    @Before
    public void setUp() {
        client = new Client();
        consoleSpy = new ConsoleSpy();
        socketSpy = new SocketSpy();
    }

    @Test
    public void callsGetInputFromUser() throws IOException {
        client.connect(socketSpy, consoleSpy);

        assertTrue(consoleSpy.getInputFromUserWasCalled);
    }

    @Test
    public void callsGetOutputStream() throws IOException {
        client.connect(socketSpy, consoleSpy);

        assertTrue(socketSpy.getOutputStreamWasCalled);
    }

    @Test
    public void writesInputToOutputStream() throws IOException {
        client.connect(socketSpy, consoleSpy);

        assertEquals("exit\n", socketSpy.getOutputStreamContents());
    }

    @Test
    public void callsGetInputStream() throws IOException {
        client.connect(socketSpy, consoleSpy);

        assertTrue(socketSpy.getInputStreamWasCalled);
    }

    @Test
    public void getsInputStreamContents() throws IOException {
        client.connect(socketSpy, consoleSpy);

        assertEquals(0, socketSpy.getInputStreamContents());
    }

    @Test
    public void callsPrintOutputToUser() throws IOException {
        client.connect(socketSpy, consoleSpy);

        assertTrue(consoleSpy.printOutputToUserWasCalled);
    }
}
