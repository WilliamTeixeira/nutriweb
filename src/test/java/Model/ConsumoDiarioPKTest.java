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
public class ConsumoDiarioPKTest {
    
    public ConsumoDiarioPKTest() {
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
     * Test of getIduser method, of class ConsumoDiarioPK.
     */
    @Test
    public void testGetIduser() {
        System.out.println("getIduser");
        ConsumoDiarioPK instance = new ConsumoDiarioPK();
        int expResult = 0;
        int result = instance.getIduser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIduser method, of class ConsumoDiarioPK.
     */
    @Test
    public void testSetIduser() {
        System.out.println("setIduser");
        int iduser = 0;
        ConsumoDiarioPK instance = new ConsumoDiarioPK();
        instance.setIduser(iduser);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdTipoRefeicao method, of class ConsumoDiarioPK.
     */
    @Test
    public void testGetIdTipoRefeicao() {
        System.out.println("getIdTipoRefeicao");
        ConsumoDiarioPK instance = new ConsumoDiarioPK();
        int expResult = 0;
        int result = instance.getIdTipoRefeicao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdTipoRefeicao method, of class ConsumoDiarioPK.
     */
    @Test
    public void testSetIdTipoRefeicao() {
        System.out.println("setIdTipoRefeicao");
        int idTipoRefeicao = 0;
        ConsumoDiarioPK instance = new ConsumoDiarioPK();
        instance.setIdTipoRefeicao(idTipoRefeicao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getData method, of class ConsumoDiarioPK.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        ConsumoDiarioPK instance = new ConsumoDiarioPK();
        Date expResult = null;
        Date result = instance.getData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setData method, of class ConsumoDiarioPK.
     */
    @Test
    public void testSetData() {
        System.out.println("setData");
        Date data = null;
        ConsumoDiarioPK instance = new ConsumoDiarioPK();
        instance.setData(data);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class ConsumoDiarioPK.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        ConsumoDiarioPK instance = new ConsumoDiarioPK();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class ConsumoDiarioPK.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        ConsumoDiarioPK instance = new ConsumoDiarioPK();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class ConsumoDiarioPK.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ConsumoDiarioPK instance = new ConsumoDiarioPK();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
