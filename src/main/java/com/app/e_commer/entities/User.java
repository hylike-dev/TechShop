package com.app.e_commer.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false , length = 50 , unique = true)
    private String username;
    @Column(nullable = false , length = 255)
    private String password;
    @Column( length = 50 , unique = true)
    private String email;
    @Column( length = 50 , unique = true)
    private String phone;
    @Column(nullable = false , length = 200)
    private String address;
    @Column(name="full_name",nullable = false , length = 100)
    private String fullName;
    @Column(name = "created_at", nullable = false, updatable = false)

    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="role_id" , nullable = false)
    private Role role ;

    @PrePersist
    protected void onCreate() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }
}
