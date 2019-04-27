package br.ufscar.dc.dsw.model;

public class Locadora {

    private String cnpj_locadora;
    private String email_locadora;
    private String senha_locadora;
    private String nome_locadora;
    private String cidade_locadora;

    public Locadora(String cnpj_locadora, String email_locadora, String senha_locadora, String nome_locadora, String cidade_locadora) {
        this.cnpj_locadora = cnpj_locadora;
        this.email_locadora = email_locadora;
        this.senha_locadora = senha_locadora;
        this.nome_locadora = nome_locadora;
        this.cidade_locadora = cidade_locadora;
    }

    /*public Locadora(String email_locadora, String senha_locadora, String nome_locadora, String cidade_locadora) {
        this.email_locadora = email_locadora;
        this.senha_locadora = senha_locadora;
        this.nome_locadora = nome_locadora;
        this.cidade_locadora = cidade_locadora;
    }*/
    
    public Locadora (String cnpj_locadora){
        this.cnpj_locadora = cnpj_locadora;
    }
    
    public Locadora(){
        
    }


    public String getCnpj_locadora() {
        return cnpj_locadora;
    }

    public void setCpnj_locadora(String cnpj_locadora) {
        this.cnpj_locadora = cnpj_locadora;
    }

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
}