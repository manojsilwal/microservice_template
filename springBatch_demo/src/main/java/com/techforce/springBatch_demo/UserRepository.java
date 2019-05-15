package com.techforce.springBatch_demo;

import com.techforce.springBatch_demo.springBatch.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
