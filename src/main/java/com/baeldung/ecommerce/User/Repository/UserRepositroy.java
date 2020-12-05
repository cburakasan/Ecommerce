package com.baeldung.ecommerce.User.Repository;

import com.baeldung.ecommerce.User.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositroy extends JpaRepository<User,Long> {
    User findByEmailAndPassword(String email,String password);
}
