package com.programacionmateo.proyectonutricion.Service.impl;

import com.programacionmateo.proyectonutricion.DTO.RegistroDiarioDTO;
import com.programacionmateo.proyectonutricion.Entity.RegistroDiario;
import com.programacionmateo.proyectonutricion.Exception.ResourceNotFoundException;
import com.programacionmateo.proyectonutricion.Mapper.RegistroDiarioMapper;
import com.programacionmateo.proyectonutricion.Repository.RegistroDiarioRepository;
import com.programacionmateo.proyectonutricion.Service.RegistroDiarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Transactional
@Service
public class RegistroDiarioServiceImpl implements RegistroDiarioService {
    @Autowired
    private RegistroDiarioRepository registroDiarioRepository;

    @Autowired
    private RegistroDiarioMapper registroDiarioMapper;

    @Override
    public RegistroDiarioDTO addRegistroDiario(RegistroDiarioDTO registroDiarioDTO) {
        // Convertir el DTO en la entidad
        RegistroDiario registroDiario = registroDiarioMapper.RegistroDiarioDTOToRegistroDiario(registroDiarioDTO);

        // Guardar la entidad en la base de datos
        RegistroDiario savedRegistroDiario = registroDiarioRepository.save(registroDiario);

        // Convertir la entidad guardada a DTO y retornar
        return registroDiarioMapper.RegistroDiarioToRegistroDiarioDTO(savedRegistroDiario);
    }

    @Override
    public RegistroDiarioDTO updateRegistroDiario(RegistroDiarioDTO registroDiarioDTO) {
        // Buscar el registro diario por ID
        RegistroDiario existingRegistroDiario = registroDiarioRepository.findById(registroDiarioDTO.getIdRegistroDiario())
                .orElseThrow(() -> new ResourceNotFoundException("Registro diario no encontrado con ID: " + registroDiarioDTO.getIdRegistroDiario()));

        // Actualizar los campos de la entidad
        existingRegistroDiario.setDate(registroDiarioDTO.getDate());
        existingRegistroDiario.setCalorias_totales(registroDiarioDTO.getCalorias_totales());

        // Guardar la entidad actualizada
        RegistroDiario updatedRegistroDiario = registroDiarioRepository.save(existingRegistroDiario);

        // Convertir la entidad actualizada a DTO y retornar
        return registroDiarioMapper.RegistroDiarioToRegistroDiarioDTO(updatedRegistroDiario);
    }

    @Override
    public RegistroDiarioDTO getRegistroDiario(Long id) {
        // Buscar el registro diario por ID
        RegistroDiario registroDiario = registroDiarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Registro diario no encontrado con ID: " + id));

        // Convertir la entidad a DTO y retornar
        return registroDiarioMapper.RegistroDiarioToRegistroDiarioDTO(registroDiario);
    }

    @Override
    public List<RegistroDiarioDTO> getAllRegistroDiario() {
        // Obtener todos los registros diarios
        List<RegistroDiario> registrosDiarios = registroDiarioRepository.findAll();

        // Convertir los registros a DTOs y retornar como lista
        return registrosDiarios.stream()
                .map(registroDiario -> registroDiarioMapper.RegistroDiarioToRegistroDiarioDTO(registroDiario))
                .collect(Collectors.toList());
    }

    @Override
    public List<RegistroDiarioDTO> getRegistroDiarioByid(Long id) {
        // Buscar todos los registros diarios con el ID dado
        Optional<RegistroDiario> registrosDiarios = registroDiarioRepository.findById(id);

        // Convertir los registros encontrados a DTOs
        return registrosDiarios.stream()
                .map(registroDiario -> registroDiarioMapper.RegistroDiarioToRegistroDiarioDTO(registroDiario))
                .collect(Collectors.toList());
    }

    @Override
    public List<RegistroDiarioDTO> deleteRegistroDiario(Long id) {
        // Buscar el registro diario por ID
        RegistroDiario registroDiario = registroDiarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Registro diario no encontrado con ID: " + id));

        // Eliminar el registro de la base de datos
        registroDiarioRepository.delete(registroDiario);

        // Retornar el DTO del registro eliminado
        return List.of(registroDiarioMapper.RegistroDiarioToRegistroDiarioDTO(registroDiario));
    }
}
