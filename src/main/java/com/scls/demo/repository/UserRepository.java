package com.scls.demo.repository;

import org.springframework.stereotype.Repository;
import com.scls.demo.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // to register
    boolean existsByEmailAddress(String userEmailAddress);

    User findByEmailAddress(String userEmailAddress);
}
