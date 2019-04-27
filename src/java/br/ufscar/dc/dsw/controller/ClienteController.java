///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package br.ufscar.dc.dsw.controller;
//
//import br.ufscar.dc.dsw.model.Cliente;
//import br.ufscar.dc.dsw.dao.ClienteDAO;
////import br.ufscar.dc.dsw.dao.UsuarioDAO;
//import java.io.IOException;
//import java.util.List;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet(urlPatterns = "/cliente_crud/*")
//public class ClienteController extends HttpServlet {
//    
//    private ClienteDAO daoCliente;
//    //private UsuarioDAO daoUsuario;
//
//    @Override
//    public void init() {
//        daoCliente = new ClienteDAO();
//        //daoUsuario = new UsuarioDAO();
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
//        doGet(request, response);
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
//        String action = request.getRequestURI();
//        action = action.split("/")[action.split("/").length - 1];
//        try {
//            switch (action) {
//                case "cadastro":
//                    apresentaFormCadastro(request, response);
//                    break;
//                case "insercao":
//                    insere(request, response);
//                    break;
//                case "remocao":
//                    remove(request, response);
//                    break;
//                case "edicao":
//                    apresentaFormEdicao(request, response);
//                    break;
//                case "atualizacao":
//                    atualize(request, response);
//                    break;
//                default:
//                    lista(request, response);
//                    break;
//            }
//        } catch (RuntimeException | IOException | ServletException e) {
//            throw new ServletException(e);
//        }
//    }
//
//    private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Cliente> listaClientes = daoCliente.getAll();
//        request.setAttribute("listaClientes", listaClientes);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/cliente/lista.jsp");
//        dispatcher.forward(request, response);
//    }
//
//    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/cliente/formulario.jsp");
//        dispatcher.forward(request, response);
//    }
//
//    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //int id = Integer.parseInt(request.getParameter("id"));
//        String cpf_cliente = request.getParameter("cpf_cliente");
//        Cliente cliente = daoCliente.get(cpf_cliente);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/cliente/formulario.jsp");
//        request.setAttribute("cliente", cliente);
//        dispatcher.forward(request, response);
//    }
//
//    private void insere(HttpServletRequest request, HttpServletResponse response)
//            throws IOException {
//                
//        request.setCharacterEncoding("UTF-8");
//        String nome = request.getParameter("nome");
//        String cpf = request.getParameter("cpf");
//        String telefone = request.getParameter("telefone");
//        String data_nascimento = request.getParameter("data_nascimento");
//        String sexo = request.getParameter("sexo");
//        String email = request.getParameter("email");
//        String senha = request.getParameter("senha");
//        //int ativo = 1;
//                
//        Cliente cliente = new Cliente(email,senha, cpf, nome, telefone, sexo, data_nascimento);
//        
//        daoCliente.gravarCliente(cliente);
//        
//        response.sendRedirect("lista");
//    }
//
//    private void atualize(HttpServletRequest request, HttpServletResponse response) throws IOException {
//       
//        request.setCharacterEncoding("UTF-8");
//        String cpf_cliente = request.getParameter("cpf_cliente");
////int id = Integer.parseInt(request.getParameter("id"));
//        String nome = request.getParameter("nome");
//        String cpf = request.getParameter("cpf");
//        String telefone = request.getParameter("telefone");
//        String data_nascimento = request.getParameter("data_nascimento");
//        String sexo = request.getParameter("sexo");
//        String email = request.getParameter("email");
//        String senha = request.getParameter("senha");
//       // int ativo = 1;
//        
//        Cliente cliente = new Cliente(nome, cpf, telefone, data_nascimento, sexo, senha, email);
//        daoCliente.update(cliente);
//        response.sendRedirect("lista");
//    }
//
//    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String cpf_cliente = request.getParameter("cpf_cliente");
////int id = Integer.parseInt(request.getParameter("id"));
//        Cliente cliente = new Cliente(cpf_cliente);
//        daoCliente.delete(cliente);
//        response.sendRedirect("lista");
//    }
//    
//}
