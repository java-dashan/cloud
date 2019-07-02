package comaaa.controller;

import comaaa.pojo.Person;
import comaaa.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.Set;

@RestController
@RequestMapping("/test")
public class testController {

    @Autowired
    private Person person;
    @Autowired
    private User user;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
//    @Autowired
//    private TestConfig testConfig;

    @GetMapping
    public Person p() {
        System.out.println(person);
        return person;
    }

    @GetMapping("/user")
    public User u() {
        return user;
    }

//    @GetMapping("/import")
//    public TestConfig t() {
//        return testConfig;
//    }

    @GetMapping("/redis")
    public void redis() {
        Set<String> keys = stringRedisTemplate.keys("*");
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
