/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import Model.User;
import java.util.List;
import javax.persistence.EntityManager;
import org.dbunit.DBTestCase;
import org.dbunit.dataset.IDataSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author william
 */
public class UserJpaControllerIT extends DBTestCase{
    
    public UserJpaControllerIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
       
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

//    
//    /**
//     * Test of getEntityManager method, of class UserJpaController.
//     */
//    @Test
//    public void testGetEntityManager() {
//        System.out.println("getEntityManager");
//        UserJpaController instance = null;
//        EntityManager expResult = null;
//        EntityManager result = instance.getEntityManager();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of create method, of class UserJpaController.
//     */
//    @Test
//    public void testCreate() {
//        System.out.println("create");
//        User user = null;
//        UserJpaController instance = null;
//        instance.create(user);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of edit method, of class UserJpaController.
//     */
//    @Test
//    public void testEdit() throws Exception {
//        System.out.println("edit");
//        User user = null;
//        UserJpaController instance = null;
//        instance.edit(user);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of destroy method, of class UserJpaController.
//     */
//    @Test
//    public void testDestroy() throws Exception {
//        System.out.println("destroy");
//        Integer id = null;
//        UserJpaController instance = null;
//        instance.destroy(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findUserEntities method, of class UserJpaController.
//     */
//    @Test
//    public void testFindUserEntities_0args() {
//        System.out.println("findUserEntities");
//        UserJpaController instance = null;
//        List<User> expResult = null;
//        List<User> result = instance.findUserEntities();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findUserEntities method, of class UserJpaController.
//     */
//    @Test
//    public void testFindUserEntities_int_int() {
//        System.out.println("findUserEntities");
//        int maxResults = 0;
//        int firstResult = 0;
//        UserJpaController instance = null;
//        List<User> expResult = null;
//        List<User> result = instance.findUserEntities(maxResults, firstResult);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findUser method, of class UserJpaController.
//     */
//    @Test
//    public void testFindUser() {
//        System.out.println("findUser");
//        Integer id = null;
//        UserJpaController instance = null;
//        User expResult = null;
//        User result = instance.findUser(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getUserCount method, of class UserJpaController.
//     */
//    @Test
//    public void testGetUserCount() {
//        System.out.println("getUserCount");
//        UserJpaController instance = null;
//        int expResult = 0;
//        int result = instance.getUserCount();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getUserByLoginAndSenha method, of class UserJpaController.
//     */
//    @Test
//    public void testGetUserByLoginAndSenha() {
//        System.out.println("getUserByLoginAndSenha");
//        String login = "";
//        String senha = "";
//        UserJpaController instance = null;
//        User expResult = null;
//        User result = instance.getUserByLoginAndSenha(login, senha);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    

    @Override
    protected IDataSet getDataSet() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }
}
