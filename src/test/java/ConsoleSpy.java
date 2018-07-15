class ConsoleSpy extends Console {

    public boolean getInputFromUserWasCalled = false;
    public boolean printOutputToUserWasCalled = false;
    private String echo;

    public String getInputFromUser() {
        getInputFromUserWasCalled = true;
        return "exit";
    }

    public void printOutputToUser(String echo) {
        this.echo = echo;
        printOutputToUserWasCalled = true;
    }

    public String getOutputPrintedToUser() {
        return echo;
    }
}
