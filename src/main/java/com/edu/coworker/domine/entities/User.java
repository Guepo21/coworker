package com.edu.coworker.domine.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @OneToMany(mappedBy = "user")
    private Set<Reservation> reservations;

    @OneToOne(optional = false)
    @JoinColumn(name = "driver_license_id", referencedColumnName = "id")
    private DriverLicense license;
}
