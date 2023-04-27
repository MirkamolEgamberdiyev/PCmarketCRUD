package uz.fido.pcmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.fido.pcmarket.payload.ApiResponce;
import uz.fido.pcmarket.payload.CartItemDto;
import uz.fido.pcmarket.service.CartItemService;

@RestController
@RequestMapping
public class CartItemController {
    @Autowired
    CartItemService cartItemService;


    @PostMapping("/addCartItem")
    public HttpEntity<ApiResponce> addCartItem(@RequestBody CartItemDto cartItemDto) {
        ApiResponce apiResponce = cartItemService.addCartItem(cartItemDto);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getOneCartItem/{id}")
    public HttpEntity<ApiResponce> getOneCartItem(@PathVariable Long id) {
        ApiResponce apiResponce = cartItemService.getOneCartItem(id);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getAllCartItem")
    public HttpEntity<ApiResponce> getAllCartItem() {
        ApiResponce apiResponce = cartItemService.getAllCartItem();
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @PutMapping("/updateCartItem/{id}")
    public HttpEntity<ApiResponce> updateCartItem(@PathVariable Long id, @RequestBody CartItemDto cartItemDto) {
        ApiResponce apiResponce = cartItemService.updateCartItem(id, cartItemDto);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @DeleteMapping("/deleteCartItem/{id}")
    public HttpEntity<ApiResponce> deleteCartItem(@PathVariable Long id) {
        ApiResponce apiResponce = cartItemService.deleteCartItem(id);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

}
