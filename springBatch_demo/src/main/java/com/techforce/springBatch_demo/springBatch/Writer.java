package com.techforce.springBatch_demo.springBatch;

import com.techforce.springBatch_demo.UserRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Component
public class Writer implements ItemWriter<User> {

    @Autowired
    private UserRepository repo;

    @Override
    @Transactional
    public void write(List<? extends User> users) {
        repo.saveAll(users);
    }

}
