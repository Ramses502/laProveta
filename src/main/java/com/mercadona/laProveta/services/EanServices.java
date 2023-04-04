package com.mercadona.laProveta.services;

import com.mercadona.laProveta.dto.PaletDto;
import com.mercadona.laProveta.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.List;

public interface EanServices {

    public String getIdPalet(String ean128);

    public String getNumArticulo(String ean128);

    public String getNumLote(String ean128);

    public String getDate(String ean128);

    public String getWeight(String ean128);

    public String getNombre(String ean128);

    public ResponseEntity<PaletDto> get(String ean128) throws ParseException;

    public void delete(String id);

    public void post(String id, String name);

    public void put(String id, String name);

    public LocalDateTime formatDate(String ean128) throws ParseException;

    public Page<Product> getAllProducts(Pageable pageable);
}
