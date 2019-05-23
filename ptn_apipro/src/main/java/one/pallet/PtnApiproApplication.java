package one.pallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 备注：
 * （1）http://localhost:8769/actuator/health 可以得到监控的健康状态
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PtnApiproApplication {

    public static void main(String[] args) {
        SpringApplication.run(PtnApiproApplication.class, args);
    }
}
