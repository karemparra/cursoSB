package co.edu.utp.isc.gia.Dia2.controller;

import co.edu.utp.isc.gia.Dia2.dto.UsuarioDTO;
import co.edu.utp.isc.gia.Dia2.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
   private UsuarioService usuarioService;

    @PostMapping("crearUsuario")
    public UsuarioDTO crearUsuario (@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.crearUsuario(usuarioDTO);
    }
}
