package com.mercadona.laProveta.services;

import com.mercadona.laProveta.dto.PaletDto;
import com.mercadona.laProveta.exceptions.IdArticuloException;
import com.mercadona.laProveta.exceptions.IdPaletException;

import java.text.ParseException;
import java.time.LocalDateTime;

public interface EanServices {

    public String getIdPalet(String ean128);

    public String getNumArticulo(String ean128);

    public String getNumLote(String ean128);

    public String getDate(String ean128);

    public String getWeight(String ean128);

    public String getNombre(String ean128);

    public PaletDto get(String ean128) throws ParseException, IdPaletException, IdArticuloException;

    public void delete(String id);

    public void post(String id, String name);

    public void put(String id, String name);

    public LocalDateTime formatDate(String ean128) throws ParseException;
}
