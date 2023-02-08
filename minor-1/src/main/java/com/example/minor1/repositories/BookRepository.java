package com.example.minor1.repositories;

import com.example.minor1.models.Book;
import com.example.minor1.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer>
{
    // select * from book where name = ?1
    List<Book> findByName(String name);

    // select * from author where book and author where author.name = ?1 and author.id = book.author_id
    List<Book> findByAuthor_Name(String author);

    List<Book> findByGenre(Genre genre);
}
