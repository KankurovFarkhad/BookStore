package com.halyk.bookstore.data.repository.user;

import com.halyk.bookstore.data.entity.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);

    User findUserByUsername(String login);

}

