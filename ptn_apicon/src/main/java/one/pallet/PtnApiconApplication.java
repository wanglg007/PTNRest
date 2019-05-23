package one.pallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PtnApiconApplication {

    public static void main(String[] args) {
        SpringApplication.run(PtnApiconApplication.class, args);
    }
}
