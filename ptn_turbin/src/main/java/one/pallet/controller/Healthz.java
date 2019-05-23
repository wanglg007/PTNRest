package one.pallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class Healthz {

    @Value("${spring.application.name}")
    private String serviceId;

    @Autowired
    private LoadBalancerClient loadBalancer;


    @GetMapping(path = "/healthz",produces = MediaType.TEXT_PLAIN_VALUE)
    public String healthz(){
        return "ok";
    }

    @GetMapping(path = "/getHost",produces = MediaType.TEXT_PLAIN_VALUE)
    public String getHost(){
        ServiceInstance instance = loadBalancer.choose(serviceId);
        return instance.getHost();
    }
}
