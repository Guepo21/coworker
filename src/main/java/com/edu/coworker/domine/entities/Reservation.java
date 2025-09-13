package com.edu.coworker.domine.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "reservations")
@Getter  @Setter  @NoArgsConstructor
@AllArgsConstructor
@Builder

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private java.time.OffsetDateTime pickupAt;

    @Column (nullable = false)
    private OffsetDateTime returnAt;

    @Column(nullable = false)
    private BigDecimal totalPrice;

    @Column(nullable = false)
    private String status;

    // relacion con user
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    //relacion con vehicle
    @ManyToMany
    @JoinTable(
            name = "reservation_vehicle",
            joinColumns = @JoinColumn(name = "reservation_id"), //columna tabla A
            inverseJoinColumns = @JoinColumn(name = "vehicle_id") // columna tabla B
    )
    @Builder.Default
    private Set<Vehicle> vehicles = new HashSet<>();
}
