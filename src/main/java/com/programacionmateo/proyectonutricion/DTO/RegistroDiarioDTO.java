package com.programacionmateo.proyectonutricion.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistroDiarioDTO {
    private Long idRegistroDiario;
    private String date;
    private String calorias_totales;

    // Lista de IDs de los detalles relacionados
    private List<Long> detallesRegistroIds;
}
