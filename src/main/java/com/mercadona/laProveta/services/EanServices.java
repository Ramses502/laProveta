package com.mercadona.laProveta.services;

import com.mercadona.laProveta.dto.PaleDto;

import java.text.ParseException;
import java.time.LocalDateTime;

public interface EanServices {

    public String getIdPalet(String ean128);

    public String getNumArticulo(String ean128);

    public String getNumLote(String ean128);

    public String getDate(String ean128);

    public String getWeight(String ean128);

    public String getNombre(String ean128);

    public PaleDto get(String ean128) throws ParseException;

    public void delete(String id);

    public void post(String id, String name);

    public void put(String id, String name);

    public LocalDateTime formatDate(String ean128) throws ParseException;
}
