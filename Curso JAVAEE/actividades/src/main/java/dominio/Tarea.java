package dominio;

import java.util.Date;

/**
 *
 * Esta clase nos va a permitir crear objetos del tipo tarea, asi como tambien
 * la obtencion de la informacion de una actividad específica
 *
 * @author Personal
 */
public class Tarea {

    private int id;
    private String nombre;
    private String descripcion;
    private String fechaI;
    private String fechaT;
    private Date fechaF;
    private int idPrioridad;
    private int idEstado;
    private int idEmpleado;
    private String nombreEmpleado;
    private String nombrePrioridad;

    public Tarea() {
    }

    public Tarea(String nombre, String fechaI, String fechaT, int idPrioridad, int idEmpleado) {
        this.nombre = nombre;
        this.fechaI = fechaI;
        this.fechaT = fechaT;
        this.idPrioridad = idPrioridad;
        this.idEmpleado = idEmpleado;
    }

    public Tarea(int id, String nombre, String fechaI, String fechaT, String nombreEmpleado, String nombrePrioridad) {
        this.id = id;
        this.nombre = nombre;
        this.fechaI = fechaI;
        this.fechaT = fechaT;
        this.nombreEmpleado = nombreEmpleado;
        this.nombrePrioridad = nombrePrioridad;
    }

    public Tarea(int id, String nombre, String fechaI, String fechaT, int idEmpleado, String nombreEmpleado, String nombrePrioridad) {
        this.id = id;
        this.nombre = nombre;
        this.fechaI = fechaI;
        this.fechaT = fechaT;
        this.idEmpleado = idEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.nombrePrioridad = nombrePrioridad;
    }

    public Tarea(String nombre, String fechaI, String fechaT, String nombreEmpleado, String nombrePrioridad) {
        this.nombre = nombre;
        this.fechaI = fechaI;
        this.fechaT = fechaT;
        this.nombreEmpleado = nombreEmpleado;
        this.nombrePrioridad = nombrePrioridad;
    }

    public Tarea(String nombre, String descripcion, String fechaI, String fechaT, Date fechaF, int idPrioridad, int idEstado, int idEmpleado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaI = fechaI;
        this.fechaT = fechaT;
        this.fechaF = fechaF;
        this.idPrioridad = idPrioridad;
        this.idEstado = idEstado;
        this.idEmpleado = idEmpleado;
    }

    public Tarea(String nombre, String descripcion, String fechaI, String fechaT, int idPrioridad, int idEstado, int idEmpleado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaI = fechaI;
        this.fechaT = fechaT;
        this.idPrioridad = idPrioridad;
        this.idEstado = idEstado;
        this.idEmpleado = idEmpleado;
    }

    public Tarea(int id, String nombre, String descripcion, String fechaI, String fechaT, Date fechaF, int idPrioridad, int idEstado, int idEmpleado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaI = fechaI;
        this.fechaT = fechaT;
        this.fechaF = fechaF;
        this.idPrioridad = idPrioridad;
        this.idEstado = idEstado;
        this.idEmpleado = idEmpleado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaI() {
        return fechaI;
    }

    public void setFechaI(String fechaI) {
        this.fechaI = fechaI;
    }

    public String getFechaT() {
        return fechaT;
    }

    public void setFechaT(String fechaT) {
        this.fechaT = fechaT;
    }

    public Date getFechaF() {
        return fechaF;
    }

    public void setFechaF(Date fechaF) {
        this.fechaF = fechaF;
    }

    public int getIdPrioridad() {
        return idPrioridad;
    }

    public void setIdPrioridad(int idPrioridad) {
        this.idPrioridad = idPrioridad;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreEmpleado() {
        return this.nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getNombrePrioridad() {
        return nombrePrioridad;
    }

    public void setNombrePrioridad(String nombrePrioridad) {
        this.nombrePrioridad = nombrePrioridad;
    }

    @Override
    public String toString() {
        return "Tarea{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fechaI=" + fechaI + ", fechaT=" + fechaT + ", fechaF=" + fechaF + ", idPrioridad=" + idPrioridad + ", idEstado=" + idEstado + ", idEmpleado=" + idEmpleado + '}';
    }

}
