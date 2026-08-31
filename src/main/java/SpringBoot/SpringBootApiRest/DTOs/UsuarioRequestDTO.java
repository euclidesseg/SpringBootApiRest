package SpringBoot.SpringBootApiRest.DTOs;

public class UsuarioRequestDTO {

    private String nombre;
    private String apellido;
    private long edad;
    private String email;
    private long prioridad;

    private long paisId;
    private long estadoId;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getEdad() {
        return edad;
    }

    public void setEdad(long edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(long prioridad) {
        this.prioridad = prioridad;
    }

    public long getPaisId() {
        return paisId;
    }

    public void setPaisId(long paisId) {
        this.paisId = paisId;
    }

    public long getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(long estadoId) {
        this.estadoId = estadoId;
    }
}
