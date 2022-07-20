package com.example.DGStoer.domain.user.repository;

import com.example.DGStoer.domain.user.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByBindInfraId(String bindInfraId);
}
