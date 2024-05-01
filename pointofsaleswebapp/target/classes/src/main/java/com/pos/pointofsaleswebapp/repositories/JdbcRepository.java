package com.pos.pointofsaleswebapp.repositories;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class JdbcRepository<T> {

    private final JdbcTemplate jdbcTemplate;

    public JdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<T> findAll(String tableName, Class<T> clazz) {
        String sql = "SELECT * FROM " + tableName;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(clazz));
    }


    public T findById(String tableName, Long id, Class<T> clazz) {
        String sql = "SELECT * FROM " + tableName + " WHERE id = ?";
        RowMapper<T> rowMapper = new BeanPropertyRowMapper<>(clazz);
        List<T> result = jdbcTemplate.query(sql, rowMapper,new Object[]{id});
        return result.isEmpty() ? null : result.get(0);
    }
    
}
