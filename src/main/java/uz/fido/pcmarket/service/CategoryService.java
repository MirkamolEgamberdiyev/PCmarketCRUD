package uz.fido.pcmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.fido.pcmarket.entity.Attribute;
import uz.fido.pcmarket.entity.Category;
import uz.fido.pcmarket.payload.ApiResponce;
import uz.fido.pcmarket.payload.CategoryDto;
import uz.fido.pcmarket.repository.AttributeRepository;
import uz.fido.pcmarket.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    AttributeRepository attributeRepository;

    public ApiResponce addCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());

        Optional<Category> optionalCategory = categoryRepository.findById(categoryDto.getParentCategory_id());
        if (!optionalCategory.isPresent())
            return new ApiResponce("bunday category topilmadi", false);

        Category category1 = optionalCategory.get();
        category.setParentCategory(category1);

        List<Attribute> attributes = new ArrayList<>();
        for (Long attributeId : categoryDto.getAttributes_d()) {
            Optional<Attribute> optionalAttribute = attributeRepository.findById(attributeId);
            if (!optionalAttribute.isPresent())
                return new ApiResponce("Bunday attribute topilmadi", false);
            attributes.add(optionalAttribute.get());
        }
        category.setAttributes(attributes);
        Category save = categoryRepository.save(category);
        return new ApiResponce("Added category", true, save);
    }

    public ApiResponce getOneCategory(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (!optionalCategory.isPresent())
            return new ApiResponce("Bunday category topilmadi", false);
        Category category = optionalCategory.get();
        return new ApiResponce("Category topildi", true, category);
    }

    public ApiResponce getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        return new ApiResponce("Categorylar listi topildi", true, categories);
    }

    public ApiResponce updateCategory(Long id, CategoryDto categoryDto) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (!optionalCategory.isPresent())
            return new ApiResponce("Bunday category topilmadi", false);
        Category category = optionalCategory.get();
        category.setName(categoryDto.getName());

        Optional<Category> categoryOptional = categoryRepository.findById(categoryDto.getParentCategory_id());
        if (!categoryOptional.isPresent())
            return new ApiResponce("bunday category topilmadi", false);

        Category category1 = categoryOptional.get();
        category.setParentCategory(category1);

        List<Attribute> attributes = new ArrayList<>();
        for (Long attributeId : categoryDto.getAttributes_d()) {
            Optional<Attribute> optionalAttribute = attributeRepository.findById(attributeId);
            if (!optionalAttribute.isPresent())
                return new ApiResponce("Bunday attribute topilmadi", false);
            attributes.add(optionalAttribute.get());
        }
        category.setAttributes(attributes);
        Category save = categoryRepository.save(category);
        return new ApiResponce("Added category", true, save);
    }

    public ApiResponce deleteCategory(Long id) {
        categoryRepository.deleteById(id);
        return new ApiResponce("deleted category", true);
    }

}
