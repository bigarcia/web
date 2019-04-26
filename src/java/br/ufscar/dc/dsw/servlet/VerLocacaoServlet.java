//package br.ufscar.dc.servlet;
//
//import br.ufscar.dc.dsw.dao.LocacaoDAO;
//import br.ufscar.dc.dsw.model.Locacao;
//import java.io.IOException;
//import java.util.List;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet(urlPatterns = {"/VerLocacaoServlet"})
//public class VerLocacaoServlet extends HttpServlet {
//	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//	throws ServletException, IOException {
//		String cliente_locacao = request.getParameter("cliente_locacao");
//		String locadora_locacao = request.getParameter("locadora_locacao");
//		List<Locacao> todasLocacao = null;
//		try {
//			LocacaoDAO locacaoDAO = new LocacaoDAO();
//			
//			if (cliente_locacao == null) {
//				//todasLocacao = locacaoDAO.listarTodasLocacao();
//				//se entrar aqui nao deve mostrar nada
//			} 
//			else {
//				todasLocacao = locacaoDAO.listarTodasLocacoesPorCliente(cliente_locacao);
//			}
//			
//			if (locadora_locacao == null) {
//				//todasLocacao = locacaoDAO.listarTodasLocacao();
//				//se entrar aqui nao deve mostrar nada
//			} 
//			else {
//				todasLocacao = locacaoDAO.listarTodasLocacoesPorLocadora(locadora_locacao);
//			}
//			
//			request.setAttribute("listaLocacao", todasLocacao);
//			request.getRequestDispatcher("listaLocacao.jsp").forward(request, response);
//		} 
//		catch (Exception e) {
//			e.printStackTrace();
//			request.setAttribute("mensagem", e.getLocalizedMessage());
//			request.getRequestDispatcher("erro.jsp").forward(request, response);
//		}
//	}
//}
