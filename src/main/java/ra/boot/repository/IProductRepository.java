package ra.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ra.boot.model.entity.Product;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, String> {
//    List<Product> findAllByDeletedIsFalse(); // cách 1

    @Query(value = "select P from Product  P where P.isDeleted = false and P.catalog.isDeleted = false ")
    List<Product> getAllProductActive();
}
