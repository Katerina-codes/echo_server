import java.io.*;
import java.net.Socket;

class SocketSpy extends Socket {
    public boolean getOutputStreamWasCalled = false;
    public boolean getInputStreamWasCalled = false;
    private OutputStream outputStream;
    private InputStream inputStream;

    public SocketSpy(ByteArrayOutputStream outputStream, ByteArrayInputStream inputStream) {
         this.outputStream = outputStream;
         this.inputStream = inputStream;
    }

    public OutputStream getOutputStream() {
        getOutputStreamWasCalled = true;
        return outputStream;
    }

    public String getOutputStreamContents() {
       return outputStream.toString();
    }

    public InputStream getInputStream() {
        getInputStreamWasCalled = true;
        return inputStream;
    }

    public int getInputStreamContents() throws IOException {
        return inputStream.available();
    }
}
