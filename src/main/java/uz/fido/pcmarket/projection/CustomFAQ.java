package uz.fido.pcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.fido.pcmarket.entity.FAQ;

@Projection(types = FAQ.class)
public interface CustomFAQ {
    Long getId();

    String getQuestion();

    String getAnswer();
}
