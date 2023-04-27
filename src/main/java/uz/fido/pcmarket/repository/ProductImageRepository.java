package uz.fido.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.fido.pcmarket.entity.ProductImage;

@RepositoryRestResource(path = "ProductImage")
public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
}
