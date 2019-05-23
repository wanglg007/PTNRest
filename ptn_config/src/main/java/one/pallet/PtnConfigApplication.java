package one.pallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PtnConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(PtnConfigApplication.class, args);
    }
}
