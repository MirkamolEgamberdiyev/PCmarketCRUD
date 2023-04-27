package uz.fido.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.fido.pcmarket.entity.Promotion;

@RepositoryRestResource(path = "promotion")
public interface PromotionRepository extends JpaRepository<Promotion, Long> {
}
