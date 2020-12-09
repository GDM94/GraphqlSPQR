package com.example.springPostgres.repositories;

import com.example.springPostgres.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long>{
}
