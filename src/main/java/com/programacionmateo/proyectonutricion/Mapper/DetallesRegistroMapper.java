package com.programacionmateo.proyectonutricion.Mapper;

import com.programacionmateo.proyectonutricion.DTO.DetallesRegistroDTO;
import com.programacionmateo.proyectonutricion.Entity.Alimento;
import com.programacionmateo.proyectonutricion.Entity.DetallesRegistro;
import com.programacionmateo.proyectonutricion.Entity.RegistroDiario;
import org.springframework.stereotype.Component;

@Component
public class DetallesRegistroMapper {

    // Convertir de DetallesRegistro a DetallesRegistroDTO
    public static DetallesRegistroDTO DetallesRegistroToDetallesRegistroDTO(DetallesRegistro detalle) {
        return new DetallesRegistroDTO(
                detalle.getId(),
                detalle.getCantidad(),
                detalle.getCalorias(),
                detalle.getAlimento() != null ? detalle.getAlimento().getId() : null, // Solo incluye el ID del Alimento
                detalle.getRegistroDiario() != null ? detalle.getRegistroDiario().getIdRegistroDiario() : null
        );
    }

    // Convertir de DetallesRegistroDTO a DetallesRegistro
    public static DetallesRegistro DetallesRegistroDTOToDetallesRegistro(DetallesRegistroDTO detalleDTO, Alimento alimento, RegistroDiario registroDiario) {
        DetallesRegistro detalle = new DetallesRegistro();
        detalle.setId(detalleDTO.getId());
        detalle.setCantidad(detalleDTO.getCantidad());
        detalle.setCalorias(detalleDTO.getCalorias());

        // Aquí asignamos directamente los objetos Alimento y RegistroDiario que han sido previamente buscados
        detalle.setAlimento(alimento);
        detalle.setRegistroDiario(registroDiario);

        return detalle;
    }
    }



