package uz.fido.pcmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.fido.pcmarket.payload.ApiResponce;
import uz.fido.pcmarket.payload.AttributeValueDto;
import uz.fido.pcmarket.service.AttributeValueService;

@RestController
@RequestMapping
public class AttributeValueController {
    @Autowired
    AttributeValueService attributeValueService;

    @PostMapping("/addAttributeValue")
    public HttpEntity<ApiResponce> addAttributeValue(@RequestBody AttributeValueDto attributeValueDto) {
        ApiResponce apiResponce = attributeValueService.addAttributeValue(attributeValueDto);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getOneAttributeValue/{id}")
    public HttpEntity<ApiResponce> getOneAttributeValue(@PathVariable Long id) {
        ApiResponce apiResponce = attributeValueService.getOneAttributeValue(id);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getAllAttributeValue")
    public HttpEntity<ApiResponce> getAllAttributeValue() {
        ApiResponce apiResponce = attributeValueService.getAllAttributeValue();
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @PutMapping("/updateAttributeValue/{id}")
    public HttpEntity<ApiResponce> updateAttributeValue(@PathVariable Long id, @RequestBody AttributeValueDto attributeValueDto) {
        ApiResponce apiResponce = attributeValueService.updateAttributeValue(id, attributeValueDto);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @DeleteMapping("/deleteAttributeValue/{id}")
    public HttpEntity<ApiResponce> deleteAttributeValue(@PathVariable Long id) {
        ApiResponce apiResponce = attributeValueService.deleteAttributeValue(id);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

}
