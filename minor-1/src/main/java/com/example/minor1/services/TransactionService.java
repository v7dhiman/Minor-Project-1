package com.example.minor1.services;

import com.example.minor1.exceptions.TxnServiceException;
import com.example.minor1.models.Book;
import com.example.minor1.models.Student;
import com.example.minor1.models.Transaction;
import com.example.minor1.models.TransactionType;
import com.example.minor1.repositories.TransactionRepository;
import com.example.minor1.request.BookFilterType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService
{
    @Autowired
    StudentService studentService;

    @Autowired
    BookService bookService;

    @Autowired
    TransactionRepository transactionRepository;

    @Transactional
    public String issueTxn(int studentId, int bookId) throws TxnServiceException {
        // Student exists or not
        // Book is present and is available
        // Create a transaction --> Saving in the Txn DB
        // Make the book unavailable
        Student student = studentService.findByStudentById(studentId);

        if(student == null)
        {
            throw new TxnServiceException("Student not present in the library");
        }

        List<Book> books = bookService.find(BookFilterType.BOOK_ID, String.valueOf(bookId));

        if(books == null || books.size() != 1 || books.get(0).getStudent() != null)
        {
            throw new TxnServiceException("Book not present in the library");
        }
//        Book book = books.get(0);
//
//        if(book.getStudent() != null)
//        {
//            throw new TxnServiceException("Book is already issued to someone else");
//        }
        Transaction transaction = Transaction.builder()
                .externalTxnId(UUID.randomUUID().toString())
                .transactionType(TransactionType.ISSUE)
                .payment(books.get(0).getCost())
                .my_book(books.get(0))
                .my_student(student)
                .build();

        transactionRepository.save(transaction);
        books.get(0).setStudent(student);
        bookService.create(books.get(0));

        return transaction.getExternalTxnId();
    }
    public void returnTxn()
    {

    }
}

/*
1. Issue --> cost
2. Return --> fine
 */