package com.spring.repositories;

import com.spring.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

   @Query(value = " SELECT * FROM datasource1.books where available=TRUE", nativeQuery = true)
   List<Book> findAllAvailable();
}
