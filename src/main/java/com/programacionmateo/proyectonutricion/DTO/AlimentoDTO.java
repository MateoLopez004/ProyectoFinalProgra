package com.programacionmateo.proyectonutricion.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AlimentoDTO {
    private Long id;
    private String nombre;
    private String calorias_por_porcion;
    private String porcion;


    private List<DetallesRegistroDTO> detallesRegistro; // Para cambiar a lista de DetallesRegistroDTO

    // Constructor que acepta List<DetallesRegistroDTO> para los detalles completos
    public AlimentoDTO(Long id, String nombre, String caloriasPorPorcion, String porcion, List<DetallesRegistroDTO> detallesRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.calorias_por_porcion = caloriasPorPorcion;
        this.porcion = porcion;
        this.detallesRegistro = detallesRegistro;
    }
}