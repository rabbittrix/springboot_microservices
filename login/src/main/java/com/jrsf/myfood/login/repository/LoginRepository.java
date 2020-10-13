package com.jrsf.myfood.login.repository;

import com.jrsf.myfood.login.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {

    @Query("select l from Login l where l.email = ?1 and l.password = ?2")
    Optional<Login> findByEmailAndPassword(String email, String password);
}
