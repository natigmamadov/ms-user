package com.example.ms.user.dao.repository;

import com.example.ms.user.dao.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity,Long> {
    Optional<UserEntity> findByEmail(String email);
}
