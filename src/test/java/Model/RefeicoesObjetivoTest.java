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
public class RefeicoesObjetivoTest {
    
    public RefeicoesObjetivoTest() {
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
     * Test of getObjetivo method, of class RefeicoesObjetivo.
     */
    @Test
    public void testGetObjetivo() {
        System.out.println("getObjetivo");
        RefeicoesObjetivo instance = new RefeicoesObjetivo();
        String expResult = "";
        String result = instance.getObjetivo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setObjetivo method, of class RefeicoesObjetivo.
     */
    @Test
    public void testSetObjetivo() {
        System.out.println("setObjetivo");
        String objetivo = "";
        RefeicoesObjetivo instance = new RefeicoesObjetivo();
        instance.setObjetivo(objetivo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTipoRefeicao method, of class RefeicoesObjetivo.
     */
    @Test
    public void testGetTipoRefeicao() {
        System.out.println("getTipoRefeicao");
        RefeicoesObjetivo instance = new RefeicoesObjetivo();
        String expResult = "";
        String result = instance.getTipoRefeicao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTipoRefeicao method, of class RefeicoesObjetivo.
     */
    @Test
    public void testSetTipoRefeicao() {
        System.out.println("setTipoRefeicao");
        String tipoRefeicao = "";
        RefeicoesObjetivo instance = new RefeicoesObjetivo();
        instance.setTipoRefeicao(tipoRefeicao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHorario method, of class RefeicoesObjetivo.
     */
    @Test
    public void testGetHorario() {
        System.out.println("getHorario");
        RefeicoesObjetivo instance = new RefeicoesObjetivo();
        int expResult = 0;
        int result = instance.getHorario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHorario method, of class RefeicoesObjetivo.
     */
    @Test
    public void testSetHorario() {
        System.out.println("setHorario");
        int horario = 0;
        RefeicoesObjetivo instance = new RefeicoesObjetivo();
        instance.setHorario(horario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCalMax method, of class RefeicoesObjetivo.
     */
    @Test
    public void testGetCalMax() {
        System.out.println("getCalMax");
        RefeicoesObjetivo instance = new RefeicoesObjetivo();
        double expResult = 0.0;
        double result = instance.getCalMax();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCalMax method, of class RefeicoesObjetivo.
     */
    @Test
    public void testSetCalMax() {
        System.out.println("setCalMax");
        double calMax = 0.0;
        RefeicoesObjetivo instance = new RefeicoesObjetivo();
        instance.setCalMax(calMax);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
