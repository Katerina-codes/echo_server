# Echo Server

This is an echo server program.

The first program creates a socket on the server. The socket waits for a client socket to connect to it then it for some kind of request, server socket it is waiting for some text.

When **gradle runClient** is run, the client creates a socket on the same port that the server socket has been created on.
The user is then prompted to enter some input and this input is written to the socket stream and passed to the server.

The server socket then retrieves the input from the input stream and writes what it receives back to the output stream. This is why the program is called an "echo server", when you type some input, your input will then be echoed back to you.


## Running the program:

To run the program, start the server by typing the following in your command line:

**gradle runServer**

To start running the client, open another command line window then run the following:

**gradle runClient**


## Run the tests

Right now the tests are from within Intellij.