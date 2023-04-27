package uz.fido.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.fido.pcmarket.entity.FAQ;
import uz.fido.pcmarket.projection.CustomFAQ;

@RepositoryRestResource(path = "faq", collectionResourceRel = "list", excerptProjection = CustomFAQ.class)
public interface FAQRepository extends JpaRepository<FAQ, Long> {
}
