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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Roberto Amor
 */
@Entity
@Table(name="usercases")
public class UserCaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name", length = 140)
    @NotNull
    @Size(min = 3, max = 140)
    private String name;
    
    @Column(name = "description", length = 255)
    @NotNull
    @Size(min = 1, max = 255)
    private String description;
    
    @ManyToOne
    @JoinColumn(name="project_id", referencedColumnName="id", nullable = false)
    private ProjectEntity project;

    public UserCaseEntity() {
        super();
    }

    public UserCaseEntity(Long id) {
        this.id = id;
    }

    public UserCaseEntity(final Long id, final String name, final String description, final ProjectEntity project) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.project = project;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserCaseEntity)) {
            return false;
        }
        UserCaseEntity other = (UserCaseEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UserCaseEntity{" + "id=" + id + ", name=" + name + ", description=" + description + ", project=" + project + '}';
    }

    
}
