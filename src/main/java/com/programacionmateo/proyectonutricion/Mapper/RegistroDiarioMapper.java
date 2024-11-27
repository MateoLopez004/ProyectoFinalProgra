package com.programacionmateo.proyectonutricion.Mapper;

import com.programacionmateo.proyectonutricion.DTO.RegistroDiarioDTO;
import com.programacionmateo.proyectonutricion.Entity.RegistroDiario;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
@Component
    public class RegistroDiarioMapper {

            // Convertir de RegistroDiario a RegistroDiarioDTO
            public static RegistroDiarioDTO RegistroDiarioToRegistroDiarioDTO(RegistroDiario registro) {
                return new RegistroDiarioDTO(
                        registro.getIdRegistroDiario(),
                        registro.getDate(),
                        registro.getCalorias_totales(),
                        registro.getDetallesRegistro() != null
                                ? registro.getDetallesRegistro().stream()
                                .map(detalle -> detalle.getId()) // Obtener solo los IDs de los detalles
                                .collect(Collectors.toList())
                                : null
                );
            }

            // Convertir de RegistroDiarioDTO a RegistroDiario
            public static RegistroDiario RegistroDiarioDTOToRegistroDiario(RegistroDiarioDTO registroDTO) {
                RegistroDiario registro = new RegistroDiario();
                registro.setIdRegistroDiario(registroDTO.getIdRegistroDiario());
                registro.setDate(registroDTO.getDate());
                registro.setCalorias_totales(registroDTO.getCalorias_totales());

                return registro;
            }
        }



