package cn.algerfan.springboot.contorller;

import cn.algerfan.springboot.pojo.User;
import cn.algerfan.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        Optional<User> byId = userRepository.findById(id);
        return byId.get();
    }

    @GetMapping("/user")
    public User insertUser(User user) {
        return userRepository.save(user);
    }

}
