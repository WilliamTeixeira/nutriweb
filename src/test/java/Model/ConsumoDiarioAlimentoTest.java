/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
public class ConsumoDiarioAlimentoTest {
    
    public ConsumoDiarioAlimentoTest() {
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
     * Test of getConsumoDiarioAlimentoPK method, of class ConsumoDiarioAlimento.
     */
    @Test
    public void testGetConsumoDiarioAlimentoPK() {
        System.out.println("getConsumoDiarioAlimentoPK");
        ConsumoDiarioAlimento instance = new ConsumoDiarioAlimento();
        ConsumoDiarioAlimentoPK expResult = null;
        ConsumoDiarioAlimentoPK result = instance.getConsumoDiarioAlimentoPK();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setConsumoDiarioAlimentoPK method, of class ConsumoDiarioAlimento.
     */
    @Test
    public void testSetConsumoDiarioAlimentoPK() {
        System.out.println("setConsumoDiarioAlimentoPK");
        ConsumoDiarioAlimentoPK consumoDiarioAlimentoPK = null;
        ConsumoDiarioAlimento instance = new ConsumoDiarioAlimento();
        instance.setConsumoDiarioAlimentoPK(consumoDiarioAlimentoPK);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQtde method, of class ConsumoDiarioAlimento.
     */
    @Test
    public void testGetQtde() {
        System.out.println("getQtde");
        ConsumoDiarioAlimento instance = new ConsumoDiarioAlimento();
        double expResult = 0.0;
        double result = instance.getQtde();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setQtde method, of class ConsumoDiarioAlimento.
     */
    @Test
    public void testSetQtde() {
        System.out.println("setQtde");
        double qtde = 0.0;
        ConsumoDiarioAlimento instance = new ConsumoDiarioAlimento();
        instance.setQtde(qtde);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConsumoDiario method, of class ConsumoDiarioAlimento.
     */
    @Test
    public void testGetConsumoDiario() {
        System.out.println("getConsumoDiario");
        ConsumoDiarioAlimento instance = new ConsumoDiarioAlimento();
        ConsumoDiario expResult = null;
        ConsumoDiario result = instance.getConsumoDiario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setConsumoDiario method, of class ConsumoDiarioAlimento.
     */
    @Test
    public void testSetConsumoDiario() {
        System.out.println("setConsumoDiario");
        ConsumoDiario consumoDiario = null;
        ConsumoDiarioAlimento instance = new ConsumoDiarioAlimento();
        instance.setConsumoDiario(consumoDiario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAlimento method, of class ConsumoDiarioAlimento.
     */
    @Test
    public void testGetAlimento() {
        System.out.println("getAlimento");
        ConsumoDiarioAlimento instance = new ConsumoDiarioAlimento();
        Alimento expResult = null;
        Alimento result = instance.getAlimento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAlimento method, of class ConsumoDiarioAlimento.
     */
    @Test
    public void testSetAlimento() {
        System.out.println("setAlimento");
        Alimento alimento = null;
        ConsumoDiarioAlimento instance = new ConsumoDiarioAlimento();
        instance.setAlimento(alimento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class ConsumoDiarioAlimento.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        ConsumoDiarioAlimento instance = new ConsumoDiarioAlimento();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class ConsumoDiarioAlimento.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        ConsumoDiarioAlimento instance = new ConsumoDiarioAlimento();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class ConsumoDiarioAlimento.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ConsumoDiarioAlimento instance = new ConsumoDiarioAlimento();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
