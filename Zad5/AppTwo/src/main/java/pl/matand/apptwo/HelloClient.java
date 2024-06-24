package pl.matand.apptwo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "HelloService", url = "http://localhost:8080")
public interface HelloClient {
    @GetMapping("/helloPass")
    String getHelloMessagePass();

    @GetMapping("/helloFail")
    String getHelloMessageFail();
}