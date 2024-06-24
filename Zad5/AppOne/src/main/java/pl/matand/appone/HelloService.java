package pl.matand.appone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    private final CommunicationClient communicationClient;

    @Autowired
    public HelloService(CommunicationClient communicationClient) {
        this.communicationClient = communicationClient;
    }

    public String fetchHelloMessagePass() {
        String response = communicationClient.getHelloMessagePass();
        if ("Cześć to ja".equals(response)) {
            return "Odpowiedź jest zgodna: " + response;
        } else {
            return "Odpowiedź nie jest zgodna";
        }
    }
    public String fetchHelloMessageFail() {
        String response = communicationClient.getHelloMessageFail();
        if ("Cześć to ja".equals(response)) {
            return "Odpowiedź jest zgodna: " + response;
        } else {
            return "Odpowiedź nie jest zgodna";
        }
    }
}