import java.io.ByteArrayInputStream;

class ConsoleSpy extends Console {

    public boolean getInputFromUserWasCalled = false;
    public boolean printOutputToUserWasCalled = false;

    public ConsoleSpy(ByteArrayInputStream input) {
        super(input);
    }

    public ConsoleSpy() {
        super();
    }

    public String getInputFromUser() {
        getInputFromUserWasCalled = true;
        return "Yasss";
    }

    public void printOutputToUser(String echo) {
       printOutputToUserWasCalled = true;
    }
}
