package com.programacionmateo.proyectonutricion.Controller;

import com.programacionmateo.proyectonutricion.DTO.RegistroDiarioDTO;
import com.programacionmateo.proyectonutricion.Service.RegistroDiarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/registros-diarios")
public class RegistroDiarioController {

    @Autowired
    private RegistroDiarioService registroDiarioService;

    // Crear un nuevo Registro Diario
    @PostMapping
    public ResponseEntity<RegistroDiarioDTO> createRegistroDiario(@RequestBody RegistroDiarioDTO registroDiarioDTO) {
        RegistroDiarioDTO registro = registroDiarioService.addRegistroDiario(registroDiarioDTO);
        return new ResponseEntity<>(registro, HttpStatus.CREATED);
    }

    // Obtener Registro Diario por ID
    @GetMapping("{id}")
    public ResponseEntity<RegistroDiarioDTO> getRegistroDiarioById(@PathVariable("id") Long registroId) {
        RegistroDiarioDTO registroDTO = registroDiarioService.getRegistroDiario(registroId);
        return ResponseEntity.ok(registroDTO);
    }

    // Obtener todos los Registros Diarios
    @GetMapping
    public ResponseEntity<List<RegistroDiarioDTO>> getAllRegistrosDiarios() {
        List<RegistroDiarioDTO> registros = registroDiarioService.getAllRegistroDiario();
        return ResponseEntity.ok(registros);
    }

    // Actualizar un Registro Diario
    @PutMapping("{id}")
    public ResponseEntity<RegistroDiarioDTO> updateRegistroDiario(@PathVariable("id") Long registroId,
                                                                  @RequestBody RegistroDiarioDTO updatedRegistro) {
        RegistroDiarioDTO registroDTO = registroDiarioService.updateRegistroDiario(updatedRegistro);
        return ResponseEntity.ok(registroDTO);
    }

    // Eliminar un Registro Diario
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRegistroDiario(@PathVariable("id") Long registroId) {
        registroDiarioService.deleteRegistroDiario(registroId);
        return ResponseEntity.ok("Registro diario eliminado correctamente.");
    }
}
