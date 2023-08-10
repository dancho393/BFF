package com.example.bff.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    @OneToOne(mappedBy = "cart")
    private User user;

    @ElementCollection
    private Map<UUID,Integer> items;

    private Float totalPrice=0.0f;

}
