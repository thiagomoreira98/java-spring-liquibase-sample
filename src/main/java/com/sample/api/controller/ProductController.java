package com.sample.api.controller;

import com.sample.api.openapi.ProductControllerOpenApi;
import com.sample.model.Product;
import com.sample.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController implements ProductControllerOpenApi {

    @Autowired
    private ProductRepository repository;

    @GetMapping
    public List<Product> list() {
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@RequestParam Long id) {
        var product = this.repository.findById(id);

        if(product.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(product.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> insertOrUpdate(@RequestBody @Valid Product product) {
        this.repository.save(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        this.repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
