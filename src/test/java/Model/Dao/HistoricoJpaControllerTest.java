/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import Model.Historico;
import Model.HistoricoPK;
import java.util.List;
import javax.persistence.EntityManager;
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
public class HistoricoJpaControllerTest {
    
    public HistoricoJpaControllerTest() {
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

    /**
     * Test of getEntityManager method, of class HistoricoJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        HistoricoJpaController instance = null;
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class HistoricoJpaController.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Historico historico = null;
        HistoricoJpaController instance = null;
        instance.create(historico);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class HistoricoJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Historico historico = null;
        HistoricoJpaController instance = null;
        instance.edit(historico);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class HistoricoJpaController.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        HistoricoPK id = null;
        HistoricoJpaController instance = null;
        instance.destroy(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findHistoricoEntities method, of class HistoricoJpaController.
     */
    @Test
    public void testFindHistoricoEntities_0args() {
        System.out.println("findHistoricoEntities");
        HistoricoJpaController instance = null;
        List<Historico> expResult = null;
        List<Historico> result = instance.findHistoricoEntities();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findHistoricoEntities method, of class HistoricoJpaController.
     */
    @Test
    public void testFindHistoricoEntities_int_int() {
        System.out.println("findHistoricoEntities");
        int maxResults = 0;
        int firstResult = 0;
        HistoricoJpaController instance = null;
        List<Historico> expResult = null;
        List<Historico> result = instance.findHistoricoEntities(maxResults, firstResult);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findHistorico method, of class HistoricoJpaController.
     */
    @Test
    public void testFindHistorico() {
        System.out.println("findHistorico");
        HistoricoPK id = null;
        HistoricoJpaController instance = null;
        Historico expResult = null;
        Historico result = instance.findHistorico(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHistoricoCount method, of class HistoricoJpaController.
     */
    @Test
    public void testGetHistoricoCount() {
        System.out.println("getHistoricoCount");
        HistoricoJpaController instance = null;
        int expResult = 0;
        int result = instance.getHistoricoCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
