package ru.learnredis.springredisclient.repository;

import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import ru.learnredis.springredisclient.model.User;

import javax.annotation.PostConstruct;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private RedisTemplate<String, User> restTemplate;
    private HashOperations hashOperations;

    public UserRepositoryImpl(RedisTemplate<String, User> restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostConstruct
    private void init(){
        hashOperations = restTemplate.opsForHash();
    }

    @Override
    public void save(User user) {
        hashOperations.put("USER", user.getId(),user);
    }

    @Override
    public Map<String, User> findAll() {
        return hashOperations.entries("USER");
    }

    @Override
    public User findById(String id) {
        return (User)hashOperations.get("USER", id);
    }

    @Override
    public void update(User user) {
        save(user);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete("USER", id);
    }
}
