package com.example.minor1.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private TransactionType transactionType;

    private double payment;

    @ManyToOne
    @JoinColumn
    private Book my_book;

    @ManyToOne
    @JoinColumn
    private Student my_student;

    private Date transactionDate;

    private String externalTxnId;
}
