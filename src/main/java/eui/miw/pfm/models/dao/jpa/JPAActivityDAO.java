/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eui.miw.pfm.models.dao.jpa;

import eui.miw.pfm.models.entities.ActivityEntity;
import eui.miw.pfm.models.dao.interfaces.ActivityDAO;
/**
 *
 * @author Jose Mª Villar
 * @author Jean Mubaied
 */
public class JPAActivityDAO extends JPATransactionGenericDAO<ActivityEntity, Integer> implements ActivityDAO {
      public JPAActivityDAO(){
       super(ActivityEntity.class);
    } 

         
}
