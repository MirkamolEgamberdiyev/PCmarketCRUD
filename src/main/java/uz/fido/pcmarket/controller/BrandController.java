package uz.fido.pcmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.fido.pcmarket.payload.ApiResponce;
import uz.fido.pcmarket.payload.BrandDto;
import uz.fido.pcmarket.service.BrandService;

@RestController
@RequestMapping
public class BrandController {
    @Autowired
    BrandService brandService;

    @PostMapping("/addBrand")
    public HttpEntity<ApiResponce> addBrand(@RequestBody BrandDto brandDto) {
        ApiResponce apiResponce = brandService.addBrand(brandDto);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }


    @GetMapping("/getOneBrand/{id}")
    public HttpEntity<ApiResponce> getOneBrand(@PathVariable Long id) {
        ApiResponce apiResponce = brandService.getOneBrand(id);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getAllBrand")
    public HttpEntity<ApiResponce> getAllBrand() {
        ApiResponce apiResponce = brandService.getAllBrand();
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @PutMapping("/updateBrand/{id}")
    public HttpEntity<ApiResponce> updateBrand(@PathVariable Long id, @RequestBody BrandDto brandDto) {
        ApiResponce apiResponce = brandService.updateBrand(id, brandDto);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @DeleteMapping("/deleteBrand/{id}")
    public HttpEntity<ApiResponce> deleteBrand(@PathVariable Long id) {
        ApiResponce apiResponce = brandService.deleteBrand(id);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }


}
