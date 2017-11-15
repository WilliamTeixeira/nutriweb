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
public class UserTest {
    
    public UserTest() {
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
     * Test of getIduser method, of class User.
     */
    @Test
    public void testGetIduser() {
        System.out.println("getIduser");
        User instance = new User();
        Integer expResult = null;
        Integer result = instance.getIduser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIduser method, of class User.
     */
    @Test
    public void testSetIduser() {
        System.out.println("setIduser");
        Integer iduser = null;
        User instance = new User();
        instance.setIduser(iduser);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNome method, of class User.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        User instance = new User();
        String expResult = "";
        String result = instance.getNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNome method, of class User.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "";
        User instance = new User();
        instance.setNome(nome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class User.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        User instance = new User();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class User.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        User instance = new User();
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSenha method, of class User.
     */
    @Test
    public void testGetSenha() {
        System.out.println("getSenha");
        User instance = new User();
        String expResult = "";
        String result = instance.getSenha();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSenha method, of class User.
     */
    @Test
    public void testSetSenha() {
        System.out.println("setSenha");
        String senha = "";
        User instance = new User();
        instance.setSenha(senha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getObjetivo method, of class User.
     */
    @Test
    public void testGetObjetivo() {
        System.out.println("getObjetivo");
        User instance = new User();
        String expResult = "";
        String result = instance.getObjetivo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setObjetivo method, of class User.
     */
    @Test
    public void testSetObjetivo() {
        System.out.println("setObjetivo");
        String objetivo = "";
        User instance = new User();
        instance.setObjetivo(objetivo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHistoricoList method, of class User.
     */
    @Test
    public void testGetHistoricoList() {
        System.out.println("getHistoricoList");
        User instance = new User();
        List<Historico> expResult = null;
        List<Historico> result = instance.getHistoricoList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHistoricoList method, of class User.
     */
    @Test
    public void testSetHistoricoList() {
        System.out.println("setHistoricoList");
        List<Historico> historicoList = null;
        User instance = new User();
        instance.setHistoricoList(historicoList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConsumoDiarioList method, of class User.
     */
    @Test
    public void testGetConsumoDiarioList() {
        System.out.println("getConsumoDiarioList");
        User instance = new User();
        List<ConsumoDiario> expResult = null;
        List<ConsumoDiario> result = instance.getConsumoDiarioList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setConsumoDiarioList method, of class User.
     */
    @Test
    public void testSetConsumoDiarioList() {
        System.out.println("setConsumoDiarioList");
        List<ConsumoDiario> consumoDiarioList = null;
        User instance = new User();
        instance.setConsumoDiarioList(consumoDiarioList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class User.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        User instance = new User();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class User.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        User instance = new User();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class User.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        User instance = new User();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
