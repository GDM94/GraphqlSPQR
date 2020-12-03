package com.example.springPostgres.repositories;

import com.example.springPostgres.model.RecapitiTelefonici;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecapitiRepository extends JpaRepository<RecapitiTelefonici, Long> {

}
