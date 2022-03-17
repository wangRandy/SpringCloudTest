package config;

/*import org.springframework.cloud.client.loadbalancer.LoadBalanced;*/
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {
    //往容器中加一个RestTemplate
    //RestTemplate提供了多种访问远程http访问的方法
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
