package com.itMentor.Task8.repository;

import com.itMentor.Task8.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    void deleteUserById(Long id);
}
