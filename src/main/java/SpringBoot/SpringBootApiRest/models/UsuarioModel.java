package SpringBoot.SpringBootApiRest.models;


import jakarta.persistence.*;

@Entity
/*
 * Con entity decimos que es un modelo real y que cada uno de los campos
 * que añadamos sera una columna en la base de datos
 */
@Table(name = "usuarios")
/* especificamos que la tabla se va a llamar usuario */
public class UsuarioModel {

    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /* que se genere automaticamente y que se atutoincremente el campo id */
    @Column(unique = true, nullable = false)
    /* que es unico y no null */
    private long id;


    private String nombre;
    private String apellido;
    private long edad;
    private String email;
    private long prioridad;

    @ManyToOne
    // Indica que muchos usuarios pueden pertenecer a un mismo país.
    // Ejemplo: Usuario 1 -> Colombia
    //          Usuario 2 -> Colombia
    //          Usuario 3 -> Colombia

    @JoinColumn(name = "id_pais")
    // Indica que la columna "id_pais" de la tabla usuario será la clave foránea.
    // Esta columna almacenará el ID del país relacionado.
    // Por ejemplo: id_pais = 1 significa que el usuario pertenece al país cuyo ID es 1.
    // dado que en las propiedades tenemos spring.jpa.hibernate.ddl-auto=update jpa creara la table usuarios
    // con esta clave foranea
    private PaisModel pais;



    @ManyToOne
    @JoinColumn(name = "id_estado")
    private EstadoModel estado;

    /* DECLARANDO LOS METODOS PARA MANIPULAR LAS PROPIEDADES DE LA CLASE */
    public void setPrioridad(long prioridad) {
        this.prioridad = prioridad;
    }

    public long getPrioridad() {
        return prioridad;
    }

    public long getId() {
        return id;
    }

    /* Ingresar el id */
    public void setId(long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
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

    public PaisModel getPais() {
        return pais;
    }

    public void setPais(PaisModel pais) {
        this.pais = pais;
    }
    public EstadoModel getEstado() {
        return estado;
    }

    public void setEstado(EstadoModel estado) {
        this.estado = estado;
    }

}
