package uz.fido.pcmarket.payload;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DiscountDto {

    private double amount;

    private LocalDate startDate;

    private LocalDate endDate;

    private Long promotion_id;
}
