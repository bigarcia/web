package br.ufscar.dc.dsw.model;


public class Locacao {
    private int id_locacao;
    private String data_dia;
    private String cpf_cliente;
    private String cnpj_locadora;

    public Locacao(int id_locacao, String data_dia, String cpf_cliente, String cnpj_locadora) {
        this.id_locacao = id_locacao;
        this.data_dia = data_dia;
        this.cpf_cliente = cpf_cliente;
        this.cnpj_locadora = cnpj_locadora;
    }

    /*public Locacao(String data_dia, String cpf_cliente, String cnpj_locadora) {
        this.data_dia = data_dia;
        this.cpf_cliente = cpf_cliente;
        this.cnpj_locadora = cnpj_locadora;
    }*/

    public Locacao(String cpf_cliente, String cnpj_locadora, String data_dia) {
        this.cpf_cliente = cpf_cliente;
        this.cnpj_locadora = cnpj_locadora;
        this.data_dia = data_dia;
    }

    public Locacao(int id) {
        this.id_locacao = id;
    }
    
    public Locacao(){
        
    }

    /*public Locacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    public int getId_locacao() {
        return id_locacao;
    }

    public String getData_locacao() {
        return data_dia;
    }

    public String getCpf_cliente() {
        return cpf_cliente;
    }

    public String getCnpj_locadora() {
        return cnpj_locadora;
    }

    public void setId_locacao(int id_locacao) {
        this.id_locacao = id_locacao;
    }

    public void setData_dia(String data_dia) {
        this.data_dia = data_dia;
    }

    public void setCpf_cliente(String cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
    }
    public void setCnpj_locadora(String cnpj_locadora) {
        this.cnpj_locadora = cnpj_locadora;
    }

}