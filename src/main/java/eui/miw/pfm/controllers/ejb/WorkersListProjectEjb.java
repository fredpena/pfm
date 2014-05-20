/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eui.miw.pfm.controllers.ejb;

import eui.miw.pfm.models.dao.AbstractDAOFactory;
import eui.miw.pfm.models.entities.ProjectEntity;
import eui.miw.pfm.models.entities.WorkerEntity;
import java.util.List;

/**
 *
 * @author Roberto Amor
 * @author Jose M Villar
 */
public class WorkersListProjectEjb {
    public List<WorkerEntity> obtainWorkers(final ProjectEntity project) {       
        return project.getWorkers();
        //return new ArrayList<WorkerEntity>();
    }       

    public void remove(final ProjectEntity project, final WorkerEntity worker) {
        project.removeWorker(worker);
        //worker.removeProject(project);
        AbstractDAOFactory.getFactory().getProjectDAO().update(project);        
        AbstractDAOFactory.getFactory().getWorkerDAO().update(worker);
    }

    public void add(final ProjectEntity project, final WorkerEntity worker) {
        project.addWorker(worker);
        //worker.addProject(project);
        AbstractDAOFactory.getFactory().getProjectDAO().update(project);
        AbstractDAOFactory.getFactory().getWorkerDAO().update(worker);        
    }
}