package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.mapper.UserMapper;
import user.pojo.User;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User queryById(Long id){
        return userMapper.selectByPrimaryKey(id);
    }

    public List<User>  query(){
        List<User> users = userMapper.selectAll();
        return users;
    }
}
