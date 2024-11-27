package com.programacionmateo.proyectonutricion.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_registrodiario")
@Entity
public class RegistroDiario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRegistroDiario;
    private String date;
    private String calorias_totales;

    // Relación con DetallesRegistro
    @OneToMany(mappedBy = "registroDiario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetallesRegistro> detallesRegistro;

    public RegistroDiario(Long idRegistroDiario) {
        this.idRegistroDiario = idRegistroDiario;
    }
}
