package com.example.springPostgres.repositories;

import com.example.springPostgres.model.Authority;
import com.example.springPostgres.model.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findByName(AuthorityName name);

}
