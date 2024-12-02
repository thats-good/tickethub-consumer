package com.example.tickethub_consumer.dataAccess.dao;

import com.example.tickethub_consumer.application.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(Long userId);
}
