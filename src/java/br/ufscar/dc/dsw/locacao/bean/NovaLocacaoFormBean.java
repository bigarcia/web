package br.ufscar.dc.dsw.locacao.bean;

import java.util.ArrayList;
import java.util.List;

public class NovaLocacaoFormBean {
    private String cnpj_locadora, cpf_cliente, data_locacao, nome_locadora;
    private int id_locacao;

    public int getId_locacao() {
          return id_locacao;
    }
    
    public void setId_locacao(int id_locacao) {
        this.id_locacao = id_locacao;
    }
    
     public String getCpf_cliente() {
        return cpf_cliente;
    }
     
    public void setCpf_cliente(String cpf_cliente) {
       this.cpf_cliente = cpf_cliente;
    }
    
    public String getNome_locadora() {
        return nome_locadora;
    }

    public void setNome_locadora(String nome_locadora) {
        this.nome_locadora = nome_locadora;
    }
    

    public String getCnpj_locadora() {
        return cnpj_locadora;
    }

    public void setCnpj_locadora(String cnpj_locadora) {
        this.cnpj_locadora = cnpj_locadora;
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
        if (cnpj_locadora.trim().length() == 0) {
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
