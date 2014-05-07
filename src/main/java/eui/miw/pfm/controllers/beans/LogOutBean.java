/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eui.miw.pfm.controllers.beans;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Fred Peña
 */
@RequestScoped
@Named
public class LogOutBean extends Bean implements Serializable {

    private static final long serialVersionUID = 1L;

    public LogOutBean() {
        super();
    }

    public void logOut() {
        sessionMap.clean();
    }
}
