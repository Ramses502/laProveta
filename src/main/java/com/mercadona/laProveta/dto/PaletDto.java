package com.mercadona.laProveta.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PaletDto {

    private Long id;
    private String idArticulo;
    private String nombreArticulo;
    private String lote;
    private LocalDateTime fechaFabricacion;
    private Long pesoEnGramos;

    public PaletDto(Long id, String idArticulo, String nombreArticulo, String lote, LocalDateTime date, Long pesoEnGramos){
        this.id = id;
        this.idArticulo = idArticulo;
        this.nombreArticulo = nombreArticulo;
        this.lote = lote;
        this.fechaFabricacion = date;
        this.pesoEnGramos = pesoEnGramos;
    }
}
