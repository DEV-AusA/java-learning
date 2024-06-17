package git.devausa.screenmatch.excepcion;

public class ErrorConversionDeDuracionException extends RuntimeException {

    //declaro la variable mensaje
    private String mensaje;

    public ErrorConversionDeDuracionException(String mensaje) {
        this.mensaje = mensaje;
    }

    // sobreescribo el metodo getMessage para que devuelva el mensaje que declaré
    @Override
    public String getMessage() {
        return this.mensaje;
    }
}
