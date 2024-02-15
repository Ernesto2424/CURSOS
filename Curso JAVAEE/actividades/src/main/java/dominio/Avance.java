package dominio;

/**
 *
 * Esta clase va a permitir crear instancias del tipo anvace, se puede crear con
 * diferentes parametros para que se le de un uso distino a cada metodo
 * constructor
 *
 * @author Personal
 */
public class Avance {

    private int id;
    private String fecha;
    private int avance;
    private String descripcion;
    private int idTarea;
    private int idEmpleado;
    private String nombreEmpleado;

    public Avance(int id, String fecha, int avance, String descripcion, int idTarea, int idEmpleado) {
        this.id = id;
        this.fecha = fecha;
        this.avance = avance;
        this.descripcion = descripcion;
        this.idTarea = idTarea;
        this.idEmpleado = idEmpleado;
    }

    public Avance(String fecha, int avance, String descripcion, int idTarea) {
        this.fecha = fecha;
        this.avance = avance;
        this.descripcion = descripcion;
        this.idTarea = idTarea;
    }

    public Avance(String fecha, int avance, String descripcion, int idTarea, int idEmpleado) {
        this.fecha = fecha;
        this.avance = avance;
        this.descripcion = descripcion;
        this.idTarea = idTarea;
        this.idEmpleado = idEmpleado;
    }

    public Avance(String fecha, int avance, String descripcion, String nombreEmpleado) {
        this.fecha = fecha;
        this.avance = avance;
        this.descripcion = descripcion;
        this.nombreEmpleado = nombreEmpleado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getAvance() {
        return avance;
    }

    public void setAvance(int avance) {
        this.avance = avance;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    @Override
    public String toString() {
        return "Avance{" + "id=" + id + ", fecha=" + fecha + ", avance=" + avance + ", descripcion=" + descripcion + ", idTarea=" + idTarea + ", idEmpleado=" + idEmpleado + ", nombreEmpleado=" + nombreEmpleado + '}';
    }

}
