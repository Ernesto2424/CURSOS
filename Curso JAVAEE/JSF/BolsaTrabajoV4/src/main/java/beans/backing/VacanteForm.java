package beans.backing;

import beans.model.Candidato;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Named
@RequestScoped

public class VacanteForm {

    @Inject
    private Candidato candidato;
    private boolean comentarioEnviado;
    Logger log = LogManager.getRootLogger();

    public VacanteForm() {
        log.info("Creando el objeto vacante");
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public boolean isComentarioEnviado() {
        return comentarioEnviado;
    }

    public void setComentarioEnviado(boolean comentarioEnviado) {
        this.comentarioEnviado = comentarioEnviado;
    }

    public String enviar() {
        if (this.candidato.getNombre().equalsIgnoreCase("ernesto")) {
            if (candidato.getApellido().equalsIgnoreCase("flores")) {
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

    public void codigoPostalListener(ValueChangeEvent valueChangeEvent) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        UIViewRoot uiViewRoot = facesContext.getViewRoot();
        String nuevoCP = (String) valueChangeEvent.getNewValue();
        if ("55760".equals(nuevoCP)) {
            UIInput coloniaInput = (UIInput) uiViewRoot.findComponent("vacanteForm:colonia");
            String nuevacolonia = "Napoles";
            coloniaInput.setValue(nuevacolonia);
            coloniaInput.setSubmittedValue(nuevacolonia);

            UIInput ciudadInput = (UIInput) uiViewRoot.findComponent("vacanteForm:ciudad");
            String nuevaciudad = "CDMX";
            ciudadInput.setValue(nuevaciudad);
            ciudadInput.setSubmittedValue(nuevaciudad);
            facesContext.renderResponse();
        }
    }

    public void ocultarComentario(ActionEvent actionEvent) {

        this.comentarioEnviado = !this.comentarioEnviado;

    }

    
}
