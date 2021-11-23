package ir.amiraziz.cloud.producer;

import org.springframework.amqp.AmqpApplicationContextClosedException;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Function;

@RestController
public class ValueController {

    private StreamBridge streamBridge;

    public ValueController(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @GetMapping("values/{value}")
    public ResponseEntity<String> values(@PathVariable String value) {
        streamBridge.send("values-topic", value);
        return ResponseEntity.ok("ok");
    }

    @Bean
    public Function<String, String> receiveResponse() {
        return (value) -> {
            if (true) {
                /*for test maxAttempt in dlq*/
                throw new AmqpApplicationContextClosedException("x");
            }
            return value;
        };
    }
}
