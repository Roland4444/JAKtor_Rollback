package essent;

import java.io.IOException;


public abstract class Client {
    abstract public int send(byte[] serializedMessage, String whom) throws IOException;
}
