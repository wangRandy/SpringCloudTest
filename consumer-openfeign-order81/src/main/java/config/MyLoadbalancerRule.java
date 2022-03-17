package config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*Ribbon的自定义配置类不可以放在@ComponentScan所扫描的当前包下以及子包下，
否则这个自定义配置类就会被所有的Ribbon客户端共享，达不到为指定的Ribbon定制配置，
而@SpringBootApplication注解里就有@ComponentScan注解，
所以不可以放在主启动类所在的包下。*/
@Configuration
public class MyLoadbalancerRule {//ribbon负载均衡规则制定
    @Bean
    public IRule myRandomRule(){
        return new RandomRule();    //负载均衡机制改为随机
    }
}
