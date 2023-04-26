package com.example.demo.connectionleakproject.controller;

import com.example.demo.connectionleakproject.entity.BookEntity;
import com.example.demo.connectionleakproject.service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author wangxin
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class BookController {


    @Resource
    private BookService bookService;


    @GetMapping("/books")
    public List<BookEntity> getAll() {
        List<BookEntity> books = bookService.getAll();
        log.info("GetAll: books retrieved: {}", books);
        return books;
    }

    @GetMapping("/getAvg")
    public BigDecimal getAvg() {
        BigDecimal avg = bookService.getAvg();
        log.info("Book avg privce: {}", avg);
        return avg;
    }

    @GetMapping("/getInfo")
    public String getInfo() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            log.info("Current Service Class: {}", objectMapper.writeValueAsString(bookService));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return "书籍业务类";
    }



}
