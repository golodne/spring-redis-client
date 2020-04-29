package ru.learnredis.springredisclient.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.learnredis.springredisclient.model.User;
import ru.learnredis.springredisclient.repository.UserRepository;

import java.util.Map;

@RestController
@RequestMapping("/rest/user")
public class UserController {

    UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/add/{id}/{name}")
    public User add(@PathVariable("id") final String id,
                    @PathVariable("name") final String name) {
        userRepository.save(new User(id,name,2000L));
        return userRepository.findById(id);
    }

    @GetMapping("/update/{id}/{name}")
    public User update(@PathVariable("id") final String id,
                       @PathVariable("name") final String name) {
        userRepository.update(new User(id,name,1000L));
        return userRepository.findById(id);
    }

    @GetMapping("/all")
    public Map<String, User> all() {
        return userRepository.findAll();
    }



}
