package com.programacionmateo.proyectonutricion.Mapper;

import com.programacionmateo.proyectonutricion.DTO.AlimentoDTO;
import com.programacionmateo.proyectonutricion.DTO.DetallesRegistroDTO;
import com.programacionmateo.proyectonutricion.Entity.Alimento;
import com.programacionmateo.proyectonutricion.Entity.DetallesRegistro;
import com.programacionmateo.proyectonutricion.Entity.RegistroDiario;
import com.programacionmateo.proyectonutricion.Repository.DetallesRegistroRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Component
public class AlimentoMapper {
    // Convertir de Alimento a AlimentoDTO
    public static AlimentoDTO AlimentoToAlimentoDTO(Alimento alimento) {
        // Mapear los detalles de Alimento a DetallesRegistroDTO
        List<DetallesRegistroDTO> detallesDTO = new ArrayList<>();
        if (alimento.getDetallesRegistro() != null) {
            for (DetallesRegistro detalle : alimento.getDetallesRegistro()) {
                detallesDTO.add(DetallesRegistroMapper.DetallesRegistroToDetallesRegistroDTO(detalle));
            }
        }

        return new AlimentoDTO(
                alimento.getId(),
                alimento.getNombre(),
                alimento.getCalorias_por_porcion(),
                alimento.getPorcion(),
                detallesDTO
        );
    }

    // Convertir de AlimentoDTO a Alimento
    public static Alimento AlimentoDTOToAlimento(AlimentoDTO alimentoDTO) {
        Alimento alimento = new Alimento();
        alimento.setId(alimentoDTO.getId());
        alimento.setNombre(alimentoDTO.getNombre());
        alimento.setCalorias_por_porcion(alimentoDTO.getCalorias_por_porcion());
        alimento.setPorcion(alimentoDTO.getPorcion());

        // Convierte los DetallesRegistroDTO a DetallesRegistro y los asigna
        List<DetallesRegistro> detalles = new ArrayList<>();
        if (alimentoDTO.getDetallesRegistro() != null) {
            for (DetallesRegistroDTO detalleDTO : alimentoDTO.getDetallesRegistro()) {  //Bucle for-each, recorre todos los elementos de la lista
                                                                                        //  y cada elemento se asigna a la variable detalleDTO
                // Obtener el Alimento o RegistroDiario relacionado si es necesario
                DetallesRegistro detalle = DetallesRegistroMapper.DetallesRegistroDTOToDetallesRegistro(
                        detalleDTO,
                        alimento,  // Si se requiere un contexto de Alimento
                        detalleDTO.getRegistroDiarioId() != null
                                ? new RegistroDiario(detalleDTO.getRegistroDiarioId())  // Crea un objeto si es que detalleDTO.getRegistroDiarioId() es diferente a nulo necesario
                                : null // sino sera null
                );
                detalles.add(detalle);
            }
        }
        alimento.setDetallesRegistro(detalles);


        return alimento;
    }
}

