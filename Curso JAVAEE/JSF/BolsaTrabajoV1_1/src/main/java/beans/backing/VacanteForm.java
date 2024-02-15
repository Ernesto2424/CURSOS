package beans.backing;

import beans.model.Candidato;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Named
@RequestScoped

public class VacanteForm {

    @Inject
    private Candidato candidato;
    Logger log = LogManager.getRootLogger();
    
    public VacanteForm(){
        log.info("Creando el objeto vacante");
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public String enviar() {
        if (this.candidato.getNombre().equalsIgnoreCase("ernesto")) {
            if(candidato.getApellido().equalsIgnoreCase("flores")){
                String msj = "Gracias, pero Ernesto Flores ya esta contratado";
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, msj, msj);
                FacesContext fc = FacesContext.getCurrentInstance();
                String ComponentId = null; //este es un msj global
                fc.addMessage(ComponentId, fm);
                return "index";
            }
            log.info("Entrando al caso de exito");
            return "exito";
        } else {
            log.info("Entrando al caso de fallo");

            return "fallo";
        }
    }

}
