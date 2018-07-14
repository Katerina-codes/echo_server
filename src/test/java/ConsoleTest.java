import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ConsoleTest {

    @Test
    public void getsInputFromUser() throws IOException {
        ByteArrayInputStream input = new ByteArrayInputStream("Hello there.".getBytes());
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        Console console = new Console(input, new PrintStream(output));

        assertEquals("Hello there.", console.getInputFromUser());
    }

    @Test
    public void printsOutputToUser() {
        ByteArrayInputStream input = new ByteArrayInputStream("".getBytes());
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        Console console = new Console(input, new PrintStream(output));

        String echo = "Ciao!";
        console.printOutputToUser(echo);

        assertTrue(output.toString().contains(echo));
    }
}
