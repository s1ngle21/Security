package security.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import security.entity.Product;
import security.repository.ProductRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class SimpleProductService implements ProductService {

    private ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public Product getById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product add(Product product) {
        return productRepository.save(product);
    }
}
