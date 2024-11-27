package com.programacionmateo.proyectonutricion.Service.impl;

import com.programacionmateo.proyectonutricion.DTO.AlimentoDTO;
import com.programacionmateo.proyectonutricion.Entity.Alimento;
import com.programacionmateo.proyectonutricion.Exception.ResourceNotFoundException;
import com.programacionmateo.proyectonutricion.Mapper.AlimentoMapper;
import com.programacionmateo.proyectonutricion.Repository.AlimentoRepository;
import com.programacionmateo.proyectonutricion.Service.AlimentoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AlimentoServiceImpl implements AlimentoService {
    @Autowired
    private AlimentoRepository alimentoRepository;

    @Override
    public AlimentoDTO addAlimento(AlimentoDTO alimentoDTO) {
        Alimento alimento = new Alimento();

        alimento.setNombre(alimentoDTO.getNombre());
        alimento.setCalorias_por_porcion(alimentoDTO.getCalorias_por_porcion());
        alimento.setPorcion(alimentoDTO.getPorcion());

        Alimento savedAlimento = alimentoRepository.save(alimento);
        return AlimentoMapper.AlimentoToAlimentoDTO(savedAlimento);
    }

    @Override
    public AlimentoDTO updateAlimento(AlimentoDTO alimentoDTO) {
        // Verificar si el alimento existe
        Alimento existingAlimento = alimentoRepository.findById(alimentoDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Alimento no existe con el id: " + alimentoDTO.getId()));

        // Actualizar los campos
        existingAlimento.setNombre(alimentoDTO.getNombre());
        existingAlimento.setPorcion(alimentoDTO.getPorcion());
        existingAlimento.setCalorias_por_porcion(alimentoDTO.getCalorias_por_porcion());

        // Guardar los cambios
        Alimento updatedAlimento = alimentoRepository.save(existingAlimento);

        // Retornar como DTO
        return AlimentoMapper.AlimentoToAlimentoDTO(updatedAlimento);
    }

    @Override
    public AlimentoDTO getAlimentoById(Long id) {
        // Buscar el alimento
        Alimento alimento = alimentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alimento no existe con el id: " + id));

        // Retornar como DTO
        return AlimentoMapper.AlimentoToAlimentoDTO(alimento);
    }

    @Override
    public List<AlimentoDTO> getAllAlimentos() {
        // Obtener todos los alimentos
        List<Alimento> alimentos = alimentoRepository.findAll();

        // Mapear a DTO
        return alimentos.stream()
                .map(AlimentoMapper::AlimentoToAlimentoDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAlimentoById(Long id) {
        // Verificar si el alimento existe
        Alimento alimento = alimentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alimento no existe con el id: " + id));

        // Eliminar el alimento
        alimentoRepository.delete(alimento);
    }
}
