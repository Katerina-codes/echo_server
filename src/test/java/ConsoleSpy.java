class ConsoleSpy extends Console {

    public boolean getInputFromUserWasCalled = false;
    public boolean printOutputToUserWasCalled = false;

    public String getInputFromUser() {
        getInputFromUserWasCalled = true;
        return "Yasss";
    }

    public void printOutputToUser(String echo) {
       printOutputToUserWasCalled = true;
    }
}
