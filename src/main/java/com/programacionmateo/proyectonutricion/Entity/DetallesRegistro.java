package com.programacionmateo.proyectonutricion.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tbl_detalles")
@AllArgsConstructor
@NoArgsConstructor
public class DetallesRegistro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cantidad;
    private String calorias;

    // Relación con Alimento
    @ManyToOne
    @JoinColumn(name = "alimento_id", referencedColumnName = "id")
    private Alimento alimento;

    // Relación con RegistroDiario
    @ManyToOne
    @JoinColumn(name = "registro_diario_id", referencedColumnName = "idRegistroDiario")
    private RegistroDiario registroDiario;
}

