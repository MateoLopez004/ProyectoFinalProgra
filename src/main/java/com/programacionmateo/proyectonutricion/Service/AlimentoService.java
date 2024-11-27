package com.programacionmateo.proyectonutricion.Service;

import com.programacionmateo.proyectonutricion.DTO.AlimentoDTO;

import java.util.List;

public interface AlimentoService {
    AlimentoDTO addAlimento(AlimentoDTO alimento);
    AlimentoDTO updateAlimento(AlimentoDTO alimento);
    AlimentoDTO getAlimentoById(Long id);
    List<AlimentoDTO> getAllAlimentos();
    void deleteAlimentoById(Long id);
}
