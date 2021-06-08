package com.chozoi.test.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tasty")
public class Tasty implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    @Nationalized
    private String name;

    @Column(name = "price", nullable = false)
    private float price;

    @Column(name = "des", nullable = false)
    @Nationalized
    private String des;

    @Column(name = "quantities", nullable = false)
    private int quantities;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "tasty", fetch = FetchType.LAZY)
    private List<CartItem> cartItems;

}
