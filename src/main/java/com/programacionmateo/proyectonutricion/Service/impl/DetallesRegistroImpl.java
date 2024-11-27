package com.programacionmateo.proyectonutricion.Service.impl;

import com.programacionmateo.proyectonutricion.DTO.DetallesRegistroDTO;
import com.programacionmateo.proyectonutricion.Entity.Alimento;
import com.programacionmateo.proyectonutricion.Entity.DetallesRegistro;
import com.programacionmateo.proyectonutricion.Entity.RegistroDiario;
import com.programacionmateo.proyectonutricion.Exception.ResourceNotFoundException;
import com.programacionmateo.proyectonutricion.Mapper.DetallesRegistroMapper;
import com.programacionmateo.proyectonutricion.Repository.AlimentoRepository;
import com.programacionmateo.proyectonutricion.Repository.DetallesRegistroRepository;
import com.programacionmateo.proyectonutricion.Repository.RegistroDiarioRepository;
import com.programacionmateo.proyectonutricion.Service.DetallesRegistroService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DetallesRegistroImpl implements DetallesRegistroService {
    @Autowired
    private DetallesRegistroRepository detallesRegistroRepository;

    @Autowired
    private AlimentoRepository alimentoRepository;

    @Autowired
    private RegistroDiarioRepository registroDiarioRepository;

    @Autowired
    private DetallesRegistroMapper detallesRegistroMapper;

    @Override
    public DetallesRegistroDTO addDetallesRegistro(DetallesRegistroDTO detallesRegistroDTO) {
        // Validar los datos entrantes
        if (detallesRegistroDTO.getCantidad() == null || detallesRegistroDTO.getCantidad().isEmpty()) {
            throw new IllegalArgumentException("La cantidad no puede estar vacía");
        }

        // Buscar el alimento y el registro diario
        Alimento alimento = alimentoRepository.findById(detallesRegistroDTO.getAlimentoId())
                .orElseThrow(() -> new ResourceNotFoundException("Alimento no encontrado con ID: " + detallesRegistroDTO.getAlimentoId()));

        RegistroDiario registroDiario = registroDiarioRepository.findById(detallesRegistroDTO.getRegistroDiarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Registro diario no encontrado con ID: " + detallesRegistroDTO.getRegistroDiarioId()));

        // Crear un nuevo objeto DetallesRegistro
        DetallesRegistro detalle = new DetallesRegistro();
        detalle.setCantidad(detallesRegistroDTO.getCantidad());
        detalle.setCalorias(detallesRegistroDTO.getCalorias());
        detalle.setAlimento(alimento);
        detalle.setRegistroDiario(registroDiario);

        // Guardar el detalle de registro
        DetallesRegistro savedDetalle = detallesRegistroRepository.save(detalle);

        // Retornar el DTO del detalle guardado
        return detallesRegistroMapper.DetallesRegistroToDetallesRegistroDTO(savedDetalle);
    }

    @Override
    public DetallesRegistroDTO updateDetallesRegistro(DetallesRegistroDTO detallesRegistroDTO) {
        // Buscar el detalle de registro por ID
        DetallesRegistro detalle = detallesRegistroRepository.findById(detallesRegistroDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Detalle de registro no encontrado con ID: " + detallesRegistroDTO.getId()));

        // Actualizar los campos del detalle
        detalle.setCantidad(detallesRegistroDTO.getCantidad());
        detalle.setCalorias(detallesRegistroDTO.getCalorias());

        // Buscar el alimento y el registro diario
        Alimento alimento = alimentoRepository.findById(detallesRegistroDTO.getAlimentoId())
                .orElseThrow(() -> new ResourceNotFoundException("Alimento no encontrado con ID: " + detallesRegistroDTO.getAlimentoId()));

        RegistroDiario registroDiario = registroDiarioRepository.findById(detallesRegistroDTO.getRegistroDiarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Registro diario no encontrado con ID: " + detallesRegistroDTO.getRegistroDiarioId()));

        detalle.setAlimento(alimento);
        detalle.setRegistroDiario(registroDiario);

        // Guardar el detalle actualizado
        DetallesRegistro updatedDetalle = detallesRegistroRepository.save(detalle);

        // Retornar el DTO del detalle actualizado
        return detallesRegistroMapper.DetallesRegistroToDetallesRegistroDTO(updatedDetalle);
    }

    @Override
    public DetallesRegistroDTO deleteDetallesRegistro(Long id) {
        // Buscar el detalle por ID
        DetallesRegistro detalle = detallesRegistroRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new ResourceNotFoundException("Detalle de registro no encontrado con ID: " + id));

        // Eliminar el detalle de registro
        detallesRegistroRepository.delete(detalle);

        // Retornar el DTO del detalle eliminado
        return detallesRegistroMapper.DetallesRegistroToDetallesRegistroDTO(detalle);
    }

    @Override
    public DetallesRegistroDTO getbyidDetallesRegistro(Long id) {
        // Buscar el detalle de registro por ID
        DetallesRegistro detalle = detallesRegistroRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new ResourceNotFoundException("Detalle de registro no encontrado con ID: " + id));

        // Convertir el detalle a DTO
        return detallesRegistroMapper.DetallesRegistroToDetallesRegistroDTO(detalle);
    }

    @Override
    public List<DetallesRegistroDTO> getAllDetallesRegistro() {
        // Obtener todos los detalles de registro
        List<DetallesRegistro> detalles = detallesRegistroRepository.findAll();

        // Convertir los detalles a DTOs
        return detalles.stream()
                .map(detalle -> detallesRegistroMapper.DetallesRegistroToDetallesRegistroDTO(detalle))
                .collect(Collectors.toList());
    }

}
