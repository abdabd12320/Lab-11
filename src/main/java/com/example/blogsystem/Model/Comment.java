package com.example.blogsystem.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "content should not be empty")
    @Column(columnDefinition = "VARCHAR(50) NOT NULL")
    private String content;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(columnDefinition = "DATETIME NOT NULL")
    private LocalDateTime commentDate;

    @NotNull(message = "userID should not be null")
    @Column(columnDefinition = "INT NOT NULL")
    private Integer userID;

    @NotNull(message = "postID should not be null")
    @Column(columnDefinition = "INT NOT NULL")
    private Integer postID;

}
