package co.edu.utp.isc.gia.Dia2.service.impl;

import co.edu.utp.isc.gia.Dia2.dto.HistorialDTO;
import co.edu.utp.isc.gia.Dia2.entities.HistorialEntity;
import co.edu.utp.isc.gia.Dia2.entities.UsuarioEntity;
import co.edu.utp.isc.gia.Dia2.repository.HistorialRepository;
import co.edu.utp.isc.gia.Dia2.service.HistorialService;
import co.edu.utp.isc.gia.Dia2.service.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistorialServiceImpl implements HistorialService {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private HistorialRepository historialRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public HistorialDTO guardarHistorial(HistorialDTO historialDTO) {
        UsuarioEntity usuarioEntity = usuarioService.obtenerUsuarioHistorial(historialDTO.getUsuarioId());
        HistorialEntity historialEntity = modelMapper.map(historialDTO, HistorialEntity.class);
        historialEntity.setUsuarioEntity(usuarioEntity);
        return modelMapper.map(historialRepository.save(historialEntity), HistorialDTO.class);
    }
}
