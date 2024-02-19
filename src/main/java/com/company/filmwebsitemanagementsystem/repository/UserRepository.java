package com.company.filmwebsitemanagementsystem.repository;

import com.company.filmwebsitemanagementsystem.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Query("update User set active = false where id=:id")
    void deleteUserById(long id);
}
