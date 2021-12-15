package co.edu.utp.isc.gia.Dia2.controller;

import co.edu.utp.isc.gia.Dia2.dto.EnvioDTO;
import co.edu.utp.isc.gia.Dia2.dto.UsuarioDTO;
import co.edu.utp.isc.gia.Dia2.exception.BadRequestException;
import co.edu.utp.isc.gia.Dia2.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
   private UsuarioService usuarioService;

    @PostMapping("crearUsuario")
    public UsuarioDTO crearUsuario (@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.crearUsuario(usuarioDTO);
    }

    @GetMapping("obtenerUsuario")
    public UsuarioDTO obtenerUsuario (@RequestBody Long id){
        return usuarioService.obtenerUsuario(id);
    }

    @GetMapping("obtenerPorCedula")
    public List<EnvioDTO> obtenerUsuarioPorCedula(@RequestParam("cedula") Long cedula) throws BadRequestException {
        return usuarioService.obtenerUsuarioPorCedula(cedula);
    }

}
