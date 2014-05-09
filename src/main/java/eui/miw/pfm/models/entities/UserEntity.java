/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eui.miw.pfm.models.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author Roberto Amor
 */
@Entity
@Table(name = "users")
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id; // NOPMD

    @Column(name = "username", length = 30)
    @NotNull
    @Size(min = 4, max = 30)
    private String username;

    @Column(name = "password", length = 30)
    @NotNull
    @Size(min = 8, max = 30)
    private String password;

    @Column(name = "name", length = 30)
    @NotNull
    @Size(min = 1, max = 30)
    private String name;

    @Column(name = "surname", length = 30)
    @NotNull
    @Size(min = 1, max = 30)
    private String surname;

    @Column(name = "second_surname", length = 30)
    @Size(min = 0, max = 30)
    private String secondSurname;

    @Column(name = "email", length = 50)
    @NotNull
    @Size(min = 6, max = 50)
    @Pattern(regexp = "^.+@.+\\..+$")
    private String email;

    public UserEntity() { //NOPMD
        super();
    }

    public UserEntity(final Integer id) { //NOPMD
        this.id = id;
    }

    public UserEntity(final Integer id, final String username, final String password, final String name, final String surname, final String secondSurname, final String email) { //NOPMD
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.secondSurname = secondSurname;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer identifier) {
        this.id = identifier;
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

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(final String secondSurname) {
        this.secondSurname = secondSurname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);//NOPMD
        return hash;
    }

    @Override
    public boolean equals(final Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserEntity)) {
            return false;//NOPMD
        }
        final UserEntity other = (UserEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;//NOPMD
        }
        return true;
    }

    @Override
    public String toString() {
        return "eui.miw.pfm.models.entities.UserEntity[ id=" + id + " ]";
    }

}
