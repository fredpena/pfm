/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eui.miw.pfm.controllers.beans;

import eui.miw.pfm.controllers.ejb.LoginEjb;
import eui.miw.pfm.models.entities.UserEntity;
import eui.miw.pfm.util.SessionMap;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Fred Peña
 */
@RequestScoped
@Named
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private transient boolean loggedIn = false;
    private transient final SessionMap sessionMap;

    public LoginBean() {
        super();
        this.sessionMap = new SessionMap();

        if (isLogin()) {
            redirectionHome();
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    private boolean isLogin() {
        return this.sessionMap.get("userlogin") != null;
    }

    private void redirectionHome() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("list_project.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(SessionMap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void login(final ActionEvent actionEvent) {
        final RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message;
        UserEntity userEntity;

        if (this.getUsername() != null && this.getPassword() != null) { //NOPMD
            final LoginEjb loginEjb = new LoginEjb();
            userEntity = loginEjb.findUser(getUsername(), getPassword());

            if (userEntity != null) { //NOPMD
                loggedIn = true;
                this.sessionMap.put("userlogin", userEntity);
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
            } else {
                loggedIn = false;
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error",
                        "Invalid credentials");
            }
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error",
                    "Invalid credentials");
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);

        if (loggedIn) {
            context.addCallbackParam("view", "list_project.xhtml");
        }
    }
}
