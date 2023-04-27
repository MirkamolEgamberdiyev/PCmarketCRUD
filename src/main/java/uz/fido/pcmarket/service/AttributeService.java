package uz.fido.pcmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.fido.pcmarket.entity.Attribute;
import uz.fido.pcmarket.entity.AttributeValue;
import uz.fido.pcmarket.entity.Category;
import uz.fido.pcmarket.payload.ApiResponce;
import uz.fido.pcmarket.payload.AttributeDto;
import uz.fido.pcmarket.repository.AttributeRepository;
import uz.fido.pcmarket.repository.AttributeValueRepository;
import uz.fido.pcmarket.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AttributeService {
    @Autowired
    private AttributeRepository attributeRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    AttributeValueRepository attributeValueRepository;


    public ApiResponce addAttribute(AttributeDto attributeDto) {
        Attribute attribute = new Attribute();
        attribute.setName(attributeDto.getName());

        Optional<Category> optionalCategory = categoryRepository.findById(attributeDto.getCategory_id());
        if (!optionalCategory.isPresent())
            return new ApiResponce("bunday category topilmadi", false);

        List<AttributeValue> attributeValueList = new ArrayList<>();
        for (Long id : attributeDto.getAttributeValues_id()) {
            Optional<AttributeValue> optionalAttributeValue = attributeValueRepository.findById(id);
            if (!optionalAttributeValue.isPresent())
                return new ApiResponce("Bunday attributevalue topilmadi", false);
            AttributeValue attributeValue = optionalAttributeValue.get();
            attributeValueList.add(attributeValue);
        }

        attribute.setCategory(optionalCategory.get());
        attribute.setAttributeValues(attributeValueList);
        Attribute save = attributeRepository.save(attribute);

        return new ApiResponce("attribute qo'shildi", true, save);
    }

    public ApiResponce getOneAttribute(Long id) {
        Optional<Attribute> optionalAttribute = attributeRepository.findById(id);
        if (!optionalAttribute.isPresent())
            return new ApiResponce("Bunday attributevalue topilmadi", false);
        Attribute attribute = optionalAttribute.get();
        return new ApiResponce("attribute topildi", true, attribute);
    }

    public ApiResponce getAllAttribute() {
        List<Attribute> attributes = attributeRepository.findAll();
        return new ApiResponce("attributes topildi", true, attributes);
    }

    public ApiResponce updateAttribute(Long id, AttributeDto attributeDto) {
        Optional<Attribute> optionalAttribute = attributeRepository.findById(id);
        if (!optionalAttribute.isPresent())
            return new ApiResponce("Bunday attributevalue topilmadi", false);
        Attribute attribute = optionalAttribute.get();
        attribute.setName(attributeDto.getName());

        Optional<Category> optionalCategory = categoryRepository.findById(attributeDto.getCategory_id());
        if (!optionalCategory.isPresent())
            return new ApiResponce("bunday category topilmadi", false);

        List<AttributeValue> attributeValueList = new ArrayList<>();
        for (Long attributeId : attributeDto.getAttributeValues_id()) {
            Optional<AttributeValue> optionalAttributeValue = attributeValueRepository.findById(attributeId);
            if (!optionalAttributeValue.isPresent())
                return new ApiResponce("Bunday attributevalue topilmadi", false);
            AttributeValue attributeValue = optionalAttributeValue.get();
            attributeValueList.add(attributeValue);
        }

        attribute.setCategory(optionalCategory.get());
        attribute.setAttributeValues(attributeValueList);
        Attribute save = attributeRepository.save(attribute);

        return new ApiResponce("attribute update qilindi", true, save);

    }

    public ApiResponce deleteAttribute(Long id) {
        attributeRepository.deleteById(id);
        return new ApiResponce("deleted attribute", true);
    }


}
