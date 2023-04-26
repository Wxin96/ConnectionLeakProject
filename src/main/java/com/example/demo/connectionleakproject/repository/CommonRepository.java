package com.example.demo.connectionleakproject.repository;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author wangxin
 */
@Slf4j
@Component
public class CommonRepository {

    @Resource
    public DataSource dataSource;


    public BigDecimal getBookAvg() {
        BigDecimal avg = null;
        try {
            Connection connection = dataSource.getConnection();
            Statement stmt = connection.createStatement();
            String sql = "select avg(book_price) avg from book";
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                avg = resultSet.getBigDecimal(1);
            }
        } catch (SQLException sqlException) {
            log.error("{}", sqlException);
        }
        return avg;
    }


}
