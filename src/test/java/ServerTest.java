import org.junit.Test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static org.junit.Assert.assertTrue;

public class ServerTest {

    public class ServerSocketSpy extends ServerSocket {

        private boolean acceptWasCalled = false;

        public ServerSocketSpy() throws IOException {
        }

        public Socket accept() {
            acceptWasCalled = true;
            return new Socket();
        }
    }

    @Test
    public void createsClientSocketOnServer() throws IOException {
        Server server = new Server();
        ServerSocketSpy serverSocketSpy = new ServerSocketSpy();
        server.run(serverSocketSpy);

        assertTrue(serverSocketSpy.acceptWasCalled);
    }
}
