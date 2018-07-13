import java.io.*;

public class Console {

    private BufferedReader input;

    public Console(ByteArrayInputStream input) {
        this.input = new BufferedReader(new InputStreamReader(input));
    }

    public Console() {
    }

    public String getInputFromUser() throws IOException {
       return input.readLine();
    }

    public void printOutputToUser(String echo) {
    }
}
