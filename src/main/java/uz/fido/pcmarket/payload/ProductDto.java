package uz.fido.pcmarket.payload;

import lombok.Data;

import java.util.List;

@Data
public class ProductDto {
    private String name;
    private String description;
    private Double price;
    private Long category_id;
    private Long brand_id;
    private List<Long> productAttribute_id;
    private List<Long> productImage_id;
}
