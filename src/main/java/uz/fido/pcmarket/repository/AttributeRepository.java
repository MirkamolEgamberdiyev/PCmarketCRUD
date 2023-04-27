package uz.fido.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.fido.pcmarket.entity.Attribute;

@RepositoryRestResource(path = "attribute")
public interface AttributeRepository extends JpaRepository<Attribute, Long> {
}