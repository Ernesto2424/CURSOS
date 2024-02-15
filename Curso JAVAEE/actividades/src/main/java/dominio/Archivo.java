package dominio;

import java.io.InputStream;

/**
 * Esta clase pretende crear objetos del tipo archivo con metodos constructores
 * con diferentes parametros para que se adecuen a un uso diferente
 *
 * @author Personal
 */
public class Archivo {

    private int ind;
    private String documento;
    private int idActividad;

    public Archivo(int ind, String documento, int idActividad) {
        this.ind = ind;
        this.documento = documento;
        this.idActividad = idActividad;
    }

    public Archivo(String documento, int idActividad) {
        this.documento = documento;
        this.idActividad = idActividad;
    }

    public int getInd() {
        return ind;
    }

    public void setInd(int ind) {
        this.ind = ind;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    @Override
    public String toString() {
        return "Archivo{" + "ind=" + ind + ", documento=" + documento + ", idActividad=" + idActividad + '}';
    }

}
