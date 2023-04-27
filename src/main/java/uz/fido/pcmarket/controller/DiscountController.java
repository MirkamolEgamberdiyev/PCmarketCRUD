package uz.fido.pcmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.fido.pcmarket.payload.ApiResponce;
import uz.fido.pcmarket.payload.DiscountDto;
import uz.fido.pcmarket.service.DiscountService;

@RestController
@RequestMapping
public class DiscountController {
    @Autowired
    DiscountService discountService;

    @PostMapping("/addDiscount")
    public HttpEntity<ApiResponce> addDiscount(@RequestBody DiscountDto discountDto) {
        ApiResponce apiResponce = discountService.addDiscount(discountDto);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getOneDiscount/{id}")
    public HttpEntity<ApiResponce> getOneDiscount(@PathVariable Long id) {
        ApiResponce apiResponce = discountService.getOneDiscount(id);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getAllDiscount")
    public HttpEntity<ApiResponce> getAllDiscount() {
        ApiResponce apiResponce = discountService.getAllDiscount();
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @PutMapping("/updateDiscount/{id}")
    public HttpEntity<ApiResponce> updateDiscount(@PathVariable Long id, @RequestBody DiscountDto discountDto) {
        ApiResponce apiResponce = discountService.updateDiscount(id, discountDto);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @DeleteMapping("/deleteDiscount/{id}")
    public HttpEntity<ApiResponce> deleteDiscount(@PathVariable Long id) {
        ApiResponce apiResponce = discountService.deleteDiscount(id);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

}
