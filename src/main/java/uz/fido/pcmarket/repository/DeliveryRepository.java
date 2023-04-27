package uz.fido.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.fido.pcmarket.entity.Delivery;
import uz.fido.pcmarket.projection.CustomDelivery;

@RepositoryRestResource(path = "delivery", collectionResourceRel = "list", excerptProjection = CustomDelivery.class)
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
