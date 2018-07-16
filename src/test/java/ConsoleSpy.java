import java.util.LinkedList;
import java.util.List;

class ConsoleSpy extends Console {

    public boolean getInputFromUserWasCalled = false;
    public boolean printOutputToUserWasCalled = false;
    private String echo;
    private LinkedList<String> userInput;

    public ConsoleSpy(List<String> userInput) {
        this.userInput = new LinkedList<>(userInput);
    }

    public String getInputFromUser() {
        getInputFromUserWasCalled = true;
        return userInput.pop();
    }

    public void printOutputToUser(String echo) {
        this.echo = echo;
        printOutputToUserWasCalled = true;
    }

    public String getOutputPrintedToUser() {
        return echo;
    }
}
