package uz.fido.pcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.fido.pcmarket.entity.Delivery;

@Projection(types = Delivery.class)
public interface CustomDelivery {
    Long getId();

    String getName();

    double getPrice();

}
