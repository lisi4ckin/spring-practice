package com.todo.springtodo.repositories;

import com.todo.springtodo.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<Users, Long> {
    @Query("select user from Users user where user.profile.id=:id")
    Users userByProfileId(@Param("id") Long id);

    @Query("select user from Users user where user.login=:login")
    Users userByLogin(@Param("login") String login);
}
