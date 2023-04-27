package uz.fido.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.fido.pcmarket.entity.ProductAttribute;

@RepositoryRestResource(path = "productAttribute")
public interface ProductAttributeRepository extends JpaRepository<ProductAttribute, Long> {
}
