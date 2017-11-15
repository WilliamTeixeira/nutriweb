/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;
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
public class HistoricoTest {
    
    public HistoricoTest() {
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
     * Test of imc method, of class Historico.
     */
    @Test
    public void testImc() {
        System.out.println("imc");
        Historico instance = new Historico();
        double expResult = 0.0;
        double result = instance.imc();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHistoricoPK method, of class Historico.
     */
    @Test
    public void testGetHistoricoPK() {
        System.out.println("getHistoricoPK");
        Historico instance = new Historico();
        HistoricoPK expResult = null;
        HistoricoPK result = instance.getHistoricoPK();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHistoricoPK method, of class Historico.
     */
    @Test
    public void testSetHistoricoPK() {
        System.out.println("setHistoricoPK");
        HistoricoPK historicoPK = null;
        Historico instance = new Historico();
        instance.setHistoricoPK(historicoPK);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPeso method, of class Historico.
     */
    @Test
    public void testGetPeso() {
        System.out.println("getPeso");
        Historico instance = new Historico();
        double expResult = 0.0;
        double result = instance.getPeso();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPeso method, of class Historico.
     */
    @Test
    public void testSetPeso() {
        System.out.println("setPeso");
        double peso = 0.0;
        Historico instance = new Historico();
        instance.setPeso(peso);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAltura method, of class Historico.
     */
    @Test
    public void testGetAltura() {
        System.out.println("getAltura");
        Historico instance = new Historico();
        double expResult = 0.0;
        double result = instance.getAltura();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAltura method, of class Historico.
     */
    @Test
    public void testSetAltura() {
        System.out.println("setAltura");
        double altura = 0.0;
        Historico instance = new Historico();
        instance.setAltura(altura);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataMedida method, of class Historico.
     */
    @Test
    public void testGetDataMedida() {
        System.out.println("getDataMedida");
        Historico instance = new Historico();
        Date expResult = null;
        Date result = instance.getDataMedida();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDataMedida method, of class Historico.
     */
    @Test
    public void testSetDataMedida() {
        System.out.println("setDataMedida");
        Date dataMedida = null;
        Historico instance = new Historico();
        instance.setDataMedida(dataMedida);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class Historico.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        Historico instance = new Historico();
        User expResult = null;
        User result = instance.getUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUser method, of class Historico.
     */
    @Test
    public void testSetUser() {
        System.out.println("setUser");
        User user = null;
        Historico instance = new Historico();
        instance.setUser(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Historico.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Historico instance = new Historico();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Historico.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Historico instance = new Historico();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Historico.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Historico instance = new Historico();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
