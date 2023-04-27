package uz.fido.pcmarket.payload;

import lombok.Data;

import java.util.List;

@Data
public class BrandDto {
    private String name;
    private List<Long> product_id;
}
