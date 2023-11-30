package com.guilherme.vitrine.repository;

import java.util.Optional;

import com.guilherme.vitrine.models.Newsletter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsletterRepository extends JpaRepository<Newsletter, Integer> {
  Optional<Newsletter> findByEmail(String email);

  boolean existsByEmail(String email);
}
