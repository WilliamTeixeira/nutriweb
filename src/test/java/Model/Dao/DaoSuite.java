/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author william
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({Model.Dao.HorrarioRefeicaoJpaControllerTest.class, Model.Dao.HistoricoJpaControllerTest.class, Model.Dao.UserJpaControllerTest.class, Model.Dao.AlimentoJpaControllerTest.class, Model.Dao.ConsumoDiarioAlimentoJpaControllerTest.class, Model.Dao.ConsumoDiarioJpaControllerTest.class, Model.Dao.exceptions.ExceptionsSuite.class})
public class DaoSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
