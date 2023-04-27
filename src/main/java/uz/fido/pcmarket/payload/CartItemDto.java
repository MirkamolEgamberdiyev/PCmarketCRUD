package uz.fido.pcmarket.payload;

import lombok.Data;

@Data
public class CartItemDto {
    private Long cart_id;
    private Long product_id;
    private String quantity;
}
