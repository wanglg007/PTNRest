package one.pallet;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableAdminServer
@EnableEurekaClient
@SpringBootApplication
public class PtnMontorApplication {

    public static void main(String[] args) {
        SpringApplication.run(PtnMontorApplication.class, args);
    }

}
