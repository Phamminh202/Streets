package com.example.streets.repository;

import com.example.streets.entity.Street;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreetRepository extends JpaRepository<Street, String> {
}
