package br.ufjf.dcc;

import java.io.Serializable;
import java.util.Date;

public class Lancamento implements Serializable{
    private String descricao;
    private Date data;
    private Double valor;

    public Lancamento() {
        this("", 0.0, new Date());
    }

    public Lancamento(String descricao, Double valor) {
        this(descricao, valor, new Date());
    }
    
    public Lancamento(String descricao, Double valor, Date data) {
        this.descricao = descricao;
        this.data = data;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
}
