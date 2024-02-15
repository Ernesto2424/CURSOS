package domain;

/**
 *
 * @author Personal
 */

public class Pelicula {
    
    private String titulo;
    private String year;
    private String portada;
    private String genero;
    private String descripcion;

    public Pelicula(String titulo, String year, String portada, String genero, String descripcion) {
        this.titulo = titulo;
        this.year = year;
        this.portada = portada;
        this.genero = genero;
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "titulo=" + titulo + ", year=" + year + ", portada=" + portada + ", genero=" + genero + ", descripcion=" + descripcion + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
