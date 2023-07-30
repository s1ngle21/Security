package security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import security.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
