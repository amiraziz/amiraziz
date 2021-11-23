package ir.jiring.downlowded.cloud.demo;

import org.springframework.stereotype.Component;

@Component
public class AccountService {

    public String onReceiveService(String input) {
        return input.concat(" Input");
    }
}
