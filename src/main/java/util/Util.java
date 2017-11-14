/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import Model.RefeicoesObjetivo;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import util.exception.CriptografiaException;

/**
 *
 * @author Daves
 */
public class Util {

    public static final List<RefeicoesObjetivo> listaDieta = new ArrayList<>();

    static {
        listaDieta.add(new RefeicoesObjetivo("Emagrecer", "Café da Manhã", 7, 120));
        listaDieta.add(new RefeicoesObjetivo("Emagrecer", "Lanche da Manhã", 10, 80));
        listaDieta.add(new RefeicoesObjetivo("Emagrecer", "Almoço", 12, 500));
        listaDieta.add(new RefeicoesObjetivo("Emagrecer", "Lanche da Tarde", 15, 80));
        listaDieta.add(new RefeicoesObjetivo("Emagrecer", "Jantar", 18, 300));
        listaDieta.add(new RefeicoesObjetivo("Emagrecer", "Lanche da Noite", 21, 50));

        listaDieta.add(new RefeicoesObjetivo("Ganhar Massa", "Café da Manhã", 7, 350));
        listaDieta.add(new RefeicoesObjetivo("Ganhar Massa", "Lanche da Manhã", 10, 150));
        listaDieta.add(new RefeicoesObjetivo("Ganhar Massa", "Almoço", 12, 700));
        listaDieta.add(new RefeicoesObjetivo("Ganhar Massa", "Lanche da Tarde", 15, 150));
        listaDieta.add(new RefeicoesObjetivo("Ganhar Massa", "Jantar", 18, 500));
        listaDieta.add(new RefeicoesObjetivo("Ganhar Massa", "Lanche da Noite", 21, 150));

        listaDieta.add(new RefeicoesObjetivo("Melhorar Alimentação", "Café da Manhã", 7, 200));
        listaDieta.add(new RefeicoesObjetivo("Melhorar Alimentação", "Lanche da Manhã", 10, 100));
        listaDieta.add(new RefeicoesObjetivo("Melhorar Alimentação", "Almoço", 12, 500));
        listaDieta.add(new RefeicoesObjetivo("Melhorar Alimentação", "Lanche da Tarde", 15, 100));
        listaDieta.add(new RefeicoesObjetivo("Melhorar Alimentação", "Jantar", 18, 400));
        listaDieta.add(new RefeicoesObjetivo("Melhorar Alimentação", "Lanche da Noite", 21, 90));
    }

    public static RefeicoesObjetivo findDieta(String objetivo, String refeicao) {
        for (RefeicoesObjetivo ro : listaDieta) {
            if (ro.getObjetivo().equals(objetivo) && ro.getTipoRefeicao().equals(refeicao)) {
                return ro;
            }
        }
        return null;
    }

    public static String toMd5(String valor) throws CriptografiaException {
        MessageDigest mDigest;
        try {
            //Instanciamos o nosso HASH MD5, poderíamos usar outro como
            //SHA, por exemplo, mas optamos por MD5.
            mDigest = MessageDigest.getInstance("MD5");

            //Convert a String valor para um array de bytes em MD5
            byte[] valorMD5 = mDigest.digest(valor.getBytes("UTF-8"));

            //Convertemos os bytes para hexadecimal, assim podemos salvar
            //no banco para posterior comparação se senhas
            StringBuffer sb = new StringBuffer();
            for (byte b : valorMD5) {
                sb.append(Integer.toHexString((b & 0xFF)
                        | 0x100).substring(1, 3));
            }

            return sb.toString();

        } catch (UnsupportedEncodingException e) {
            throw new CriptografiaException("Erro na Criptografia: " + e.getMessage());
        } catch (NoSuchAlgorithmException e) {
            throw new CriptografiaException("Erro na Criptografia: " + e.getMessage());
        }
    }

}
