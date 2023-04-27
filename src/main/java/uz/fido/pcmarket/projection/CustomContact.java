package uz.fido.pcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.fido.pcmarket.entity.Contact;

@Projection(types = Contact.class)
public interface CustomContact {
    Long getId();

    String getName();

    String getEmail();

    String getSubject();

    String getMessage();

}
