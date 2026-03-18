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

    @PostMapping("/save-products")
    public ResponseEntity<List<ProductDTO>> saveProducts(@RequestBody List<ProductDTO> productDTOS) {
        return ResponseEntity.ok(productService.saveProducts(productDTOS));
    }

    @PutMapping("/update-product-info")
    public ResponseEntity<ProductDTO> updateProductInfo(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(productService.updateProductInfo(productDTO));
    }

    @GetMapping("/list-products")
    public ResponseEntity<List<ProductDTO>> getProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping("/product-by-id/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable(name = "id") long productId) {
        return ResponseEntity.ok(productService.getProductById(productId));
    }

    @GetMapping("/product-by-name/{name}")
    public ResponseEntity<ProductDTO> getProductByName(@PathVariable(name = "name") String productName) {
        return ResponseEntity.ok(productService.getProductByName(productName));
    }

    @DeleteMapping("/remove-product/{id}")
    public ResponseEntity<String> removeProductById(@PathVariable(name = "id") long productId) {
        return ResponseEntity.ok(productService.removeProductById(productId));
    }

    @GetMapping("/sort-products/{fieldName}")
    public ResponseEntity<List<ProductDTO>> sortProducts(@PathVariable String fieldName) {
        return ResponseEntity.ok(productService.sortProducts(fieldName));
    }


}