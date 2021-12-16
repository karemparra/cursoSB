package co.edu.utp.isc.gia.Dia2.controller;

import co.edu.utp.isc.gia.Dia2.dto.HistorialDTO;
import co.edu.utp.isc.gia.Dia2.service.HistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("historial")
public class HistorialController {

    @Autowired
    private HistorialService historialService;

    @PostMapping("guardarHistorial")
    public HistorialDTO guardarHistorial(@RequestBody HistorialDTO historialDTO){
        return historialService.guardarHistorial(historialDTO);
    }

}
