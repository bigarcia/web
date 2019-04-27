//package br.ufscar.dc.dsw.controller;
//
//import br.ufscar.dc.dsw.model.Cliente;
//import br.ufscar.dc.dsw.dao.ClienteDAO;
//import br.ufscar.dc.dsw.dao.LocacaoDAO;
//import br.ufscar.dc.dsw.model.Locacao;
//import java.io.IOException;
//import java.sql.Date;
//import java.sql.SQLException;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet(urlPatterns = "/locacao")
//public class LocacaoController extends HttpServlet {
//
//    private LocacaoDAO dao;
//
//    @Override
//    public void init() {
//        dao = new LocacaoDAO();
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException {
//        doGet(request, response);
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException {
//        String action = request.getServletPath();
//        try {
//            switch (action) {
//
//                case "/cadastro_locacao":
//                    apresentaFormCadastro(request, response);
//                    break;
//
//                case "/insercao":
//                    insere(request, response);
//                    break;
//
//                case "/remocao":
//                    remove(request, response);
//                    break;
//
//                case "/edicao":
//                    apresentaFormEdicao(request, response);
//                    break;
//
//                case "/atualizacao":
//                    atualize(request, response);
//                    break;
//
//                default:
//                    lista(request, response);
//                    break;
//            }
//
//        } catch (RuntimeException | IOException | ServletException e) {
//            throw new ServletException(e);
//        } catch (SQLException ex) {
//            Logger.getLogger(LocacaoController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    private void lista(HttpServletRequest request, HttpServletResponse response) //listar todas as locacoes
//            throws ServletException, IOException {
//        List<Locacao> listarLocacao = dao.getAll();
//        request.setAttribute("listaLocacao", listarLocacao);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("locacao/lista.jsp");
//        dispatcher.forward(request, response);
//    }
//
//    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        RequestDispatcher dispatcher = request.getRequestDispatcher("locacao/formulario.jsp"); //formulario de locacoes
//        dispatcher.forward(request, response);
//    }
//
//    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response) //editar locacoes
//            throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id")); //
//        Locacao locacao = dao.get(id);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("locacao/formulario.jsp");
//        request.setAttribute("locacao", locacao);
//        dispatcher.forward(request, response);
//    }
//
//    private void insere(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
//        request.setCharacterEncoding("UTF-8");
//        String cpf_cliente = request.getParameter("cpf_cliente"); //cpf cliente
//        String cnpj_locadora = request.getParameter("cnpj_locadora"); //cnpj locadora
//        String data_dia = request.getParameter("data_dia"); //data e hora da locacao
//
//        Locacao locacao = new Locacao(cpf_cliente, cnpj_locadora, data_dia);
//        dao.gravarLocacao(locacao);
//        response.sendRedirect("lista");
//    }
//
//    private void atualize(HttpServletRequest request, HttpServletResponse response)
//            throws IOException {
//        request.setCharacterEncoding("UTF-8");
//        String cpf = request.getParameter("cpf"); //cpf cliente
//        String cnpj = request.getParameter("cnpj"); //cnpj locadora
//        String data = request.getParameter("data"); //data e hora da locacao
//        Locacao locacao = new Locacao(cpf, cnpj, data);
//        dao.update(locacao);
//        response.sendRedirect("lista");
//    }
//
//    private void remove(HttpServletRequest request, HttpServletResponse response)
//            throws IOException {
//        int id = Integer.parseInt(request.getParameter("id")); //id = cpf?
//        Locacao locacao = new Locacao(id);
//        dao.delete(locacao);
//        response.sendRedirect("lista");
//    }
//}
