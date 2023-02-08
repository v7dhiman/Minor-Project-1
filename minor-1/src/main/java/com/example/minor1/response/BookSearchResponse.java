package com.example.minor1.response;

import com.example.minor1.models.Author;
import com.example.minor1.models.Genre;
import com.example.minor1.models.Student;
import com.example.minor1.models.Transaction;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookSearchResponse
{
    private int id;
    private String name;
    private int cost;
    private Genre genre;

    @JsonIgnoreProperties("bookList")
    private Author author;

    private Student student;


    private List<Transaction> transactionList;
    private Date createdOn;
    private Date updatedOn;

}
