/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;
import java.util.HashSet;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author william
 */
public class HistoricoTest {
    
    public HistoricoTest() {
    }

    /**
     * Teste do metodo imc : classe Historico.
     */
    @Test
    public void testImc() {
        System.out.println("Teste imc");
        Historico obj = new Historico();
        obj.setAltura(1.78);
        obj.setPeso(60);
        double expResult = 60/(1.78 * 1.78); //18,93700290367378
        double result = obj.imc();
        assertEquals(expResult, result, 0.0);
    }
    
    /**
     * Teste do meto override Hashcode com id diferente de null: Classe Historico
     */
    @Test
    public void testHashCodeDifNull() {
        System.out.println("Teste hashCode - historicoPK diferente de null");
        Historico obj = new Historico(new HistoricoPK(1,1));
        int expResult = obj.getHistoricoPK().hashCode();
        int result = obj.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Teste do meto override Hashcode com historicoPK igual a null: Classe Historico
     */
    @Test
    public void testHashCodeNull() {
        System.out.println("Teste hashCode - historicoPK null");
        Historico obj = new Historico(null);
        int expResult = 0;
        int result = obj.hashCode();
        assertEquals(expResult, result);
    }
    
    /**
     * Teste override do equals com objetos diferentes: classe Historico
     */
    @Test
    public void testEqualsObjDiferente() {
        System.out.println("Teste equals: false");
        Object outroObj = null;
        Historico obj = new Historico();
        boolean expResult = false;
        boolean result = obj.equals(outroObj);
        assertEquals(expResult, result);
    }
    
    /**
     * Teste override do equals com objetos iguais: classe Historico
     */
    @Test
    public void testEquals() {
        System.out.println("Teste equals: true");
        Historico outroObj = new Historico(1,1);
        Historico obj = new Historico(1,1);
        boolean expResult = true;
        boolean result = obj.equals(outroObj);
        assertEquals(expResult, result);
    }
    
}
