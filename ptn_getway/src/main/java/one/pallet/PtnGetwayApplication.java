package one.pallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PtnGetwayApplication {

    public static void main(String[] args) {
        SpringApplication.run(PtnGetwayApplication.class, args);
    }
}
