package aaa;

import comaaa.pojo.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootTestApplication {
    
//    @Autowired
//    private Person person;
//
//    @Bean
//    public Person person() {
//        return new Person();
//    }

//    @Bean
//    public StringRedisTemplate stringRedisTemplate() {
//        return new StringRedisTemplate();
//    }

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    
    
    @Test
    public void test() {
//        System.out.println(person);
        System.out.println(123);
    }

    @Test
    public void testStringRedisTemplate() {
        Set<String> keys = stringRedisTemplate.keys("*");
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    
}
