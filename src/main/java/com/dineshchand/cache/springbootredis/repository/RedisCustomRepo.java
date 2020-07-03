package com.dineshchand.cache.springbootredis.repository;

import java.util.List;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.dineshchand.cache.springbootredis.model.User;

@Repository
public class RedisCustomRepo {

    private HashOperations hashOperations;

    private RedisTemplate redisTemplate;

    public RedisCustomRepo(RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
        this.hashOperations = this.redisTemplate.opsForHash();
    }

    public void save(User user){
        hashOperations.put("USER", user.getId(), user);
    }
    public List<User> findAll(){
        return hashOperations.values("USER");
    }

    public User findById(String id){
        return (User) hashOperations.get("USER", id);
    }

    public void update(User user){
        save(user);
    }

    public void delete(String id){
        hashOperations.delete("USER", id);
    }

    public List<User> multiGetUsers(List<String> userIds){
        return hashOperations.multiGet("USER", userIds);
    }
}
