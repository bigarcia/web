package br.ufscar.dc.dsw.locacao.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class NovaLocadoraFormBean {
    private String email_locadora, senha_locadora, cnpj_locadora,  nome_locadora, cidade_locadora;

    public String getEmail_locadora() {
        return email_locadora;
    }

    public void setEmail_locadora(String email_locadora) {
        this.email_locadora = email_locadora;
    }

    public String getSenha_locadora() {
        return senha_locadora;
    }

    public void setSenha_locadora(String senha_locadora) {
        this.senha_locadora = senha_locadora;
    }

    public String getCnpj_locadora() {
        return cnpj_locadora;
    }

    public void setCnpj_locadora(String cnpj_locadora) {
        this.cnpj_locadora = cnpj_locadora;
    }

    public String getNome_locadora() {
        return nome_locadora;
    }

    public void setNome_locadora(String nome_locadora) {
        this.nome_locadora = nome_locadora;
    }

    public String getCidade_locadora() {
        return cidade_locadora;
    }

    public void setCidade_locadora(String cidade_locadora) {
        this.cidade_locadora = cidade_locadora;
    }
    
    public List<String> validar() {
        List<String> mensagens = new ArrayList<String>();
        if (nome_locadora.trim().length() == 0) {
            mensagens.add("Nome não pode ser vazio!");
        }
        if (email_locadora.trim().length() == 0) {
            mensagens.add("Email não pode ser vazio!");
        }
        if (!email_locadora.contains("@")) {
            mensagens.add("E-mail está em formato incorreto!");
        }
        if (cnpj_locadora.trim().length() == 0) {
            mensagens.add("CNPJ não pode ser vazio!");
        }
        if (senha_locadora.trim().length() == 0) {
            mensagens.add("Senha não pode ser vazio!");
        }
        if (cidade_locadora.trim().length() == 0) {
            mensagens.add("Cidade não pode ser vazio!");
        }
        return mensagens;
    }
}
