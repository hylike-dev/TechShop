package com.app.e_commer.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private long id ;
    @Column(nullable = false , length = 100)
    private String name ;
    @Column(columnDefinition = "TEXT")
    private String description ;


}
