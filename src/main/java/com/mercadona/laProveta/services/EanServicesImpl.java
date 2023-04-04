package com.mercadona.laProveta.services;

import com.mercadona.laProveta.dto.PaletDto;
import com.mercadona.laProveta.model.Product;
import com.mercadona.laProveta.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class EanServicesImpl implements EanServices{

    private final ProductRepository repository;

    @Autowired
    public EanServicesImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public String getIdPalet(String ean128) {
            int indexL = 2;
            int indexR = indexL + 18;
            return ean128.substring(indexL, indexR);
    }

    @Override
    public String getNumArticulo(String ean128) {
        int indexL = 2;
        int indexR = indexL + 14;
        return ean128.substring(indexL, indexR);
    }

    @Override
    public String getNumLote(String ean128) {
        int indexL = 2;
        int indexR = ean128.indexOf("*");
        return ean128.substring(indexL, indexR);
    }

    @Override
    public String getDate(String ean128) {
        int indexL = 2;
        int indexR = indexL + 6;
        return ean128.substring(indexL, indexR);
    }

    @Override
    public String getWeight(String ean128) {
        int indexL = 3;
        int indexR = indexL + 7;
        return ean128.substring(indexL,indexR);
    }

    @Override
    public String getNombre(String ean128) {
        String idArticulo = getNumArticulo(ean128);
        return repository.getReferenceById(idArticulo).getName();
    }

    @Override
    public Page<Product> getAllProducts(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public LocalDateTime formatDate(String ean128) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        Date d1 = sdf.parse(getDate(ean128));
        sdf.applyPattern("dd-MM-yyyy");
        String date = sdf.format(d1) + " 00:00:00";
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    }

    @Override
    public ResponseEntity<PaletDto> get(String ean128) throws ParseException {

        LocalDateTime dateTime = null;
        Long idPalet = null;
        String idArticulo = null;
        String lote = null;
        Long weight = null;
        String nombreArticulo = null;
        String iA;

        String ean = ean128;

        boolean eanFinished = false;

        while(!eanFinished){
            if(ean.length()>=3){
                iA=ean.substring(0,3);
            }else{
                iA = "";
            }
            if (iA.matches("00[0-9]")) {
                idPalet = Long.valueOf(getIdPalet(ean));
                ean = ean.substring(20);
            } else if (iA.matches("01[0-9]")) {
                idArticulo = getNumArticulo(ean);
                nombreArticulo = getNombre(ean);
                ean = ean.substring(16);
            } else if (iA.matches("10[0-9]")) {
                lote = getNumLote(ean);
                int posStar = ean.indexOf("*");
                ean = ean.substring(posStar + 1);
            } else if (iA.matches("11[0-9]")) {
                dateTime = formatDate(ean);
                ean = ean.substring(8);
            } else if (iA.equals("310")) {
                weight = Long.valueOf(getWeight(ean));
                ean = ean.substring(10);
            } else {
                eanFinished = true;
            }
        }

        PaletDto palet = new PaletDto(idPalet,idArticulo,nombreArticulo,lote,dateTime,weight);
        return ResponseEntity.accepted().body(palet);
    }


    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public void post(String id, String name) {
        Product product = new Product();
        product.setName(name);
        product.setId(id);
        repository.save(product);
    }

    @Override
    public void put(String id, String name) {
        Product product = repository.getReferenceById(id);
        product.setName(name);
        repository.save(product);
    }

}
