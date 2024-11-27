package com.programacionmateo.proyectonutricion.Controller;

import com.programacionmateo.proyectonutricion.DTO.AlimentoDTO;
import com.programacionmateo.proyectonutricion.Service.AlimentoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/alimentos")
public class AlimentoController {

    @Autowired
    private AlimentoService alimentoService;

    // Crear un nuevo Alimento
    @PostMapping
    public ResponseEntity<AlimentoDTO> createAlimento(@RequestBody AlimentoDTO alimentoDTO) {
        AlimentoDTO alimento = alimentoService.addAlimento(alimentoDTO);
        return new ResponseEntity<>(alimento, HttpStatus.CREATED);
    }

    // Obtener Alimento por ID
    @GetMapping("{id}")
    public ResponseEntity<AlimentoDTO> getAlimentoById(@PathVariable("id") Long alimentoId) {
        AlimentoDTO alimentoDTO = alimentoService.getAlimentoById(alimentoId);
        return ResponseEntity.ok(alimentoDTO);
    }

    // Obtener todos los Alimentos
    @GetMapping
    public ResponseEntity<List<AlimentoDTO>> getAllAlimentos() {
        List<AlimentoDTO> alimentos = alimentoService.getAllAlimentos();
        return ResponseEntity.ok(alimentos);
    }

    // Actualizar un Alimento
    @PutMapping("{id}")
    public ResponseEntity<AlimentoDTO> updateAlimento(@PathVariable("id") Long alimentoId,
                                                      @RequestBody AlimentoDTO updatedAlimento) {
        updatedAlimento.setId(alimentoId);
        AlimentoDTO alimentoDTO = alimentoService.updateAlimento(updatedAlimento);
        return ResponseEntity.ok(alimentoDTO);
    }

    // Eliminar un Alimento
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAlimento(@PathVariable("id") Long alimentoId) {
        alimentoService.deleteAlimentoById(alimentoId);
        return ResponseEntity.ok("Alimento eliminado correctamente.");
    }
}