package user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

//推荐使用该注解(兼容eureke zookper)  而不是@EnableEurekaClient(只兼容eureke)
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("user.mapper")
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class);
    }
}
