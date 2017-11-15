/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
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
public class HorrarioRefeicaoTest {
    
    public HorrarioRefeicaoTest() {
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
     * Test of getIdhorrarioRefeicao method, of class HorrarioRefeicao.
     */
    @Test
    public void testGetIdhorrarioRefeicao() {
        System.out.println("getIdhorrarioRefeicao");
        HorrarioRefeicao instance = new HorrarioRefeicao();
        Integer expResult = null;
        Integer result = instance.getIdhorrarioRefeicao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdhorrarioRefeicao method, of class HorrarioRefeicao.
     */
    @Test
    public void testSetIdhorrarioRefeicao() {
        System.out.println("setIdhorrarioRefeicao");
        Integer idhorrarioRefeicao = null;
        HorrarioRefeicao instance = new HorrarioRefeicao();
        instance.setIdhorrarioRefeicao(idhorrarioRefeicao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescricao method, of class HorrarioRefeicao.
     */
    @Test
    public void testGetDescricao() {
        System.out.println("getDescricao");
        HorrarioRefeicao instance = new HorrarioRefeicao();
        String expResult = "";
        String result = instance.getDescricao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescricao method, of class HorrarioRefeicao.
     */
    @Test
    public void testSetDescricao() {
        System.out.println("setDescricao");
        String descricao = "";
        HorrarioRefeicao instance = new HorrarioRefeicao();
        instance.setDescricao(descricao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConsumoDiarioList method, of class HorrarioRefeicao.
     */
    @Test
    public void testGetConsumoDiarioList() {
        System.out.println("getConsumoDiarioList");
        HorrarioRefeicao instance = new HorrarioRefeicao();
        List<ConsumoDiario> expResult = null;
        List<ConsumoDiario> result = instance.getConsumoDiarioList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setConsumoDiarioList method, of class HorrarioRefeicao.
     */
    @Test
    public void testSetConsumoDiarioList() {
        System.out.println("setConsumoDiarioList");
        List<ConsumoDiario> consumoDiarioList = null;
        HorrarioRefeicao instance = new HorrarioRefeicao();
        instance.setConsumoDiarioList(consumoDiarioList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class HorrarioRefeicao.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        HorrarioRefeicao instance = new HorrarioRefeicao();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class HorrarioRefeicao.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        HorrarioRefeicao instance = new HorrarioRefeicao();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class HorrarioRefeicao.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        HorrarioRefeicao instance = new HorrarioRefeicao();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
