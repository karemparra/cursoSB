package co.edu.utp.isc.gia.Dia2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO implements Serializable {
    private Long id;
    private Long cedula;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String direccion;
    private String codigoPostal;
    private Date fechaNacimiento;
    private String eps;
    private String estadoCivil;
}
