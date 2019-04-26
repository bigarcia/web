//package br.ufscar.dc.dsw.servlet;
//
//import br.ufscar.dc.dsw.dao.ClienteDAO;
//import br.ufscar.dc.dsw.dao.LocadoraDAO;
//import br.ufscar.dc.dsw.locacao.bean.NovaLocadoraFormBean;
//import br.ufscar.dc.dsw.locacao.bean.NovoClienteFormBean;
//import br.ufscar.dc.dsw.model.Cliente;
//import br.ufscar.dc.dsw.model.Locadora;
//import java.io.IOException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//
//@WebServlet(urlPatterns = {"/GravarCLienteServlet"})
//public class GravarClienteServlet extends HttpServlet {
//	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//	throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		NovoClienteFormBean ncfb = (NovoClienteFormBean) session.getAttribute("novoCliente");
//		session.removeAttribute("novoCliente");
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String nascimento_cliente = null;
//		try {
//			nascimento_cliente = sdf.parse(ncfb.getNascimento_cliente());
//		} 
//		catch (ParseException e) {
//			request.setAttribute("mensagem", e.getLocalizedMessage());
//			request.getRequestDispatcher("erro.jsp").forward(request, response);
//		}
//		try {
//			ClienteDAO clienteDAO = new ClienteDAO();
//
//			Cliente cliente = new Cliente();
//			cliente.setEmail_cliente(ncfb.getEmail_cliente());
//			cliente.setSenha_cliente(ncfb.getSenha_cliente());
//			cliente.setCpf_cliente(ncfb.getCpf_cliente());
//			cliente.setNome_cliente(ncfb.getNome_cliente());
//			cliente.setTelefone_cliente(ncfb.getTelefone_cliente());
//			cliente.setSexo_cliente(ncfb.getSexo_cliente());
//			cliente.setNascimento_cliente(ncfb.getNascimento_cliente());
//			cliente = clienteDAO.gravarCliente(cliente);
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