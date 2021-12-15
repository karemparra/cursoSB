package co.edu.utp.isc.gia.Dia2.service.impl;

import co.edu.utp.isc.gia.Dia2.dto.UsuarioDTO;
import co.edu.utp.isc.gia.Dia2.entities.UsuarioEntity;
import co.edu.utp.isc.gia.Dia2.repository.UsuarioRepository;
import co.edu.utp.isc.gia.Dia2.service.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO) {

        if(!usuarioDTO.equals(null) && usuarioDTO != null){

            //UsuarioEntity usuarioEntity = modelMapper.map(usuarioDTO, UsuarioEntity.class);
            //UsuarioEntity usuarioEntityDB = this.usuarioRepository.save(usuarioEntity);
            //return modelMapper.map(usuarioEntityDB, UsuarioDTO.class);

            UsuarioEntity usuarioEntity = modelMapper.map(usuarioDTO, UsuarioEntity.class);
            return modelMapper.map(this.usuarioRepository.save(usuarioEntity), UsuarioDTO.class);
        } else {
            return null;
        }
    }
}

/* Request de POST
* {
    "cedula":"",
    "nombre":"",
    "apellido":"",
    "email":"",
    "telefono":"",
    "direccion":"",
    "codPostal":"",
    "fechaNacimiento":"",
    "eps":"",
    "estadoCivil":""
}
* */