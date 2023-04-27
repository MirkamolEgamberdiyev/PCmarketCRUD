package uz.fido.pcmarket.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Double price;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Brand brand;

    @OneToMany
    private List<ProductAttribute> productAttributes;

    @OneToMany
    private List<ProductImage> productImages;
}
