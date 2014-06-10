/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eui.miw.pfm.controllers.beans;

import eui.miw.pfm.controllers.ejb.WorkUnitEjb;
import eui.miw.pfm.controllers.ejb.WorkerEjb;
import eui.miw.pfm.models.dao.AbstractDAOFactory;
import eui.miw.pfm.models.entities.ProjectEntity;
import eui.miw.pfm.models.entities.WorkUnitEntity;
import eui.miw.pfm.models.entities.WorkerEntity;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Fred Peña
 * @author Clemencio Morales
 * @author Pepe Bustamante
 */
@RequestScoped
@Named
public class WorkerProfileBean extends Bean implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(WorkerProfileBean.class.getName());//NOPMD

    private transient ProjectEntity project;
    private transient WorkerEntity worker;

    @ManagedProperty(value = "#{workUnitBean}")
    private final transient WorkUnitBean workUnitBean = new WorkUnitBean();

    public WorkerProfileBean() {
        super();
        try {
            this.project = ((ProjectEntity) sessionMap.get("project"));
            this.worker = ((WorkerEntity) sessionMap.get("worker"));
        } catch (Exception e) {
            LOGGER.info("No session exist");
        }
        this.workUnitBean.setWorker(worker);
    }

    public WorkUnitBean getWorkUnitBean() {
        return workUnitBean;
    }

    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }

    public WorkerEntity getWorker() {
        return worker;
    }

    public void setWorker(WorkerEntity worker) {
        this.worker = worker;
    }

    public List<WorkUnitEntity> getAllWorkUnit() {
        return new WorkUnitEjb().getWorkerWorkUnits(worker);
    }
}
