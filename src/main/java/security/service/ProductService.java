package security.service;

import security.entity.Product;

import java.util.List;

public interface ProductService {

    Product getById(Long id);

    List<Product> getAll();

    void delete(Long id);

    Product add(Product product);
}
