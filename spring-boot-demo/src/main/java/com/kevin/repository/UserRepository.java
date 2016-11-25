package com.kevin.repository;

import com.kevin.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kevin on 16/11/18.
 */
public interface UserRepository extends CrudRepository<User, String> {
    User findByName(String name);
}
