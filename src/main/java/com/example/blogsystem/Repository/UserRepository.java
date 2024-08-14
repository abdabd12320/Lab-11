package com.example.blogsystem.Repository;

import com.example.blogsystem.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findUserById(Integer id);

    User findUserByEmail(String email);

    @Query("SELECT u FROM User u ORDER BY u.username ASC")
    List<User> orderUsernameAsc();
}
