import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

class SocketSpy extends Socket {
    public boolean getOutputStreamWasCalled = false;
    public boolean getInputStreamWasCalled = false;
    private OutputStream outputStream;
    private InputStream inputStream;

    public SocketSpy() {
         outputStream = new ByteArrayOutputStream();
         inputStream = new ByteArrayInputStream("".getBytes());
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
}
