package uz.fido.pcmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.fido.pcmarket.payload.ApiResponce;
import uz.fido.pcmarket.payload.CategoryDto;
import uz.fido.pcmarket.service.CategoryService;

@RestController
@RequestMapping
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping("/addCategory")
    public HttpEntity<ApiResponce> addCategory(@RequestBody CategoryDto categoryDto) {
        ApiResponce apiResponce = categoryService.addCategory(categoryDto);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getOneCategory/{id}")
    public HttpEntity<ApiResponce> getOneCategory(@PathVariable Long id) {
        ApiResponce apiResponce = categoryService.getOneCategory(id);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getAllCategory")
    public HttpEntity<ApiResponce> getAllCategory() {
        ApiResponce apiResponce = categoryService.getAllCategory();
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @PutMapping("/updateCategory/{id}")
    public HttpEntity<ApiResponce> updateCategory(@PathVariable Long id, @RequestBody CategoryDto categoryDto) {
        ApiResponce apiResponce = categoryService.updateCategory(id, categoryDto);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @DeleteMapping("/deleteCategory/{id}")
    public HttpEntity<ApiResponce> deleteCategory(@PathVariable Long id) {
        ApiResponce apiResponce = categoryService.deleteCategory(id);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }


}
