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
public class ConsumoDiarioTest {
    
    public ConsumoDiarioTest() {
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
     * Test of getConsumoDiarioPK method, of class ConsumoDiario.
     */
    @Test
    public void testGetConsumoDiarioPK() {
        System.out.println("getConsumoDiarioPK");
        ConsumoDiario instance = new ConsumoDiario();
        ConsumoDiarioPK expResult = null;
        ConsumoDiarioPK result = instance.getConsumoDiarioPK();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setConsumoDiarioPK method, of class ConsumoDiario.
     */
    @Test
    public void testSetConsumoDiarioPK() {
        System.out.println("setConsumoDiarioPK");
        ConsumoDiarioPK consumoDiarioPK = null;
        ConsumoDiario instance = new ConsumoDiario();
        instance.setConsumoDiarioPK(consumoDiarioPK);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHorario method, of class ConsumoDiario.
     */
    @Test
    public void testGetHorario() {
        System.out.println("getHorario");
        ConsumoDiario instance = new ConsumoDiario();
        Integer expResult = null;
        Integer result = instance.getHorario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHorario method, of class ConsumoDiario.
     */
    @Test
    public void testSetHorario() {
        System.out.println("setHorario");
        Integer horario = null;
        ConsumoDiario instance = new ConsumoDiario();
        instance.setHorario(horario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCalMax method, of class ConsumoDiario.
     */
    @Test
    public void testGetCalMax() {
        System.out.println("getCalMax");
        ConsumoDiario instance = new ConsumoDiario();
        Double expResult = null;
        Double result = instance.getCalMax();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCalMax method, of class ConsumoDiario.
     */
    @Test
    public void testSetCalMax() {
        System.out.println("setCalMax");
        Double calMax = null;
        ConsumoDiario instance = new ConsumoDiario();
        instance.setCalMax(calMax);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConsumoDiarioAlimentoList method, of class ConsumoDiario.
     */
    @Test
    public void testGetConsumoDiarioAlimentoList() {
        System.out.println("getConsumoDiarioAlimentoList");
        ConsumoDiario instance = new ConsumoDiario();
        List<ConsumoDiarioAlimento> expResult = null;
        List<ConsumoDiarioAlimento> result = instance.getConsumoDiarioAlimentoList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setConsumoDiarioAlimentoList method, of class ConsumoDiario.
     */
    @Test
    public void testSetConsumoDiarioAlimentoList() {
        System.out.println("setConsumoDiarioAlimentoList");
        List<ConsumoDiarioAlimento> consumoDiarioAlimentoList = null;
        ConsumoDiario instance = new ConsumoDiario();
        instance.setConsumoDiarioAlimentoList(consumoDiarioAlimentoList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class ConsumoDiario.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        ConsumoDiario instance = new ConsumoDiario();
        User expResult = null;
        User result = instance.getUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUser method, of class ConsumoDiario.
     */
    @Test
    public void testSetUser() {
        System.out.println("setUser");
        User user = null;
        ConsumoDiario instance = new ConsumoDiario();
        instance.setUser(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHorrarioRefeicao method, of class ConsumoDiario.
     */
    @Test
    public void testGetHorrarioRefeicao() {
        System.out.println("getHorrarioRefeicao");
        ConsumoDiario instance = new ConsumoDiario();
        HorrarioRefeicao expResult = null;
        HorrarioRefeicao result = instance.getHorrarioRefeicao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHorrarioRefeicao method, of class ConsumoDiario.
     */
    @Test
    public void testSetHorrarioRefeicao() {
        System.out.println("setHorrarioRefeicao");
        HorrarioRefeicao horrarioRefeicao = null;
        ConsumoDiario instance = new ConsumoDiario();
        instance.setHorrarioRefeicao(horrarioRefeicao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class ConsumoDiario.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        ConsumoDiario instance = new ConsumoDiario();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class ConsumoDiario.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        ConsumoDiario instance = new ConsumoDiario();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class ConsumoDiario.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ConsumoDiario instance = new ConsumoDiario();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
