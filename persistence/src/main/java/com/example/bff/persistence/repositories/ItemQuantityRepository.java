package com.example.bff.persistence.repositories;

import com.example.bff.persistence.entities.ItemQuantity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ItemQuantityRepository extends JpaRepository<ItemQuantity, UUID> {
}
