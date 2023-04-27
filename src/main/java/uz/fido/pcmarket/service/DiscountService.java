package uz.fido.pcmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.fido.pcmarket.entity.Discount;
import uz.fido.pcmarket.entity.Promotion;
import uz.fido.pcmarket.payload.ApiResponce;
import uz.fido.pcmarket.payload.DiscountDto;
import uz.fido.pcmarket.repository.DiscountRepository;
import uz.fido.pcmarket.repository.PromotionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DiscountService {
    @Autowired
    DiscountRepository discountRepository;
    @Autowired
    PromotionRepository promotionRepository;

    public ApiResponce addDiscount(DiscountDto discountDto) {
        Discount discount = new Discount();
        discount.setAmount(discountDto.getAmount());
        discount.setEndDate(discountDto.getEndDate());
        discount.setStartDate(discountDto.getStartDate());

        Optional<Promotion> optionalPromotion = promotionRepository.findById(discountDto.getPromotion_id());
        if (!optionalPromotion.isPresent())
            return new ApiResponce("Bunday promotion topilmadi", false);
        Promotion promotion = optionalPromotion.get();
        discount.setPromotion(promotion);
        Discount save = discountRepository.save(discount);
        return new ApiResponce("Discount topildi", true, save);
    }

    public ApiResponce getOneDiscount(Long id) {
        Optional<Discount> optionalDiscount = discountRepository.findById(id);
        if (!optionalDiscount.isPresent())
            return new ApiResponce("Bunday discount topilmadi", false);

        Discount discount = optionalDiscount.get();
        return new ApiResponce("Discount topildi", true, discount);
    }

    public ApiResponce getAllDiscount() {
        List<Discount> discounts = discountRepository.findAll();
        return new ApiResponce("Discounts topildi", true, discounts);
    }

    public ApiResponce updateDiscount(Long id, DiscountDto discountDto) {
        Optional<Discount> optionalDiscount = discountRepository.findById(id);
        if (!optionalDiscount.isPresent())
            return new ApiResponce("Bunday discount topilmadi", false);

        Discount discount = optionalDiscount.get();
        discount.setAmount(discountDto.getAmount());
        discount.setEndDate(discountDto.getEndDate());
        discount.setStartDate(discountDto.getStartDate());

        Optional<Promotion> optionalPromotion = promotionRepository.findById(discountDto.getPromotion_id());
        if (!optionalPromotion.isPresent())
            return new ApiResponce("Bunday promotion topilmadi", false);
        Promotion promotion = optionalPromotion.get();
        discount.setPromotion(promotion);
        Discount save = discountRepository.save(discount);
        return new ApiResponce("Discount update qilindi", true, save);
    }

    public ApiResponce deleteDiscount(Long id) {
        discountRepository.deleteById(id);
        return new ApiResponce("deleted discount", true);
    }
}
