package dominio;

/**
 *
 * Esta clase tiene como objetivo crear objetos del tipo empleado, ya que
 * podemos obtener informacion de un empleado o simplemente se puede crear un
 * nuevo empleado con las reglas que se definen en esta clase
 *
 * @author Personal
 */
public class Empleado {

    private int id;
    private String nombre;
    private String correo;
    private String password;
    private int idArea;
    private int idDepartamento;
    private int idTipoUsuario;

    public Empleado() {
    }

    public Empleado(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    public Empleado(String correo, String password, int idTipoUsuario) {
        this.correo = correo;
        this.password = password;
        this.idTipoUsuario = idTipoUsuario;
    }

    public Empleado(int id, String nombre, String correo, String password, int idArea, int idDepartamento, int idTipoUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.idArea = idArea;
        this.idDepartamento = idDepartamento;
        this.idTipoUsuario = idTipoUsuario;
    }

    public Empleado(String nombre, String correo, String password, int idArea, int idDepartamento, int idTipoUsuario) {
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.idArea = idArea;
        this.idDepartamento = idDepartamento;
        this.idTipoUsuario = idTipoUsuario;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", password=" + password + ", idArea=" + idArea + ", idDepartamento=" + idDepartamento + ", idTipoUsuario=" + idTipoUsuario + '}';
    }

}
