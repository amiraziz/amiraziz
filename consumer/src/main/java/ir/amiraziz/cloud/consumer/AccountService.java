package ir.amiraziz.cloud.consumer;

import org.springframework.stereotype.Component;

@Component
public class AccountService {

    public String onReceiveService(String input) {
        return input.concat(" Input");
    }
}
