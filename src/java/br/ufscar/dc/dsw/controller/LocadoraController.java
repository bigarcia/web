//package br.ufscar.dc.dsw.controller;
//
//import br.ufscar.dc.dsw.dao.LocadoraDAO;
//import br.ufscar.dc.dsw.model.Locadora;
//import java.io.IOException;
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
//@WebServlet(urlPatterns = "/locadora")
//public class LocadoraController extends HttpServlet {
//
//    private LocadoraDAO dao;
//
//    @Override
//    public void init() {
//        dao = new LocadoraDAO();
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
//            Logger.getLogger(LocadoraController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    private void lista(HttpServletRequest request, HttpServletResponse response) //listar todas as locadoras
//        throws ServletException, IOException {
//            List<Locadora> listarLocadora = dao.listarTodasLocadoras();
//            request.setAttribute("listaLocadora", listarLocadora);
//            RequestDispatcher dispatcher = request.getRequestDispatcher("locacadora/lista.jsp");
//            dispatcher.forward(request, response);
//    }
//
//    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        RequestDispatcher dispatcher = request.getRequestDispatcher("locacadora/formulario.jsp"); //formulario de locacoes
//        dispatcher.forward(request, response);
//    }
//
//    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response) //editar locacoes
//            throws ServletException, IOException {
//        String id = request.getParameter("id"); //
//        Locadora locadora = dao.get(id);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("locadora/formulario.jsp");
//        request.setAttribute("locadora", locadora);
//        dispatcher.forward(request, response);
//    }
//
//    private void insere(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
//        request.setCharacterEncoding("UTF-8");
//        String email = request.getParameter("email");
//        String senha = request.getParameter("senha");
//        String cnpj = request.getParameter("cnpj");
//        String nome = request.getParameter("nome");
//        String cidade = request.getParameter("cidade");
//
//        Locadora locadora = new Locadora(email, senha, cnpj, nome, cidade);
//        dao.gravarLocadora(locadora);
//        response.sendRedirect("lista");
//    }
//
//    private void atualize(HttpServletRequest request, HttpServletResponse response)
//            throws IOException {
//        request.setCharacterEncoding("UTF-8");
//        String email = request.getParameter("email");
//        String senha = request.getParameter("senha");
//        String cnpj = request.getParameter("cnpj");
//        String nome = request.getParameter("nome");
//        String cidade = request.getParameter("cidade");
//
//        Locadora locadora = new Locadora(email, senha, cnpj, nome, cidade);
//        dao.update(locadora);
//        response.sendRedirect("lista");
//    }
//
//    private void remove(HttpServletRequest request, HttpServletResponse response)
//            throws IOException {
//        String cnpj_locadora = (request.getParameter("cnpj_locadora"));
//        Locadora locadora = new Locadora(cnpj_locadora);
//        dao.delete(locadora);
//        response.sendRedirect("lista");
//    }
//}
