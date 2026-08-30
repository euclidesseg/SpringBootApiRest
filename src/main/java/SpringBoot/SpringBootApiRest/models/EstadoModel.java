package SpringBoot.SpringBootApiRest.models;


import jakarta.persistence.*;

@Entity
@Table(name = "estados")
public class EstadoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_pais")
    private PaisModel pais;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public PaisModel getPais() {
        return pais;
    }

    public void setPais(PaisModel pais) {
        this.pais = pais;
    }
}
