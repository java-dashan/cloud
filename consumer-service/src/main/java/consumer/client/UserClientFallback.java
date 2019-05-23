package consumer.client;

import consumer.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements UserClient {
    @Override
    public User queryById(Long id) {
        User user=new User();
        return user;
    }
}
