package co.edu.utp.isc.gia.Dia2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistorialDTO implements Serializable {

    private Long id;
    private String url;
    private String description;
    private Date fecha;
    private long usuarioId;
}
