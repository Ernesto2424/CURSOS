package dominio;

/**
 *
 * Esta clase se ha utilizado para la creacion de diferentes objetos, ya sea
 * como departamentos, areas, estado, prioridad y tipo de usuario, ya que todas
 * estas tablas de la base de datos tienen una estructura general, y es por esto
 * que se ha creado esta clase con nombre plantillaGeneral
 *
 * @author Personal
 */
public class PlantillaGeneral {

    private int id;
    private String nombre;

    public PlantillaGeneral() {
    }

    public PlantillaGeneral(int id) {
        this.id = id;
    }

    public PlantillaGeneral(String nombre) {
        this.nombre = nombre;
    }

    public PlantillaGeneral(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    @Override
    public String toString() {
        return "PlantillaGeneral{" + "id=" + id + ", nombre=" + nombre + '}';
    }

}
