package com.programacionmateo.proyectonutricion.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetallesRegistroDTO {
    private Long id;
    private String cantidad;
    private String calorias;
    private Long alimentoId; // ID del alimento relacionado
    private Long registroDiarioId;
}
