package uz.fido.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.fido.pcmarket.entity.Category;
@RepositoryRestResource(path = "category")
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
