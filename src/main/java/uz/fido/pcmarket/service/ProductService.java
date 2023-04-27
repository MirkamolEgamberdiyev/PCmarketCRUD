package uz.fido.pcmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.fido.pcmarket.entity.*;
import uz.fido.pcmarket.payload.ApiResponce;
import uz.fido.pcmarket.payload.ProductDto;
import uz.fido.pcmarket.repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    BrandRepository brandRepository;
    @Autowired
    ProductAttributeRepository productAttributeRepository;
    @Autowired
    ProductImageRepository productImageRepository;

    public ApiResponce addProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());

        List<ProductAttribute> productAttributes = new ArrayList<>();
        for (Long productAttributeId : productDto.getProductAttribute_id()) {
            Optional<ProductAttribute> optionalProductAttribute = productAttributeRepository.findById(productAttributeId);
            if (!optionalProductAttribute.isPresent())
                return new ApiResponce("productAttribute topilmadi", false);

            ProductAttribute productAttribute = optionalProductAttribute.get();
            productAttributes.add(productAttribute);
        }
        product.setProductAttributes(productAttributes);

        List<ProductImage> productImages = new ArrayList<>();
        for (Long productImageId : productDto.getProductImage_id()) {
            Optional<ProductImage> optionalProductImage = productImageRepository.findById(productImageId);
            if (!optionalProductImage.isPresent())
                return new ApiResponce("Bunday productImage topilmadi", false);
            ProductImage productImage = optionalProductImage.get();
            productImages.add(productImage);
        }

        product.setProductImages(productImages);

        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategory_id());
        if (!optionalCategory.isPresent())
            return new ApiResponce("Bunday category topilmadi", false);
        Category category = optionalCategory.get();
        product.setCategory(category);

        Optional<Brand> optionalBrand = brandRepository.findById(productDto.getBrand_id());
        if (!optionalBrand.isPresent())
            return new ApiResponce("Bunday brand topilmadi", false);

        Brand brand = optionalBrand.get();
        product.setBrand(brand);
        Product save = productRepository.save(product);
        return new ApiResponce("added product", true, save);
    }

    public ApiResponce getOneProduct(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (!optionalProduct.isPresent())
            return new ApiResponce("Bunday product topilmadi", false);

        Product product = optionalProduct.get();
        return new ApiResponce("Product topildi", true, product);
    }

    public ApiResponce getAllProduct() {
        List<Product> products = productRepository.findAll();
        return new ApiResponce("Productlar listi topildi", true, products);
    }

    public ApiResponce updateProduct(Long id, ProductDto productDto) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (!optionalProduct.isPresent())
            return new ApiResponce("Bunday product topilmadi", false);

        Product product = optionalProduct.get();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());

        List<ProductAttribute> productAttributes = new ArrayList<>();
        for (Long productAttributeId : productDto.getProductAttribute_id()) {
            Optional<ProductAttribute> optionalProductAttribute = productAttributeRepository.findById(productAttributeId);
            if (!optionalProductAttribute.isPresent())
                return new ApiResponce("productAttribute topilmadi", false);

            ProductAttribute productAttribute = optionalProductAttribute.get();
            productAttributes.add(productAttribute);
        }
        product.setProductAttributes(productAttributes);

        List<ProductImage> productImages = new ArrayList<>();
        for (Long productImageId : productDto.getProductImage_id()) {
            Optional<ProductImage> optionalProductImage = productImageRepository.findById(productImageId);
            if (!optionalProductImage.isPresent())
                return new ApiResponce("Bunday productImage topilmadi", false);
            ProductImage productImage = optionalProductImage.get();
            productImages.add(productImage);
        }

        product.setProductImages(productImages);

        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategory_id());
        if (!optionalCategory.isPresent())
            return new ApiResponce("Bunday category topilmadi", false);
        Category category = optionalCategory.get();
        product.setCategory(category);

        Optional<Brand> optionalBrand = brandRepository.findById(productDto.getBrand_id());
        if (!optionalBrand.isPresent())
            return new ApiResponce("Bunday brand topilmadi", false);

        Brand brand = optionalBrand.get();
        product.setBrand(brand);
        Product save = productRepository.save(product);
        return new ApiResponce("added product", true, save);
    }

    public ApiResponce deleteProduct(Long id) {
        productRepository.deleteById(id);
        return new ApiResponce("Deleted product", true);
    }
}
