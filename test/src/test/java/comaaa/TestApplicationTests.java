package comaaa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplicationTests {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testStringRedisTemplate() {
        Set<String> keys = stringRedisTemplate.keys("*");
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

//    public void testApplication() {
//        SpringApplication application = new SpringApplication(this.getClass());
//        application.
//    }
}
