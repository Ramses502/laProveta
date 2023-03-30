package com.mercadona.laProveta.rest;

import com.mercadona.laProveta.dto.PaletDto;
import com.mercadona.laProveta.exceptions.IdArticuloException;
import com.mercadona.laProveta.exceptions.IdPaletException;
import com.mercadona.laProveta.services.EanServices;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@Transactional
@RestController
@RequiredArgsConstructor
@RequestMapping("/ean128")
public class Ean128Controller {

    private final EanServices ean;

    @GetMapping("/get_palet")
    public PaletDto get(@RequestParam String ean128) throws ParseException, IdArticuloException, IdPaletException {

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
