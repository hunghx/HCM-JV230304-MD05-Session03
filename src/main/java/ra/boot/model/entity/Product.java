package ra.boot.model.entity;
// bang thiet bi

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String description;
    private int stock;
    private BigDecimal price;
    private String url;
    private LocalDate createdAt;
    private boolean status;
    private boolean isDeleted;
    @ManyToOne
    @JoinColumn(name = "catalog_id")
    private Catalog catalog;
}
