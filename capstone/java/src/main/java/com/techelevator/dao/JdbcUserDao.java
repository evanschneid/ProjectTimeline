package com.techelevator.dao;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.techelevator.model.User;

@Component
public class JdbcUserDao implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    @Override
    public void insertUser(User user) {

    }



    public User getUserByEmail(String email) {
        String sql = "SELECT ismanager, isactivated, userid FROM users WHERE useremail = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, email);
        if (results.next()) {
            User user = new User();
            user.setManager(results.getBoolean("ismanager"));
            user.setActivated(results.getBoolean("isactivated"));
            user.setId(results.getInt("userid"));
            return user;
        } else {
            return null;
        }
    }


    @Override
	public User getUserById(int id) {
		String sql = "SELECT * FROM users WHERE user_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
		if (results.next()) {
			return mapRowToUser(results);
		} else {
			return null;
		}
	}

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(int id) {

    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    public User findByEmail(String email) {
        String sql = "SELECT * FROM users WHERE useremail = ?";
        List<User> users = jdbcTemplate.query(sql, new Object[] { email }, (rs, rowNum) -> {
            User user = new User();
            user.setId((rs.getInt("userid")));
            user.setUserEmail(rs.getString("useremail"));
            user.setManager(rs.getBoolean("ismanager"));
            return user;
        });
        if (users.isEmpty()) {
            return null;
        } else {
            return users.get(0);
        }
    }

    public void save(User user) {
        String sql = "INSERT INTO users (useremail, ismanager, isactivated) VALUES (?,?,?)";
        jdbcTemplate.update(sql, user.getUserEmail(), user.isManager(), user.isActivated());
    }








    @Override
    public boolean createUser() {
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "select * from users";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            User user = mapRowToUser(results);
            users.add(user);
        }

        return users;
    }

    private User mapRowToUser(SqlRowSet rs) {
        User user = new User();
        user.setId(rs.getInt("user_id"));
        //user.setUsername(rs.getString("username"));
        //user.setPassword(rs.getString("password_hash"));
        //user.setAuthorities(Objects.requireNonNull(rs.getString("role")));
        user.setActivated(true);
        return user;
    }


}




//Previous Methods *******************************************************************

/*@Override
    public int findIdByUsername(String username) {
        if (username == null) throw new IllegalArgumentException("Username cannot be null");

        int userId;
        try {
            userId = jdbcTemplate.queryForObject("select user_id from users where username = ?", int.class, username);
        } catch (EmptyResultDataAccessException e) {
            throw new UsernameNotFoundException("User " + username + " was not found.");
        }

        return userId;
    }*/

//    @Override
//    public boolean create(String username, String role) {
//        String insertUserSql = "insert into users (username,password_hash,role) values (?,?,?)";
//        //String password_hash = new BCryptPasswordEncoder().encode(password);
//        String ssRole = role.toUpperCase().startsWith("ROLE_") ? role.toUpperCase() : "ROLE_" + role.toUpperCase();
//
//        return jdbcTemplate.update(insertUserSql, username, password_hash, ssRole) == 1;
//    }


/*
@Override
    public User findByUsername(String username) {
        if (username == null) throw new IllegalArgumentException("Username cannot be null");

        for (User user : this.findAll()) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }
        throw new UsernameNotFoundException("User " + username + " was not found.");
    }

 */

 /*

}

     */