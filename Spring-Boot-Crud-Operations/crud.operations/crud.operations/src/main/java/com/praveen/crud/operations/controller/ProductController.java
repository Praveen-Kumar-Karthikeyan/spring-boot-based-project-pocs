package com.praveen.crud.operations.controller;

import com.praveen.crud.operations.dto.ProductDTO;
import com.praveen.crud.operations.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apis/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(final ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/save-product")
    public ResponseEntity<ProductDTO> saveProduct(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(productService.saveProduct(productDTO));
    }

    @GetMapping("/list-products")
    public ResponseEntity<List<ProductDTO>> getProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping("/product-by-name/{name}")
    public ResponseEntity<ProductDTO> getProductByName(@PathVariable(name = "name") String productName) {
        return ResponseEntity.ok(productService.getProductByName(productName));
    }

    @PutMapping("/update-product-info")
    public ResponseEntity<ProductDTO> updateProductInfo(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(productService.updateProductInfo(productDTO));
    }

    @GetMapping("/product-by-id/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable(name = "id") long productId) {
        return ResponseEntity.ok(productService.getProductById(productId));
    }

    @DeleteMapping("/remove-product/{id}")
    public ResponseEntity<String> removeProductById(@PathVariable(name = "id") long productId) {
        return ResponseEntity.ok(productService.removeProductById(productId));
    }


}
