///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package br.ufscar.dc.dsw.servlet;
//
//import br.ufscar.dc.dsw.dao.ClienteDAO;
//import br.ufscar.dc.dsw.locacao.bean.NovoClienteFormBean;
//import br.ufscar.dc.dsw.model.Cliente;
//import java.io.IOException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
///**
// *
// * @author bianca
// */
//@WebServlet(urlPatterns = {"/GravarClienteServlet"})
//public class GravarClienteServlet extends HttpServlet {
//	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//	throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		
//                NovoClienteFormBean ncfb = (NovoClienteFormBean) session.getAttribute("novoCliente");
//		session.removeAttribute("novoCliente");
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String nascimento_cliente = null;
//                nascimento_cliente = sdf.parse(ncfb.getNascimento_cliente);
//		try {
//			ClienteDAO clienteDAO = new ClienteDAO();
//			Cliente cliente = new Cliente();
//			
//			//TODO: COLOCAR AS VARIAVEIS E GETTERS E SETTERS CORRETAMENTE
//			cliente.setNome_cliente(ncfb.getNome_cliente());
//			cliente.setEmail_cliente(ncfb.getEmail_cliente());
//			cliente.setTelefone_cliente(ncfb.getTelefone_cliente());
//			cliente.setNascimento_cliente(nascimento_cliente);
//			cliente = clienteDAO.gravarCliente(cliente);
//			
//			request.setAttribute("mensagem", "Obrigado pelo cadastro!");
//			request.getRequestDispatcher("index.jsp").forward(request, response);
//		} 
//		catch (Exception e) {
//			e.printStackTrace();
//			request.setAttribute("mensagem", e.getLocalizedMessage());
//			request.getRequestDispatcher("erro.jsp").forward(request, response);
//		}
//	}
//}