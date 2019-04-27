package br.ufscar.dc.dsw.model;

public class Cliente {

    //private int id_cliente;
    private String email_cliente;
    private String senha_cliente;
    private String cpf_cliente;
    private String nome_cliente;
    private String telefone_cliente;
    private String sexo_cliente;
    private String nascimento_cliente;

    public Cliente(String email_cliente, String senha_cliente, String cpf_cliente, String nome_cliente, String telefone_cliente, String sexo_cliente, String nascimento_cliente) {
        this.email_cliente = email_cliente;
        this.senha_cliente = senha_cliente;
        this.cpf_cliente = cpf_cliente;
        this.nome_cliente = nome_cliente;
        this.telefone_cliente = telefone_cliente;
        this.sexo_cliente = sexo_cliente;
        this.nascimento_cliente = nascimento_cliente;
    }
    
     public Cliente(String email_cliente, String senha_cliente, String nome_cliente, String telefone_cliente, String sexo_cliente, String nascimento_cliente) {
        this.email_cliente = email_cliente;
        this.senha_cliente = senha_cliente;
       // this.cpf_cliente = cpf_cliente;
        this.nome_cliente = nome_cliente;
        this.telefone_cliente = telefone_cliente;
        this.sexo_cliente = sexo_cliente;
        this.nascimento_cliente = nascimento_cliente;
    }
    
    public Cliente(String cpf_cliente){
        this.cpf_cliente = cpf_cliente;
    }
    
    public Cliente(){
        
    }


 
    /*public Cliente(String cpf_cliente, String cnpj_locadora, String data_dia) {
        this.cpf_cliente = cpf_cliente;
        this.cnpj_locadora = cnpj_locadora;
        this.data_dia = data_dia;
    }*/

   /* public Cliente(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    

   /* public Cliente(String email_cliente, String senha_cliente, String cpf_cliente, String nome_cliente, String telefone_cliente, String sexo_cliente, java.util.Date nascimento_cliente) {
       this.email_cliente = email_cliente;
        this.senha_cliente = senha_cliente;
        this.cpf_cliente = cpf_cliente;
        this.nome_cliente = nome_cliente;
        this.telefone_cliente = telefone_cliente;
        this.sexo_cliente = sexo_cliente;
        this.nascimento_cliente = nascimento_cliente;
    }*/

   /* public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
*/
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

    public void setNascimento_cliente(String nascimento_cliente) {
        this.nascimento_cliente = nascimento_cliente;
    }   
}
