package br.ufscar.dc.dsw.locacao.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class NovoClienteFormBean {

    private String email_cliente, senha_cliente, cpf_cliente, nome_cliente, telefone_cliente, sexo_cliente, nascimento_cliente;
   /* private int id_cliente;
    
   public int getId_cliente(){
       return id_cliente;        
   }*/
    public String getEmail_cliente() {
        return email_cliente;
    }

    public void setEmail_cliente(String email_cliente) {
        this.email_cliente = email_cliente;
    }

    public String getSenha_cliente() {
        return senha_cliente;
    }

    public void setSenha_cliente(String senha_cliente) {
        this.senha_cliente = senha_cliente;
    }

    public String getCpf_cliente() {
        return cpf_cliente;
    }

    public void setCpf_cliente(String cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getTelefone_cliente() {
        return telefone_cliente;
    }

    public void setTelefone_cliente(String telefone_cliente) {
        this.telefone_cliente = telefone_cliente;
    }

    public String getSexo_cliente() {
        return sexo_cliente;
    }

    public void setSexo_cliente(String sexo_cliente) {
        this.sexo_cliente = sexo_cliente;
    }

    public String getNascimento_cliente() {
        return nascimento_cliente;
    }

    public void setDataDeNascimento_cliente(String dataDeNascimento_cliente) {
        this.nascimento_cliente = dataDeNascimento_cliente;
    }

    public List<String> validar() {
        List<String> mensagens = new ArrayList<String>();
        if (nome_cliente.trim().length() == 0) {
            mensagens.add("Nome não pode ser vazio!");
        }
        if (email_cliente.trim().length() == 0) {
            mensagens.add("Email não pode ser vazio!");
        }
        if (!email_cliente.contains("@")) {
            mensagens.add("E-mail está em formato incorreto!");
        }
        if (cpf_cliente.trim().length() == 0) {
            mensagens.add("CPF não pode ser vazio!");
        }
        if (senha_cliente.trim().length() == 0) {
            mensagens.add("Senha não pode ser vazio!");
        }
        if (telefone_cliente.trim().length() == 0) {
            mensagens.add("Telefone não pode ser vazio!");
        }
        if (sexo_cliente.trim().length() == 0) {
            mensagens.add("Sexo não pode ser vazio!");
        }
        if (nascimento_cliente.trim().length() == 0) {
            mensagens.add("Data de nascimento não pode ser vazio!");
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.parse(nascimento_cliente);
        } catch (ParseException pe) {
            mensagens.add("Data de nascimento deve estar no formato dd/mm/aaaa!");
        }
        return mensagens;
    }
}