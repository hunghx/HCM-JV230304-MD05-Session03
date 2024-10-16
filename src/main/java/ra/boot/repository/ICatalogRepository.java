package ra.boot.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ra.boot.model.entity.Catalog;
import ra.boot.model.entity.Product;

import java.util.List;

public interface ICatalogRepository extends JpaRepository<Catalog,Integer> {
    List<Catalog> findAllByIsDeletedIsFalse(); // cách 1

    @Query(value = "select C from Catalog  C where C.isDeleted= false")
    List<Catalog> getAllCatalogActive();
    @Transactional
    @Query(value = "update Catalog C set C.active =case C.active when true then false else true end where C.id = :id")
    @Modifying
    void changeActiveByCatalogId(@Param("id") int catalogId);

}
