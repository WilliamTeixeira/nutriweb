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
public class AlimentoTest {
    
    public AlimentoTest() {
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
     * Test of getIdalimento method, of class Alimento.
     */
    @Test
    public void testGetIdalimento() {
        System.out.println("getIdalimento");
        Alimento instance = new Alimento();
        Integer expResult = null;
        Integer result = instance.getIdalimento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdalimento method, of class Alimento.
     */
    @Test
    public void testSetIdalimento() {
        System.out.println("setIdalimento");
        Integer idalimento = null;
        Alimento instance = new Alimento();
        instance.setIdalimento(idalimento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescricao method, of class Alimento.
     */
    @Test
    public void testGetDescricao() {
        System.out.println("getDescricao");
        Alimento instance = new Alimento();
        String expResult = "";
        String result = instance.getDescricao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescricao method, of class Alimento.
     */
    @Test
    public void testSetDescricao() {
        System.out.println("setDescricao");
        String descricao = "";
        Alimento instance = new Alimento();
        instance.setDescricao(descricao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCal method, of class Alimento.
     */
    @Test
    public void testGetCal() {
        System.out.println("getCal");
        Alimento instance = new Alimento();
        int expResult = 0;
        int result = instance.getCal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCal method, of class Alimento.
     */
    @Test
    public void testSetCal() {
        System.out.println("setCal");
        int cal = 0;
        Alimento instance = new Alimento();
        instance.setCal(cal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUnidade method, of class Alimento.
     */
    @Test
    public void testGetUnidade() {
        System.out.println("getUnidade");
        Alimento instance = new Alimento();
        String expResult = "";
        String result = instance.getUnidade();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUnidade method, of class Alimento.
     */
    @Test
    public void testSetUnidade() {
        System.out.println("setUnidade");
        String unidade = "";
        Alimento instance = new Alimento();
        instance.setUnidade(unidade);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConsumoDiarioAlimentoList method, of class Alimento.
     */
    @Test
    public void testGetConsumoDiarioAlimentoList() {
        System.out.println("getConsumoDiarioAlimentoList");
        Alimento instance = new Alimento();
        List<ConsumoDiarioAlimento> expResult = null;
        List<ConsumoDiarioAlimento> result = instance.getConsumoDiarioAlimentoList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setConsumoDiarioAlimentoList method, of class Alimento.
     */
    @Test
    public void testSetConsumoDiarioAlimentoList() {
        System.out.println("setConsumoDiarioAlimentoList");
        List<ConsumoDiarioAlimento> consumoDiarioAlimentoList = null;
        Alimento instance = new Alimento();
        instance.setConsumoDiarioAlimentoList(consumoDiarioAlimentoList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Alimento.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Alimento instance = new Alimento();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Alimento.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Alimento instance = new Alimento();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Alimento.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Alimento instance = new Alimento();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
