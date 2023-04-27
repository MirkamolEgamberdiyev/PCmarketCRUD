package uz.fido.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.fido.pcmarket.entity.Contact;
import uz.fido.pcmarket.projection.CustomContact;

@RepositoryRestResource(path = "contact", collectionResourceRel = "list", excerptProjection = CustomContact.class)
public interface ContactRepository  extends JpaRepository<Contact, Long> {
}
