package uz.fido.pcmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.fido.pcmarket.entity.Brand;
import uz.fido.pcmarket.entity.Product;
import uz.fido.pcmarket.payload.ApiResponce;
import uz.fido.pcmarket.payload.BrandDto;
import uz.fido.pcmarket.repository.BrandRepository;
import uz.fido.pcmarket.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BrandService {
    @Autowired
    BrandRepository brandRepository;
    @Autowired
    ProductRepository productRepository;

    public ApiResponce addBrand(BrandDto brandDto) {
        Brand brand = new Brand();
        brand.setName(brandDto.getName());

        List<Product> products = new ArrayList<>();
        for (Long productId : brandDto.getProduct_id()) {
            Optional<Product> optionalProduct = productRepository.findById(productId);
            if (!optionalProduct.isPresent())
                return new ApiResponce("Bunday product topilmadi", false);

            products.add(optionalProduct.get());
        }
        brand.setProducts(products);
        Brand save = brandRepository.save(brand);
        return new ApiResponce("brand qo'shildi", true, save);
    }

    public ApiResponce getOneBrand(Long id) {
        Optional<Brand> optionalBrand = brandRepository.findById(id);
        if (!optionalBrand.isPresent())
            return new ApiResponce("bunday brand topilmadi", false);

        Brand brand = optionalBrand.get();
        return new ApiResponce("brand topildi", true, brand);
    }

    public ApiResponce getAllBrand() {
        List<Brand> brands = brandRepository.findAll();
        return new ApiResponce("brands topildi", true, brands);
    }

    public ApiResponce updateBrand(Long id, BrandDto brandDto) {
        Optional<Brand> optionalBrand = brandRepository.findById(id);
        if (!optionalBrand.isPresent())
            return new ApiResponce("bunday brand topilmadi", false);

        Brand brand = optionalBrand.get();
        brand.setName(brandDto.getName());

        List<Product> products = new ArrayList<>();
        for (Long productId : brandDto.getProduct_id()) {
            Optional<Product> optionalProduct = productRepository.findById(productId);
            if (!optionalProduct.isPresent())
                return new ApiResponce("Bunday product topilmadi", false);

            products.add(optionalProduct.get());
        }
        brand.setProducts(products);
        Brand save = brandRepository.save(brand);
        return new ApiResponce("brand qo'shildi", true, save);
    }

    public ApiResponce deleteBrand(Long id) {
        brandRepository.deleteById(id);
        return new ApiResponce("deleted brand", true);
    }
}
