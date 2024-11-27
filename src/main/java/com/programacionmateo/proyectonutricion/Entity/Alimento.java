package com.programacionmateo.proyectonutricion.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "tbl_alimentos")
@AllArgsConstructor
@NoArgsConstructor
public class Alimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String calorias_por_porcion;
    private String porcion;

    // Relación inversa con DetallesRegistro
    @OneToMany(mappedBy = "alimento", fetch = FetchType.LAZY)
    private List<DetallesRegistro> detallesRegistro; // Un alimento puede estar en muchos detalles
}


