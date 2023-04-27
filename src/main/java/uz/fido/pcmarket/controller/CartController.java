package uz.fido.pcmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.fido.pcmarket.payload.ApiResponce;
import uz.fido.pcmarket.payload.CartDto;
import uz.fido.pcmarket.service.CartService;

@RestController
@RequestMapping
public class CartController {
    @Autowired
    CartService cartService;

    @PostMapping("/addCart")
    public HttpEntity<ApiResponce> addCart(@RequestBody CartDto cartDto) {
        ApiResponce apiResponce = cartService.addCart(cartDto);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getOneCart/{id}")
    public HttpEntity<ApiResponce> getOneCart(@PathVariable Long id) {
        ApiResponce apiResponce = cartService.getOneCart(id);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getAllCart")
    public HttpEntity<ApiResponce> getAllCart() {
        ApiResponce apiResponce = cartService.getAllCart();
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @PutMapping("/updateCart/{id}")
    public HttpEntity<ApiResponce> updateCart(@PathVariable Long id, @RequestBody CartDto cartDto) {
        ApiResponce apiResponce = cartService.updateCart(id, cartDto);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @DeleteMapping("/deleteCart/{id}")
    public HttpEntity<ApiResponce> deleteCart(@PathVariable Long id) {
        ApiResponce apiResponce = cartService.deleteCart(id);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

}
