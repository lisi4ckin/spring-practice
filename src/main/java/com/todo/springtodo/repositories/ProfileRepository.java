package com.todo.springtodo.repositories;

import com.todo.springtodo.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
