//
//package br.ufscar.dc.dsw.servlet;
//
//import br.ufscar.br.dsw.dao.LocacaoDAO;
//import br.ufscar.dc.dsw.locacao.bean.NovaLocacaoFormBean;
//import br.ufscar.dc.dsw.model.Locacao;
//import br.ufscar.dc.dsw.model.Cliente;
//import br.ufscar.dc.dsw.model.Locadora;
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//@WebServlet(urlPatterns = {"/GravarLocacaoServlet"})
//public class GravarLocacaoServlet extends HttpServlet {
//	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//	throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		NovaLocacaoFormBean nlofb = (NovaLocacaoFormBean) session.getAttribute("novaLocacao");
//		session.removeAttribute("novaLocacao");
//		
//		try {
//			LocacaoDAO locacaoDAO = new LocacaoDAO();
//
//			Locacao locacao = new Locacao();
//			locacao.setData_dia(nlofb.getData_dia());
//			locacao.setCpf_cliente(ncfb.getCpf_cliente());
//			locacao.setCnpj_locadora(ncfb.getCnpj_locadora());
//			locacao = locacaoDAO.gravarLocacao(locacao);
//			
//			request.setAttribute("mensagem", "Obrigado pelo Cadastro!");
//			request.getRequestDispatcher("index.jsp").forward(request, response);
//			
//		} 
//		catch (Exception e) {
//			e.printStackTrace();
//			request.setAttribute("mensagem", e.getLocalizedMessage());
//			request.getRequestDispatcher("erro.jsp").forward(request, response);
//		}
//	}
//}