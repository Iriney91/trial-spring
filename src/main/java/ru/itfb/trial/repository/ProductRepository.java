package ru.itfb.trial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itfb.trial.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByName(String name);
    List<Product> findAll();



    @Query(value = "select p from Product p inner join client_product cp on p.id = cp.product_id where cp.clint_id = ?1 ", nativeQuery = true)
    List<Product>findAllByClientId(Long id);
    //List<Product> findAllByDescription(String description);
}
