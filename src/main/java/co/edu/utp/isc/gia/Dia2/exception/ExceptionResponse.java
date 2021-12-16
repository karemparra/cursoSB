package co.edu.utp.isc.gia.Dia2.exception;

import java.util.Date;

public class ExceptionResponse {
    private Date timestamp;
    private String mensaje;
    private String detalles;
    private String httpCodeMessage;

    public ExceptionResponse(Date timestamp, String message, String httpCodeMessage) {
        super();
        this.timestamp = timestamp;
        this.mensaje = message;
        this.httpCodeMessage = httpCodeMessage;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getDetalles() {
        return detalles;
    }

    public String getHttpCodeMessage() {
        return httpCodeMessage;
    }
}
