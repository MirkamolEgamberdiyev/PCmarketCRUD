package uz.fido.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.fido.pcmarket.entity.Brand;

@RepositoryRestResource(path = "brand")
public interface BrandRepository extends JpaRepository<Brand, Long> {
}
