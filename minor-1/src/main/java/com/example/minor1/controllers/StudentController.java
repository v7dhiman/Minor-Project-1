package com.example.minor1.controllers;

import com.example.minor1.models.Book;
import com.example.minor1.request.BookFilterType;
import com.example.minor1.request.StudentCreateRequest;
import com.example.minor1.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentController
{
    @Autowired
    StudentService studentService;

    @PostMapping("/student")
    public void createStudent(@Valid @RequestBody StudentCreateRequest studentCreateRequest)
    {
        studentService.create(studentCreateRequest);
    }


    //GET - filter functionality / search
}
