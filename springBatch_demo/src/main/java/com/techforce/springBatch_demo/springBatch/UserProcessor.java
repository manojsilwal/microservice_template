package com.techforce.springBatch_demo.springBatch;

import com.techforce.springBatch_demo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class UserProcessor implements ItemProcessor<User, User> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User process(User user) {
        //update db if user already exist Name to uppercase
        Optional<User> userById = userRepository.findById(user.getUserId());
        userById.ifPresent(user1 -> user.setAccount(user.getAccount().add(user1.getAccount())));
        return user;
    }
}
