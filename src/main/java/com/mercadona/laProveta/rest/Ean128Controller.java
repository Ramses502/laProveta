package com.mercadona.laProveta.rest;

import com.mercadona.laProveta.dto.PaletDto;
import com.mercadona.laProveta.exceptions.*;
import com.mercadona.laProveta.services.EanServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.PrinterLocation;
import java.text.ParseException;

@Transactional
@RestController
@RequiredArgsConstructor
@RequestMapping("/ean128")
public class Ean128Controller {

    private final EanServices ean;

    @GetMapping("/get_palet")
    public ResponseEntity<PaletDto> get(@RequestParam String ean128) throws ParseException {
        PaletDto palet = ean.get(ean128).getBody();
        if(palet.getId() == null){
            throw new IdPaletException();
        }
        else if(palet.getIdArticulo() == null){
            throw new IdArticuloException();
        }
        else if(palet.getLote() == null){
            throw new NumLoteException();
        }
        else if(palet.getFechaFabricacion() == null){
            throw new FechaFabricacionException();
        }
        else if(palet.getPesoEnGramos() == null){
            throw new PesoException();
        }
        return ResponseEntity.accepted().body(palet);
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
