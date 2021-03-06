import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class ClientTest {

    private Client client;
    private ConsoleSpy consoleSpy;
    private SocketSpy socketSpy;

    @Before
    public void setUp() {
        client = new Client();
        consoleSpy = new ConsoleSpy(Collections.singletonList("exit"));
        socketSpy = new SocketSpy(new ByteArrayOutputStream(), new ByteArrayInputStream("Hi\n".getBytes()));
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

    @Test
    public void handleUserEnteringExit() throws IOException {
        SocketSpy socketSpy = new SocketSpy(new ByteArrayOutputStream(), new ByteArrayInputStream("".getBytes()));

        client.connect(socketSpy, consoleSpy);

        assertEquals("exit", consoleSpy.getOutputPrintedToUser());
    }

    @Test
    public void handlesEmptyUserInputFromTheConsole() throws IOException {
        SocketSpy socketSpy = new SocketSpy(new ByteArrayOutputStream(), new ByteArrayInputStream("".getBytes()));
        List userInputOptions = asList(null, "exit");
        ConsoleSpy consoleSpy = new ConsoleSpy(userInputOptions);

        client.connect(socketSpy, consoleSpy);

        assertEquals("exit", consoleSpy.getOutputPrintedToUser());
    }
}
