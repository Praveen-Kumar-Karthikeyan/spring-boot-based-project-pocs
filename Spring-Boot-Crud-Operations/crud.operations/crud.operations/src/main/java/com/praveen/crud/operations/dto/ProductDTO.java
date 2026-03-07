package com.praveen.crud.operations.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ProductDTO {

    private String productName;
    private long productId;
    private double price;
    private long quantity;
}
