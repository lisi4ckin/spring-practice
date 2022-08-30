package com.todo.springtodo.repositories;

import com.todo.springtodo.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
