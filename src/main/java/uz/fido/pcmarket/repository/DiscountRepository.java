package uz.fido.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.fido.pcmarket.entity.Discount;
@RepositoryRestResource(path = "discount")
public interface DiscountRepository extends JpaRepository<Discount, Long> {
}
