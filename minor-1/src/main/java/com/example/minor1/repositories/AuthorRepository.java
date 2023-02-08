package com.example.minor1.repositories;

import com.example.minor1.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer>
{
    /**
     * Native query
     * JPQL --> Java persistence query language
     * Don't have to write to query ...
     */

    @Query(value = "select a from author a where a.email = ?1", nativeQuery = true)
    public Author getAuthorGivenEmailIdNativeQuery(String myemail);

    @Query("select a from Author a where a.email = ?1")
    public Author getAuthorGivenEmailIdJPQL(String myemail);

    //You need to find all the authors in India
    @Query(value = "select a from author a where a.land = ?1", nativeQuery = true)
    public List<Author> getAuthorsByCountry(String country);

    @Query("select a from Author a where a.country = ?1")
    public List<Author> getAuthorsByCountryJPQL(String country);

    public Author findByEmail(String email);

    // you have to find all the authors above the age of 30, living in India and
    // Their name starts with A

    List<Author> findByAgeGreaterThanEqualAndCountryAndNameStartingWith(int age, String country, String prefix);

    // select * from author where age >= ?1 and country = ?2 and name like ?3%

}