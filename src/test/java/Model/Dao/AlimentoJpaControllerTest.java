/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import Model.Alimento;
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
public class AlimentoJpaControllerTest {
    
    public AlimentoJpaControllerTest() {
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
     * Test of getEntityManager method, of class AlimentoJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        AlimentoJpaController instance = null;
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class AlimentoJpaController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Alimento alimento = null;
        AlimentoJpaController instance = null;
        instance.create(alimento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class AlimentoJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Alimento alimento = null;
        AlimentoJpaController instance = null;
        instance.edit(alimento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class AlimentoJpaController.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        Integer id = null;
        AlimentoJpaController instance = null;
        instance.destroy(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAlimentoEntities method, of class AlimentoJpaController.
     */
    @Test
    public void testFindAlimentoEntities_0args() {
        System.out.println("findAlimentoEntities");
        AlimentoJpaController instance = null;
        List<Alimento> expResult = null;
        List<Alimento> result = instance.findAlimentoEntities();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAlimentoEntities method, of class AlimentoJpaController.
     */
    @Test
    public void testFindAlimentoEntities_int_int() {
        System.out.println("findAlimentoEntities");
        int maxResults = 0;
        int firstResult = 0;
        AlimentoJpaController instance = null;
        List<Alimento> expResult = null;
        List<Alimento> result = instance.findAlimentoEntities(maxResults, firstResult);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAlimento method, of class AlimentoJpaController.
     */
    @Test
    public void testFindAlimento() {
        System.out.println("findAlimento");
        Integer id = null;
        AlimentoJpaController instance = null;
        Alimento expResult = null;
        Alimento result = instance.findAlimento(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAlimentoCount method, of class AlimentoJpaController.
     */
    @Test
    public void testGetAlimentoCount() {
        System.out.println("getAlimentoCount");
        AlimentoJpaController instance = null;
        int expResult = 0;
        int result = instance.getAlimentoCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}