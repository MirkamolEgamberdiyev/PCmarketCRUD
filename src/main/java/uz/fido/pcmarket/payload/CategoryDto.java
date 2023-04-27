package uz.fido.pcmarket.payload;

import lombok.Data;

import java.util.List;

@Data
public class CategoryDto {

    private String name;

    private Long parentCategory_id;

    private List<Long> attributes_d;
}
