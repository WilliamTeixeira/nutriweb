/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import Model.ConsumoDiarioAlimento;
import Model.ConsumoDiarioAlimentoPK;
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
public class ConsumoDiarioAlimentoJpaControllerTest {
    
    public ConsumoDiarioAlimentoJpaControllerTest() {
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
     * Test of getEntityManager method, of class ConsumoDiarioAlimentoJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        ConsumoDiarioAlimentoJpaController instance = null;
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class ConsumoDiarioAlimentoJpaController.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        ConsumoDiarioAlimento consumoDiarioAlimento = null;
        ConsumoDiarioAlimentoJpaController instance = null;
        instance.create(consumoDiarioAlimento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class ConsumoDiarioAlimentoJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        ConsumoDiarioAlimento consumoDiarioAlimento = null;
        ConsumoDiarioAlimentoJpaController instance = null;
        instance.edit(consumoDiarioAlimento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class ConsumoDiarioAlimentoJpaController.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        ConsumoDiarioAlimentoPK id = null;
        ConsumoDiarioAlimentoJpaController instance = null;
        instance.destroy(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findConsumoDiarioAlimentoEntities method, of class ConsumoDiarioAlimentoJpaController.
     */
    @Test
    public void testFindConsumoDiarioAlimentoEntities_0args() {
        System.out.println("findConsumoDiarioAlimentoEntities");
        ConsumoDiarioAlimentoJpaController instance = null;
        List<ConsumoDiarioAlimento> expResult = null;
        List<ConsumoDiarioAlimento> result = instance.findConsumoDiarioAlimentoEntities();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findConsumoDiarioAlimentoEntities method, of class ConsumoDiarioAlimentoJpaController.
     */
    @Test
    public void testFindConsumoDiarioAlimentoEntities_int_int() {
        System.out.println("findConsumoDiarioAlimentoEntities");
        int maxResults = 0;
        int firstResult = 0;
        ConsumoDiarioAlimentoJpaController instance = null;
        List<ConsumoDiarioAlimento> expResult = null;
        List<ConsumoDiarioAlimento> result = instance.findConsumoDiarioAlimentoEntities(maxResults, firstResult);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findConsumoDiarioAlimento method, of class ConsumoDiarioAlimentoJpaController.
     */
    @Test
    public void testFindConsumoDiarioAlimento() {
        System.out.println("findConsumoDiarioAlimento");
        ConsumoDiarioAlimentoPK id = null;
        ConsumoDiarioAlimentoJpaController instance = null;
        ConsumoDiarioAlimento expResult = null;
        ConsumoDiarioAlimento result = instance.findConsumoDiarioAlimento(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConsumoDiarioAlimentoCount method, of class ConsumoDiarioAlimentoJpaController.
     */
    @Test
    public void testGetConsumoDiarioAlimentoCount() {
        System.out.println("getConsumoDiarioAlimentoCount");
        ConsumoDiarioAlimentoJpaController instance = null;
        int expResult = 0;
        int result = instance.getConsumoDiarioAlimentoCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
