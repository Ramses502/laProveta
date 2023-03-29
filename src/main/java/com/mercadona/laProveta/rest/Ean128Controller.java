package com.mercadona.laProveta.rest;

import com.mercadona.laProveta.dto.PaleDto;
import com.mercadona.laProveta.model.Product;
import com.mercadona.laProveta.repository.ProductRepository;
import com.mercadona.laProveta.services.EanServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Transactional
@RestController
@RequiredArgsConstructor
@RequestMapping("/ean128")
public class Ean128Controller {

    private final EanServices ean;

    @GetMapping("/get_palet")
    public PaleDto get(@RequestParam String ean128) throws ParseException {

        return ean.get(ean128);
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam String id){
        ean.delete(id);
        return "Deleted!!";
    }

    @PostMapping("/upload")
    public String post(@RequestParam String id, @RequestParam String name){

        ean.post(id, name);
        return "Uploaded!!";
    }

    @PutMapping("/update")
    public String put(@RequestParam String id, @RequestParam String name){

        ean.put(id, name);
        return "Updated!!";
    }

}
