/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import Model.ConsumoDiario;
import Model.ConsumoDiarioPK;
import java.util.Date;
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
public class ConsumoDiarioJpaControllerTest {
    
    public ConsumoDiarioJpaControllerTest() {
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
     * Test of getEntityManager method, of class ConsumoDiarioJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        ConsumoDiarioJpaController instance = null;
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class ConsumoDiarioJpaController.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        ConsumoDiario consumoDiario = null;
        ConsumoDiarioJpaController instance = null;
        instance.create(consumoDiario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class ConsumoDiarioJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        ConsumoDiario consumoDiario = null;
        ConsumoDiarioJpaController instance = null;
        instance.edit(consumoDiario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class ConsumoDiarioJpaController.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        ConsumoDiarioPK id = null;
        ConsumoDiarioJpaController instance = null;
        instance.destroy(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findConsumoDiarioEntities method, of class ConsumoDiarioJpaController.
     */
    @Test
    public void testFindConsumoDiarioEntities_0args() {
        System.out.println("findConsumoDiarioEntities");
        ConsumoDiarioJpaController instance = null;
        List<ConsumoDiario> expResult = null;
        List<ConsumoDiario> result = instance.findConsumoDiarioEntities();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findConsumoDiarioEntities method, of class ConsumoDiarioJpaController.
     */
    @Test
    public void testFindConsumoDiarioEntities_int_int() {
        System.out.println("findConsumoDiarioEntities");
        int maxResults = 0;
        int firstResult = 0;
        ConsumoDiarioJpaController instance = null;
        List<ConsumoDiario> expResult = null;
        List<ConsumoDiario> result = instance.findConsumoDiarioEntities(maxResults, firstResult);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findConsumoDiario method, of class ConsumoDiarioJpaController.
     */
    @Test
    public void testFindConsumoDiario() {
        System.out.println("findConsumoDiario");
        ConsumoDiarioPK id = null;
        ConsumoDiarioJpaController instance = null;
        ConsumoDiario expResult = null;
        ConsumoDiario result = instance.findConsumoDiario(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConsumoDiarioCount method, of class ConsumoDiarioJpaController.
     */
    @Test
    public void testGetConsumoDiarioCount() {
        System.out.println("getConsumoDiarioCount");
        ConsumoDiarioJpaController instance = null;
        int expResult = 0;
        int result = instance.getConsumoDiarioCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findConsumoDiarioAlimentoByUser method, of class ConsumoDiarioJpaController.
     */
    @Test
    public void testFindConsumoDiarioAlimentoByUser() {
        System.out.println("findConsumoDiarioAlimentoByUser");
        Integer iduser = null;
        ConsumoDiarioJpaController instance = null;
        List<ConsumoDiario> expResult = null;
        List<ConsumoDiario> result = instance.findConsumoDiarioAlimentoByUser(iduser);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findDatasByUser method, of class ConsumoDiarioJpaController.
     */
    @Test
    public void testFindDatasByUser() {
        System.out.println("findDatasByUser");
        Integer iduser = null;
        ConsumoDiarioJpaController instance = null;
        List<Date> expResult = null;
        List<Date> result = instance.findDatasByUser(iduser);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findConsumoDiarioAlimentoByUserbyData method, of class ConsumoDiarioJpaController.
     */
    @Test
    public void testFindConsumoDiarioAlimentoByUserbyData() {
        System.out.println("findConsumoDiarioAlimentoByUserbyData");
        Integer iduser = null;
        Date data = null;
        ConsumoDiarioJpaController instance = null;
        List<ConsumoDiario> expResult = null;
        List<ConsumoDiario> result = instance.findConsumoDiarioAlimentoByUserbyData(iduser, data);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
