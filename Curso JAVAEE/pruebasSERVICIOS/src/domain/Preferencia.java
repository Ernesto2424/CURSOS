package domain;

public class Preferencia {

private int id;
private int idGenero;
private int idUsuario;
private String nombreGenero;

    public Preferencia(int id, int idGenero, int idUsuario) {
        this.id = id;
        this.idGenero = idGenero;
        this.idUsuario = idUsuario;
    }

    public Preferencia(int idGenero, int idUsuario) {
        this.idGenero = idGenero;
        this.idUsuario = idUsuario;
    }

    public Preferencia(String nombreGenero) {
        this.nombreGenero = nombreGenero;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreGenero() {
        return nombreGenero;
    }

    public void setNombreGenero(String nombreGenero) {
        this.nombreGenero = nombreGenero;
    }
    
    

    @Override
    public String toString() {
        return "Preferencia{" + "id=" + id + ", idGenero=" + idGenero + ", idUsuario=" + idUsuario + '}';
    }





    
}
