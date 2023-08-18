package org.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @Builder(toBuilder = true)
@NoArgsConstructor @AllArgsConstructor
public class Product {
    private String name;
    private String searchKeyword;
    private Double price;
    private String brand;
    private String size;
    private String color;
    private String description;

    public Product init() {
        return this.toBuilder()
                .searchKeyword("Jeans")
                .name("Belted Jeans")
                .size("3")
                .color("Sand Stone")
                .brand("Abidas")
                .build();
    }
    public void assertThatNameSizeColorAreSame(Product that) {

    }
}