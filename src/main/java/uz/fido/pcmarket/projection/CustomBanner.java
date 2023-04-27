package uz.fido.pcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.fido.pcmarket.entity.Banner;

@Projection(types = Banner.class)
public interface CustomBanner {
    Long getId();

    String getTitle();

    String getImage();

    String getLink();
}
