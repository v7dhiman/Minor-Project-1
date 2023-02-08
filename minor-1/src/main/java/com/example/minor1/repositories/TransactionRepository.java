package com.example.minor1.repositories;

import com.example.minor1.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>
{

}
