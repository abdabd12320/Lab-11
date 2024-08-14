package com.example.blogsystem.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotEmpty(message = "username should not be empty")
    @Column(columnDefinition = "VARCHAR(20) NOT NULL")
    private String username;

    @NotEmpty(message = "password should not be empty")
    @Column(columnDefinition = "VARCHAR(20) NOT NULL")
    private String password;

    @NotEmpty(message = "email should not be empty")
    @Email(message = "email should be contain an @ sign")
    @Column(columnDefinition = "VARCHAR(20) NOT NULL UNIQUE")
    private String email;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(columnDefinition = "DATETIME NOT NULL")
    private LocalDateTime registrationDate;
}
