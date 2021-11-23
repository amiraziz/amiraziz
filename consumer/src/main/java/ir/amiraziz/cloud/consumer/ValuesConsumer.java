package ir.amiraziz.cloud.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Slf4j
@Component
public class ValuesConsumer {
    private final AccountService accountService;

    public ValuesConsumer(AccountService accountService) {
        this.accountService = accountService;
    }

    @Bean
    public Function<String, String> onReceive() {
        return (message) -> {
            log.info("Received the value {} in Consumer", message);
            return accountService.onReceiveService(message);
        };
    }
}
