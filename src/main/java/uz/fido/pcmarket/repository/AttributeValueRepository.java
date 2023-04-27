package uz.fido.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.fido.pcmarket.entity.AttributeValue;

@RepositoryRestResource(path = "attributeValue")
public interface AttributeValueRepository extends JpaRepository<AttributeValue, Long> {
}
