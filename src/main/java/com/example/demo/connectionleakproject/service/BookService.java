package com.example.demo.connectionleakproject.service;

import com.example.demo.connectionleakproject.entity.BookEntity;
import com.example.demo.connectionleakproject.repository.BookRepository;
import com.example.demo.connectionleakproject.repository.CommonRepository;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author wangxin
 */
@Service
public class BookService {

    @Resource
    private BookRepository bookRepository;

    @Resource
    private CommonRepository commonRepository;

    @Resource
    private HikariDataSource hikariDataSource;

    public List<BookEntity> getAll() {
        return bookRepository.findAll();
    }

    public BigDecimal getAvg() {
        return commonRepository.getBookAvg();
    }

    public DataSource getDataSource() {
        return hikariDataSource;
    }


}
