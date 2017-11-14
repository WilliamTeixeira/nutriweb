/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Daves
 */
public class RefeicoesObjetivo {
    private String objetivo;
    private String tipoRefeicao;
    private int horario;
    private double calMax;

    public RefeicoesObjetivo() {
    }

    public RefeicoesObjetivo(String objetivo, String tipoRefeicao, int horario, double calMax) {
        this.objetivo = objetivo;
        this.tipoRefeicao = tipoRefeicao;
        this.horario = horario;
        this.calMax = calMax;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getTipoRefeicao() {
        return tipoRefeicao;
    }

    public void setTipoRefeicao(String tipoRefeicao) {
        this.tipoRefeicao = tipoRefeicao;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public double getCalMax() {
        return calMax;
    }

    public void setCalMax(double calMax) {
        this.calMax = calMax;
    }
    
    
}
