package br.ufscar.dc.dsw.locacao.bean;

import java.util.ArrayList;
import java.util.List;

public class NovaLocacaoFormBean {
    private String cnpj_locacao, data_locacao, nome_locadora;

    public String getNome_locadora() {
        return nome_locadora;
    }

    public void setNome_locadora(String nome_locadora) {
        this.nome_locadora = nome_locadora;
    }
    

    public String getCnpj_locacao() {
        return cnpj_locacao;
    }

    public void setCnpj_locacao(String cnpj_locacao) {
        this.cnpj_locacao = cnpj_locacao;
    }

    public String getData_locacao() {
        return data_locacao;
    }

    public void setData_locacao(String data_locacao) {
        this.data_locacao = data_locacao;
    }
    public List<String> validar() {
        List<String> mensagens = new ArrayList<String>();
        if (nome_locadora.trim().length() == 0) {
            mensagens.add("Nome não pode ser vazio!");
        }
        if (cnpj_locacao.trim().length() == 0) {
            mensagens.add("CNPJ não pode ser vazio!");
        }
		if (data_locacao.trim().length() == 0){
			mensagens.add("Nome não pode ser vazio!");
		}
        return mensagens;
    }

    public String getData_dia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
