package com.example.blogsystem.Controller;

import com.example.blogsystem.Model.User;
import com.example.blogsystem.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v3/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getUsers()
    {
        return ResponseEntity.status(200).body(userService.getUsers());
    }
    @PostMapping("/add")
    public ResponseEntity addUser(@Valid@RequestBody User user, Errors errors)
    {
        if(errors.hasErrors())
        {
            String m = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(m);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body("User added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id,@Valid@RequestBody User user,Errors errors)
    {
        if(errors.hasErrors())
        {
            String m = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(m);
        }
        userService.updateUser(id, user);
        return ResponseEntity.status(200).body("User updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id)
    {
        userService.deleteUser(id);
        return ResponseEntity.status(200).body("User deleted");
    }
    @GetMapping("/get-by-email/{email}")
    public ResponseEntity getByEmail(@PathVariable String email)
    {
        return ResponseEntity.status(200).body(userService.getByEmail(email));
    }
    @GetMapping("/get-username-order-by-asc")
    public ResponseEntity getUsernameOrderByAsc()
    {
        return ResponseEntity.status(200).body(userService.getUsernamesAsc());
    }
}
