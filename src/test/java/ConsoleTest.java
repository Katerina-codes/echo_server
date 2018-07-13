import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ConsoleTest {

    @Test
    public void getsInputFromUser() throws IOException {
        ByteArrayInputStream input = new ByteArrayInputStream("Hello there.".getBytes());

        Console console = new Console(input);

        assertEquals("Hello there.", console.getInputFromUser());
    }
}
