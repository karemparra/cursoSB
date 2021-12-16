package co.edu.utp.isc.gia.Dia2.service.impl;

import co.edu.utp.isc.gia.Dia2.dto.EnvioDTO;
import co.edu.utp.isc.gia.Dia2.dto.UsuarioDTO;
import co.edu.utp.isc.gia.Dia2.entities.UsuarioEntity;
import co.edu.utp.isc.gia.Dia2.exception.BadRequestException;
import co.edu.utp.isc.gia.Dia2.repository.UsuarioRepository;
import co.edu.utp.isc.gia.Dia2.service.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public UsuarioDTO obtenerUsuario(Long id) {

        Optional<UsuarioEntity> optionalUsuarioEntity = this.usuarioRepository.findById(id);
        if(optionalUsuarioEntity.isPresent()){
            UsuarioDTO usuarioDTO = modelMapper.map(optionalUsuarioEntity.get(), UsuarioDTO.class);
            return usuarioDTO;
        } else {
            return null;
        }

        //UsuarioEntity usuarioEntity = modelMapper.map(this.usuarioDTO, UsuarioEntity.class);
        //Optional<UsuarioEntity> usuarioEntityDB = this.usuarioRepository.findById(id);
        //return modelMapper.map(usuarioEntityDB, UsuarioDTO.class);
    }

    @Override
    public List<EnvioDTO> obtenerUsuarioPorCedula(Long cedula) throws BadRequestException {
        List<UsuarioEntity> usuarioEntities = usuarioRepository.findByCedula(cedula);
        if (!usuarioEntities.isEmpty()) {
            List<EnvioDTO> envioDTOS = new ArrayList<>();
            usuarioEntities.forEach(usuarioEntity -> {
                envioDTOS.add(modelMapper.map(usuarioEntity, EnvioDTO.class));
            });
            return envioDTOS;

        } else {
            throw new BadRequestException("No se encuentra usuario por la cedula");
        }
    }

    @Override
    public UsuarioDTO actualizarRegistro(UsuarioDTO usuarioDTO) {
        Optional<UsuarioEntity> optionalUsuarioEntity = this.usuarioRepository.findById(usuarioDTO.getId());
        if(optionalUsuarioEntity.isPresent()){
            UsuarioEntity usuarioEntity = modelMapper.map(usuarioDTO, UsuarioEntity.class);
            UsuarioEntity usuarioEntityDB = this.usuarioRepository.save(usuarioEntity);
            return  modelMapper.map(usuarioEntityDB, UsuarioDTO.class);
        } else {
            return null;
        }

    }

    @Override
    public UsuarioDTO borrarUsuarioPorId(UsuarioDTO usuarioDTO) {
        Optional<UsuarioEntity> optionalUsuarioEntity = this.usuarioRepository.findById(usuarioDTO.getId());
        if (optionalUsuarioEntity.isPresent()) {
            UsuarioEntity usuarioEntity = modelMapper.map(usuarioDTO, UsuarioEntity.class);
            this.usuarioRepository.delete(usuarioEntity);
            return usuarioDTO;
        } else {
            return null;
        }

    }


}

/* Request POST
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