import org.junit.Test;

import java.io.*;
import java.net.Socket;

import static junit.framework.TestCase.assertTrue;

public class ClientTest {

    @Test
    public void getInputFromUser() {
        Client client = new Client();

        ConsoleSpy consoleSpy = new ConsoleSpy();
        client.connect(new SocketSpy(), consoleSpy);

        assertTrue(consoleSpy.getInputFromUserWasCalled);
    }

    private class SocketSpy extends Socket {
    }

    private class ConsoleSpy extends Console {


        public boolean getInputFromUserWasCalled = false;


        public String getInputFromUser() {
            getInputFromUserWasCalled = true;
            return "Muy Bien!" ;
        }
    }
}
