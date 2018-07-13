class ConsoleSpy extends Console {

    public boolean getInputFromUserWasCalled = false;

    public String getInputFromUser() {
        getInputFromUserWasCalled = true;
        return "Yasss";
    }
}
