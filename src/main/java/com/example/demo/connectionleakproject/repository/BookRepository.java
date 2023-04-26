package com.example.demo.connectionleakproject.repository;

import com.example.demo.connectionleakproject.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wangxin
 */
@Repository
public interface BookRepository extends JpaRepository<BookEntity, String> {
}
