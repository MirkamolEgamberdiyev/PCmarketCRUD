package uz.fido.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.fido.pcmarket.entity.Cart;

@RepositoryRestResource(path = "cart")
public interface CartRepository extends JpaRepository<Cart, Long> {
}
