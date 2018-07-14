import java.io.*;

public class Console {

    private BufferedReader input;
    private PrintStream output;

    public Console(InputStream input, PrintStream output) {
        this.input = new BufferedReader(new InputStreamReader(input));
        this.output = output;
    }

    public Console() {

    }

    public String getInputFromUser() throws IOException {
       return input.readLine();
    }

    public void printOutputToUser(String echo) {
        output.println(echo);
    }
}
