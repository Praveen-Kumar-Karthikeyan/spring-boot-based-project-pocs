package com.praveen.crud.operations.service;

import com.praveen.crud.operations.dto.ProductDTO;
import com.praveen.crud.operations.entity.Product;
import com.praveen.crud.operations.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepo productRepo;

    public ProductService(final ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public ProductDTO saveProduct(ProductDTO productDTO) {
        return getProductDTO(productRepo.save(getProduct(productDTO)));
    }

    public List<ProductDTO> getProducts() {
        return productRepo.findAll()
                .stream()
                .map(this::getProductDTO).toList();
    }

    public ProductDTO getProductByName(String productName) {
        Optional<Product> retrievedProduct = productRepo.findByProductName(productName);
        return retrievedProduct.isPresent() ?
                getProductDTO(retrievedProduct.get()) : new ProductDTO();
    }


    public Product getProduct(ProductDTO productDTO) {
        return Product.builder()
                .productName(productDTO.getProductName())
                .productId(productDTO.getProductId())
                .price(productDTO.getPrice())
                .quantity(productDTO.getQuantity())
                .build();
    }

    public ProductDTO getProductDTO(Product product) {
        return ProductDTO.builder()
                .productName(product.getProductName())
                .quantity(product.getQuantity())
                .productId(product.getProductId())
                .price(product.getPrice())
                .build();
    }

    public ProductDTO updateProductInfo(ProductDTO productDTO) {
        return getProductDTO(productRepo.save(getProduct(productDTO)));
    }

    public ProductDTO getProductById(long productId) {
        Optional<Product> product = productRepo.findById(productId);
        return product.isPresent() ? getProductDTO(product.get()) : new ProductDTO();
    }

    public String removeProductById(long productId) {
        productRepo.deleteById(productId);
        return productRepo.existsById(productId) ?
                "Product with an Id as " + productId + "not removed successfully Please try again"
                : "Product with an Id as " + productId + "removed successfully";
    }
}
