/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eui.miw.pfm.models.dao.jpa;

import eui.miw.pfm.models.dao.interfaces.UseCaseDAO;
import eui.miw.pfm.models.entities.UseCaseEntity;

/**
 *
 * @author Manuel Rodríguez Momediano
 * @author Clemencio Morales Lucas
 */
public class JPAUseCaseDAO extends JPATransactionGenericDAO<UseCaseEntity, Integer> implements UseCaseDAO{
    
    public JPAUseCaseDAO(){
        super(UseCaseEntity.class);
    }
}
