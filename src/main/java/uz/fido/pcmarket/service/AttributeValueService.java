package uz.fido.pcmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.fido.pcmarket.entity.Attribute;
import uz.fido.pcmarket.entity.AttributeValue;
import uz.fido.pcmarket.payload.ApiResponce;
import uz.fido.pcmarket.payload.AttributeValueDto;
import uz.fido.pcmarket.repository.AttributeRepository;
import uz.fido.pcmarket.repository.AttributeValueRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AttributeValueService {
    @Autowired
    AttributeValueRepository attributeValueRepository;
    @Autowired
    AttributeRepository attributeRepository;

    public ApiResponce addAttributeValue(AttributeValueDto attributeValueDto) {
        AttributeValue attributeValue = new AttributeValue();
        attributeValue.setValue(attributeValueDto.getValue());

        Optional<Attribute> optionalAttribute = attributeRepository.findById(attributeValueDto.getAttribute_id());
        if (!optionalAttribute.isPresent())
            return new ApiResponce("bunday attribute topilmadi", false);

        Attribute attribute = optionalAttribute.get();
        attributeValue.setAttribute(attribute);
        AttributeValue save = attributeValueRepository.save(attributeValue);
        return new ApiResponce("attributeValue qo'shildi", true, save);
    }


    public ApiResponce getOneAttributeValue(Long id) {
        Optional<AttributeValue> optionalAttributeValue = attributeValueRepository.findById(id);
        if (!optionalAttributeValue.isPresent())
            return new ApiResponce("Bunday attribute topilmadi", false);

        AttributeValue attributeValue = optionalAttributeValue.get();
        return new ApiResponce("AttributeValue topildi", true, attributeValue);
    }

    public ApiResponce getAllAttributeValue() {
        List<AttributeValue> attributeValueList = attributeValueRepository.findAll();
        return new ApiResponce("AttributeList topildi", true, attributeValueList);
    }

    public ApiResponce updateAttributeValue(Long id, AttributeValueDto attributeValueDto) {
        Optional<AttributeValue> optionalAttributeValue = attributeValueRepository.findById(id);
        if (!optionalAttributeValue.isPresent())
            return new ApiResponce("Bunday attribute topilmadi", false);

        AttributeValue attributeValue = optionalAttributeValue.get();
        attributeValue.setValue(attributeValueDto.getValue());

        Optional<Attribute> optionalAttribute = attributeRepository.findById(attributeValueDto.getAttribute_id());
        if (!optionalAttribute.isPresent())
            return new ApiResponce("bunday attribute topilmadi", false);

        Attribute attribute = optionalAttribute.get();
        attributeValue.setAttribute(attribute);
        AttributeValue save = attributeValueRepository.save(attributeValue);
        return new ApiResponce("attributeValue update qilindi", true, save);
    }

    public ApiResponce deleteAttributeValue(Long id) {
        attributeValueRepository.deleteById(id);
        return new ApiResponce("deleted attributeValue", true);
    }
}
