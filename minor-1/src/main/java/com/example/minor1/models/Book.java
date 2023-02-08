package com.example.minor1.models;

import com.example.minor1.response.BookSearchResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int cost;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    @ManyToOne
    @JoinColumn
    private Student student;

    @OneToMany(mappedBy = "my_book")
    private List<Transaction> transactionList;

    @ManyToOne
    @JoinColumn
    private Author author;
    // Just for explanation of back reference
    //private Student tempColumn;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    public BookSearchResponse to()
    {
        return BookSearchResponse.builder()
                .id(id)
                .name(name)
                .author(author)
                .cost(cost)
                .genre(genre)
                .student(student)
                .transactionList(transactionList)
                .createdOn(createdOn)
                .updatedOn(updatedOn)
                .build();
    }
}
