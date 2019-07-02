package comaaa.test;

import comaaa.config.TestConfig;
import comaaa.pojo.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
//@PropertySource("classpath:person.properties")
@ImportResource("classpath:spring.xml")
@Import(TestConfig.class)
public class PersonConfig {
    @Value("${user.tel}")
    private String tel;
    @Bean
    public Person person() {
        System.out.println(tel);
        return new Person();
    }



}
