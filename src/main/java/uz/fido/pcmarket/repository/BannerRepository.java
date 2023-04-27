package uz.fido.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.fido.pcmarket.entity.Banner;
import uz.fido.pcmarket.projection.CustomBanner;

@RepositoryRestResource(path = "banner", collectionResourceRel = "list", excerptProjection = CustomBanner.class)
public interface BannerRepository extends JpaRepository<Banner, Long> {

}