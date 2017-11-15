/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import Model.HorrarioRefeicao;
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
public class HorrarioRefeicaoJpaControllerTest {
    
    public HorrarioRefeicaoJpaControllerTest() {
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
     * Test of getEntityManager method, of class HorrarioRefeicaoJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        HorrarioRefeicaoJpaController instance = null;
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class HorrarioRefeicaoJpaController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        HorrarioRefeicao horrarioRefeicao = null;
        HorrarioRefeicaoJpaController instance = null;
        instance.create(horrarioRefeicao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class HorrarioRefeicaoJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        HorrarioRefeicao horrarioRefeicao = null;
        HorrarioRefeicaoJpaController instance = null;
        instance.edit(horrarioRefeicao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class HorrarioRefeicaoJpaController.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        Integer id = null;
        HorrarioRefeicaoJpaController instance = null;
        instance.destroy(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findHorrarioRefeicaoEntities method, of class HorrarioRefeicaoJpaController.
     */
    @Test
    public void testFindHorrarioRefeicaoEntities_0args() {
        System.out.println("findHorrarioRefeicaoEntities");
        HorrarioRefeicaoJpaController instance = null;
        List<HorrarioRefeicao> expResult = null;
        List<HorrarioRefeicao> result = instance.findHorrarioRefeicaoEntities();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findHorrarioRefeicaoEntities method, of class HorrarioRefeicaoJpaController.
     */
    @Test
    public void testFindHorrarioRefeicaoEntities_int_int() {
        System.out.println("findHorrarioRefeicaoEntities");
        int maxResults = 0;
        int firstResult = 0;
        HorrarioRefeicaoJpaController instance = null;
        List<HorrarioRefeicao> expResult = null;
        List<HorrarioRefeicao> result = instance.findHorrarioRefeicaoEntities(maxResults, firstResult);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findHorrarioRefeicao method, of class HorrarioRefeicaoJpaController.
     */
    @Test
    public void testFindHorrarioRefeicao() {
        System.out.println("findHorrarioRefeicao");
        Integer id = null;
        HorrarioRefeicaoJpaController instance = null;
        HorrarioRefeicao expResult = null;
        HorrarioRefeicao result = instance.findHorrarioRefeicao(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHorrarioRefeicaoCount method, of class HorrarioRefeicaoJpaController.
     */
    @Test
    public void testGetHorrarioRefeicaoCount() {
        System.out.println("getHorrarioRefeicaoCount");
        HorrarioRefeicaoJpaController instance = null;
        int expResult = 0;
        int result = instance.getHorrarioRefeicaoCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
