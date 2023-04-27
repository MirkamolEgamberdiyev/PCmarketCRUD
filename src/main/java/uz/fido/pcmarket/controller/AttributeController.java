package uz.fido.pcmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.fido.pcmarket.payload.ApiResponce;
import uz.fido.pcmarket.payload.AttributeDto;
import uz.fido.pcmarket.service.AttributeService;

@RestController
@RequestMapping
public class AttributeController {
    @Autowired
    AttributeService attributeService;

    @PostMapping("/addAttribute")
    public HttpEntity<ApiResponce> addAttribute(@RequestBody AttributeDto attributeDto) {
        ApiResponce apiResponce = attributeService.addAttribute(attributeDto);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getOneAttribute/{id}")
    public HttpEntity<ApiResponce> getOneAttribute(@PathVariable Long id) {
        ApiResponce apiResponce = attributeService.getOneAttribute(id);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getAllAttribute")
    public HttpEntity<ApiResponce> getAllAttribute() {
        ApiResponce apiResponce = attributeService.getAllAttribute();
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @PutMapping("/updateAttribute/{id}")
    public HttpEntity<ApiResponce> updateAttribute(@PathVariable Long id, @RequestBody AttributeDto attributeDto) {
        ApiResponce apiResponce = attributeService.updateAttribute(id, attributeDto);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @DeleteMapping("/deleteAttribute/{id}")
    public HttpEntity<ApiResponce> deleteAttribute(@PathVariable Long id) {
        ApiResponce apiResponce = attributeService.deleteAttribute(id);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

}
