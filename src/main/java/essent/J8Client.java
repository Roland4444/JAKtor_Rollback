package essent;
import com.github.kevinsawicki.http.HttpRequest;

import java.io.IOException;

public class J8Client extends Client {
    @Override
    public int send(byte[] serializedMessage, String whom) throws IOException {
        return HttpRequest.post(whom).send(serializedMessage).code();
    }
}

