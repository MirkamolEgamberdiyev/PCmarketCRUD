package uz.fido.pcmarket.payload;

import lombok.Data;

@Data
public class AttributeValueDto {
    private String value;
    private Long attribute_id;
}
