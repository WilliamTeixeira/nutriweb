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

    
}
