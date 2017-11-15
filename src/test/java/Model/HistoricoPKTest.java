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
public class HistoricoPKTest {
    
    public HistoricoPKTest() {
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
     * Test of getIdhistorico method, of class HistoricoPK.
     */
    @Test
    public void testGetIdhistorico() {
        System.out.println("getIdhistorico");
        HistoricoPK instance = new HistoricoPK();
        int expResult = 0;
        int result = instance.getIdhistorico();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdhistorico method, of class HistoricoPK.
     */
    @Test
    public void testSetIdhistorico() {
        System.out.println("setIdhistorico");
        int idhistorico = 0;
        HistoricoPK instance = new HistoricoPK();
        instance.setIdhistorico(idhistorico);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIduser method, of class HistoricoPK.
     */
    @Test
    public void testGetIduser() {
        System.out.println("getIduser");
        HistoricoPK instance = new HistoricoPK();
        int expResult = 0;
        int result = instance.getIduser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIduser method, of class HistoricoPK.
     */
    @Test
    public void testSetIduser() {
        System.out.println("setIduser");
        int iduser = 0;
        HistoricoPK instance = new HistoricoPK();
        instance.setIduser(iduser);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class HistoricoPK.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        HistoricoPK instance = new HistoricoPK();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class HistoricoPK.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        HistoricoPK instance = new HistoricoPK();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class HistoricoPK.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        HistoricoPK instance = new HistoricoPK();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
