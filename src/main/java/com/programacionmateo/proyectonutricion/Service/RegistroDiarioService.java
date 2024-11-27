package com.programacionmateo.proyectonutricion.Service;

import com.programacionmateo.proyectonutricion.DTO.RegistroDiarioDTO;

import java.util.List;

public interface RegistroDiarioService {
    public RegistroDiarioDTO updateRegistroDiario(RegistroDiarioDTO registroDiarioDTO);

    public RegistroDiarioDTO addRegistroDiario(RegistroDiarioDTO registroDiarioDTO);

    public RegistroDiarioDTO getRegistroDiario(Long id);

    List<RegistroDiarioDTO> getAllRegistroDiario();

    List<RegistroDiarioDTO> getRegistroDiarioByid(Long id);

    List<RegistroDiarioDTO> deleteRegistroDiario(Long id);

}
