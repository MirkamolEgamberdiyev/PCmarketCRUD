package uz.fido.pcmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.fido.pcmarket.payload.ApiResponce;
import uz.fido.pcmarket.payload.ProductDto;
import uz.fido.pcmarket.service.ProductService;

@RestController
@RequestMapping
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/addProduct")
    public HttpEntity<ApiResponce> addProduct(@RequestBody ProductDto productDto) {
        ApiResponce apiResponce = productService.addProduct(productDto);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getOneProduct/{id}")
    public HttpEntity<ApiResponce> getOneProduct(@PathVariable Long id) {
        ApiResponce apiResponce = productService.getOneProduct(id);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getAllProduct")
    public HttpEntity<ApiResponce> getAllProduct() {
        ApiResponce apiResponce = productService.getAllProduct();
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @PutMapping("/updateProduct/{id}")
    public HttpEntity<ApiResponce> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        ApiResponce apiResponce = productService.updateProduct(id, productDto);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public HttpEntity<ApiResponce> deleteProduct(@PathVariable Long id) {
        ApiResponce apiResponce = productService.deleteProduct(id);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }
}
