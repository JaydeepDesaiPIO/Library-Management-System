package com.spring.repositories;

import com.spring.entities.IssueBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueBookRepository extends JpaRepository<IssueBook,Integer> {
}
