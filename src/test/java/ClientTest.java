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
    public void getsInputFromUser() {
        client.connect(socketSpy, consoleSpy);

        assertTrue(consoleSpy.getInputFromUserWasCalled);
    }

    @Test
    public void callsGetOutputStream() {
        client.connect(socketSpy, consoleSpy);

        assertTrue(socketSpy.getOutputStreamWasCalled);
    }

    @Test
    public void socketStreamContainsInput() {
        client.connect(socketSpy, consoleSpy);

        assertEquals("Yasss\n", socketSpy.getOutputStreamContents());
    }

    @Test
    public void getsInputStream() {
        client.connect(socketSpy, consoleSpy);

        assertTrue(socketSpy.getInputStreamWasCalled);
    }

    @Test
    public void getsInputStreamContents() throws IOException {
        client.connect(socketSpy, consoleSpy);

        assertEquals(0, socketSpy.getInputStreamContents());
    }
}
