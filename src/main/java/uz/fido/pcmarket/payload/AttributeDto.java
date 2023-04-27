package uz.fido.pcmarket.payload;

import lombok.Data;
import java.util.List;

@Data
public class AttributeDto {

    private String name;

    private Long category_id;

    private List<Long> attributeValues_id;

}
