package uz.fido.pcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.fido.pcmarket.entity.User;

@Projection(types = User.class)
public interface CustomUser {
    Long getId();

    String getFirst_name();

    String getLast_name();

    String getUsername();

    String getPassword();

    String getEmail();
}
