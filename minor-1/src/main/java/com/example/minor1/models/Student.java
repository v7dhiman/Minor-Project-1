package com.example.minor1.models;

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
@ToString
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(unique = true, nullable = false)
    private String contact;

    private String address;

    @Column(unique = true)
    private String email;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updateOn;

    @OneToMany(mappedBy = "student")
    private List<Book> bookList;

    @OneToMany(mappedBy = "my_student")
    private List<Transaction> transactionList;

    @Enumerated(value = EnumType.STRING)
    private AccountStatus accountStatus;



//    private List<Transaction> transactionList;
//
//    private StudentAccount studentAccount;
}

/**
 * 1. OneToOne
 * 2. OneToMany
 * 3. ManyToOne
 * 4. ManyToMany
 */

// select * from student where id = ? normal flow
// select * from book where student_id = ? --> hibernate