package com.example.main.Dao;


import com.example.main.Entity.Zadanie_prac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Repository("zadanie_pracSql")
public class Zadanie_pracImpl implements Zadanie_pracDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class Zadanie_pracRowMapper implements RowMapper<Zadanie_prac> {

        @Override
        public Zadanie_prac mapRow(ResultSet resultSet, int i) throws SQLException {
            Zadanie_prac zadanie_prac = new Zadanie_prac(resultSet.getInt("id"),
                    resultSet.getInt("id_zglosz"), resultSet.getInt("id_prac"),
                    resultSet.getDouble("czas"));

            return zadanie_prac;
        }
    }

    @Override
    public Collection<Zadanie_prac> getAllZadanie_prac() {
        // select column name from table name
        final String sql = "SELECT * FROM zadania_prac";
        List<Zadanie_prac> zadanie_prac = jdbcTemplate.query(sql, new Zadanie_pracRowMapper());
        return zadanie_prac;
    }


    @Override
    public Zadanie_prac getZadanie_pracById(int id, int id2) {
        // select column name from table namw where column = value
        final String sql = "SELECT * FROM zadania_prac where id_prac=? and id_zglosz=?";
        Zadanie_prac zadanie_prac = jdbcTemplate.queryForObject(sql, new Zadanie_pracRowMapper(), id,id2);
        return zadanie_prac;
    }


    @Override
    public void upadeZadanie_pracById(Zadanie_prac zadanie_prac) {
        //upade table set column=value .... where column=value

        final String sql = "update zadania_prac set id_zglosz=?, id_prac=?,czas=? where (id=?)";
        int id = zadanie_prac.getId();
        int id_prac = zadanie_prac.getId_prac();
        int id_zglosz = zadanie_prac.getId_zglosz();
        Double czas= zadanie_prac.getCzas();
        jdbcTemplate.update(sql, id_zglosz, id_prac,czas, id);


    }

    @Override
    public void removeZadanie_pracById(int id1, int id2) {
//DELETE FROM NAME WHERE COLUMN = VALUE
        final String sql = " delete from zadania_prac where id_zglosz=? AND id_prac=?";
        jdbcTemplate.update(sql, id1,id2);
    }

    @Override
    public void insertZadanie_prac(Zadanie_prac zadanie_prac) {
        //insert into table columns (...) values (...)
        final String sql = "insert into zadania_prac (id,id_prac,id_zglosz,czas) Values (?,?,?,?)";
        final int id = zadanie_prac.getId();
        final int id_prac = zadanie_prac.getId_prac();
        final int id_zglosz = zadanie_prac.getId_zglosz();
        final double czas = zadanie_prac.getCzas();
        jdbcTemplate.update(sql, id, id_prac, id_zglosz,czas);


    }
    @Override
    public int getZadanie_pracCount() {
        final String sql = "SELECT max(id) FROM system.zadania_prac;";
        Number count = jdbcTemplate.queryForObject(
                sql, Integer.class);
        return (count != null ? count.intValue() : 0);
    }


}
