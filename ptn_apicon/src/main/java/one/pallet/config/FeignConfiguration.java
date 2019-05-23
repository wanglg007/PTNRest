package one.pallet.config;

import feign.Feign;
import feign.Logger;
import feign.Request;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class FeignConfiguration {
    public static int connectTimeOutMillis = 12000; //超时时间
    public static int readTimeOutMillis    = 12000;

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    //设置默认超时时间
    @Bean
    public Request.Options options() {
        return new Request.Options(connectTimeOutMillis, readTimeOutMillis);
    }

    //自定义重试次数
    @Bean
    public Retryer feignRetryer(){
        Retryer retryer = new Retryer.Default(100, 1000, 4);
        return retryer;
    }

    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }

}
