package com.chozoi.test.domain.entities;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    @Nationalized
    private String name;

    @Column(name = "pass", nullable = false)
    private String password;
    
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Cart> cart;

    @Column(name = "emp")
    private String emp;
}
