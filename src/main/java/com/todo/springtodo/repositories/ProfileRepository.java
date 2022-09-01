package com.todo.springtodo.repositories;

import com.todo.springtodo.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    @Query("select profile.id from Profile profile inner join Users as user where user.login=:login")
    Long getProfileId(@Param("login") String login);
}
