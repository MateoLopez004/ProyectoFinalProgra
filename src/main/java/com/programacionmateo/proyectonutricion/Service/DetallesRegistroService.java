package com.programacionmateo.proyectonutricion.Service;

import com.programacionmateo.proyectonutricion.DTO.DetallesRegistroDTO;

import java.util.List;

public interface DetallesRegistroService {
    DetallesRegistroDTO addDetallesRegistro(DetallesRegistroDTO detallesRegistro);
    DetallesRegistroDTO updateDetallesRegistro(DetallesRegistroDTO detallesRegistro);
    DetallesRegistroDTO deleteDetallesRegistro(Long id);
    DetallesRegistroDTO getbyidDetallesRegistro(Long id);
    List<DetallesRegistroDTO> getAllDetallesRegistro();
}
