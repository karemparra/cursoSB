package co.edu.utp.isc.gia.Dia2.service;

import co.edu.utp.isc.gia.Dia2.dto.EnvioDTO;
import co.edu.utp.isc.gia.Dia2.dto.UsuarioDTO;
import co.edu.utp.isc.gia.Dia2.exception.BadRequestException;

import java.util.List;

public interface UsuarioService {
    UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO);
    UsuarioDTO obtenerUsuario(Long id);
    List<EnvioDTO> obtenerUsuarioPorCedula(Long cedula) throws BadRequestException;
    UsuarioDTO actualizarRegistro(UsuarioDTO usuarioDTO);
    UsuarioDTO borrarUsuarioPorId(UsuarioDTO usuarioDTO);
}
