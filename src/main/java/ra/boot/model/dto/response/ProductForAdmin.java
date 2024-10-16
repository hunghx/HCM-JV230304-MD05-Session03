package ra.boot.model.dto.response;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ra.boot.model.entity.Catalog;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductForAdmin {
    private String id;
    private String name;
    private int stock;
    private BigDecimal price;
    private String url;
    private LocalDate createdAt;
    private boolean status;
    private String catalogName;
}
