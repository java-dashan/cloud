package zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy   //兼容各种过滤器 而@zuulserver不行
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class);
    }
}
