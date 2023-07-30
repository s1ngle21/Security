package security.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import security.entity.Product;
import security.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping("{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        return ResponseEntity
                .ok(productService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity
                .ok(productService.getAll());
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<Product> add(@RequestBody Product product) {
        return ResponseEntity
                .ok(productService.add(product));
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity
                .ok("Product has been deleted");
    }
}
