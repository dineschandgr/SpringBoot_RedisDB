package com.dineshchand.cache.springbootredis.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dineshchand.cache.springbootredis.model.User;
import com.dineshchand.cache.springbootredis.repository.RedisCustomRepo;

@RestController
@RequestMapping("/redis")
public class RedisResource {
	
	@Autowired
    private RedisCustomRepo userRepository;

    @PostMapping("/adduser")
    public User save(@RequestBody User user){
        userRepository.save(user);
        return user;
    }

    @GetMapping("/findall")
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @GetMapping("/getuser/{id}")
    public User getUser(@PathVariable String id){
        return userRepository.findById(id);
    }

    @PutMapping("/update")
    public User update(@RequestBody User user){
        userRepository.update(user);
        return user;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable String id){
        userRepository.delete(id);
        return id;
    }
}
