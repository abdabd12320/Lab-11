package com.example.blogsystem.Service;

import com.example.blogsystem.Api.ApiException;
import com.example.blogsystem.Model.Category;
import com.example.blogsystem.Model.User;
import com.example.blogsystem.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsers()
    {
        return userRepository.findAll();
    }
    public void addUser(User user)
    {
        userRepository.save(user);
    }
    public void updateUser(Integer id,User user)
    {
        User u = userRepository.findUserById(id);

        if(u == null)
        {
            throw new ApiException("it is null");
        }
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setEmail(user.getEmail());
        u.setRegistrationDate(user.getRegistrationDate());
        userRepository.save(u);
    }
    public void deleteUser(Integer id)
    {
        if(userRepository.findUserById(id) == null)
        {
            throw new ApiException("it is null");
        }
        userRepository.deleteById(id);
    }
    public User getByEmail(String email)
    {
        if(userRepository.findUserByEmail(email) == null)
        {
            throw new ApiException("email is null");
        }
        return userRepository.findUserByEmail(email);
    }
    public List<User> getUsernamesAsc()
    {
        return userRepository.orderUsernameAsc();
    }
}
