/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eui.miw.pfm;

import eui.miw.pfm.controllers.beans.TestConfProjectBean;
import eui.miw.pfm.controllers.beans.TestCreateProjectValidatorBean;
import eui.miw.pfm.controllers.ejb.TestCreateProjectEjb;
import eui.miw.pfm.models.entities.ProjectTest;
import eui.miw.pfm.models.entities.UserEntityTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author bk0823
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({TestConfProjectBean.class, TestCreateProjectValidatorBean.class, TestCreateProjectEjb.class, ProjectTest.class, UserEntityTest.class})
public class AllTest {

}
