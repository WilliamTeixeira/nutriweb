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
import java.io.FileInputStream;
import java.sql.SQLException;

/**
 *
 * @author william
 */
public class AlimentoTest {
    
    public AlimentoTest() {
    }
    
    /**
     * Teste do metodo getIdalimento: classe Alimento.
     */
    @Test
    public void testGetIdalimento() {
        System.out.println("Teste getIdalimento");
        Alimento obj = new Alimento(1);
        int expResult = 1;
        int result = obj.getIdalimento();
        assertEquals(expResult, result);
    }
    
    /**
     * Teste do metodo setIdalimento: classe Alimento.
     */
    @Test
    public void testSetIdalimento() {
        System.out.println("Teste setIdalimento");
        int idalimento = 1;
        Alimento obj = new Alimento();
        obj.setIdalimento(idalimento);
    }
    
    /**
     * Teste do metodo getDescricao: classe Alimento
     */
    @Test
    public void testGetDescricao() {
        System.out.println("Teste getDescricao");
        Alimento obj = new Alimento(1, "Alimento 1", 0, "un");
        String expResult = "Alimento 1";
        String result = obj.getDescricao();
        assertEquals(expResult, result);
    }
    
    /**
     * Teste do metodo setDescricao: classe Alimento
     */
    @Test
    public void testSetDescricao() {
        System.out.println("Teste setDescricao");
        String descricao = "Alimento 1";
        Alimento obj = new Alimento(1, "", 0, "un");
        obj.setDescricao(descricao);
    }
    
    /**
     * Teste do metodo getCal: classe Alimento
     */
    @Test
    public void testGetCal() {
        System.out.println("Teste getCal");
        Alimento obj = new Alimento(1, "", 0, "un");
        int expResult = 0;
        int result = obj.getCal();
        assertEquals(expResult, result);
    }
    
    /**
     * Teste setCal: classe Alimento
     */
    @Test
    public void testSetCal() {
        System.out.println("Teste setCal");
        int cal = 0;
        Alimento obj = new Alimento(1);
        obj.setCal(cal);
    }
    
    /**
     * Teste getUnidade: classe Alimento
     */
    @Test
    public void testGetUnidade() {
        System.out.println("Teste getUnidade");
        Alimento obj = new Alimento(1, "", 0, "un");
        String expResult = "un";
        String result = obj.getUnidade();
        assertEquals(expResult, result);
    }
    
    /**
     * Teste do metodo setUnidade: classe Alimento
     */
    @Test
    public void testSetUnidade() {
        System.out.println("Teste setUnidade");
        String unidade = "un";
        Alimento obj = new Alimento(1, "", 0, "");
        obj.setUnidade(unidade);
    }
    
    /**
     * Teste do meto override Hashcode com id diferente de null: Classe Alimento
     */
    @Test
    public void testHashCodeDifNull() {
        System.out.println("Teste hashCode - id diferente de null");
        Alimento obj = new Alimento(1);
        int expResult = obj.getIdalimento().hashCode();
        int result = obj.hashCode();
        assertEquals(expResult, result);
    }
    
    /**
     * Teste do meto override Hashcode com id igual a null: Classe Alimento
     */
    @Test
    public void testHashCodeNull() {
        System.out.println("Teste hashCode - id null");
        Alimento obj = new Alimento();
        int expResult = 0;
        int result = obj.hashCode();
        assertEquals(expResult, result);
    }
    
    /**
     * Teste override do equals com objetos diferentes: classe Alimento
     */
    @Test
    public void testEqualsObjDiferente() {
        System.out.println("Teste equals: false");
        Object outroObj = null;
        Alimento obj = new Alimento();
        boolean expResult = false;
        boolean result = obj.equals(outroObj);
        assertEquals(expResult, result);
    }
    
    /**
     * Teste override do equals com objetos iguais: classe Alimento
     */
    @Test
    public void testEquals() {
        System.out.println("Teste equals: true");
        Alimento outroObj = new Alimento(1);
        Alimento obj = new Alimento(1);
        boolean expResult = true;
        boolean result = obj.equals(outroObj);
        assertEquals(expResult, result);
    }
    
    /**
     * Teste override do toString: classe Alimento
     */
    @Test
    public void testToString() {
        System.out.println("Teste do toString");
        Alimento obj = new Alimento(1);
        String expResult = "Model.Alimento[ idalimento=" + 1 + " ]";
        String result = obj.toString();
        assertEquals(expResult, result);
    }
    
    @After
    public void tearDown() {
    }
}