package model;

import lombok.*;

@Data
@With
@Builder
@AllArgsConstructor
public class Product {

    private final String id;
    private final String name;
    private final Double price;
}