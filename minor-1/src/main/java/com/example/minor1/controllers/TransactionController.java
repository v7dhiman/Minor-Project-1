package com.example.minor1.controllers;

import com.example.minor1.exceptions.TxnServiceException;
import com.example.minor1.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController
{
    @Autowired
    TransactionService transactionService;

    @PostMapping("transaction/issue")
    public String issueTxn(@RequestParam("studentId") int studentId, @RequestParam("bookId") int bookId) throws TxnServiceException {
        return transactionService.issueTxn(studentId, bookId);
    }
}
