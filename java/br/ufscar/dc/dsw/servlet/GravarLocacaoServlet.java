///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package br.ufscar.dc.dsw.servlet;
//
//import br.ufscar.dc.dsw.dao.ClienteDAO;
//import br.ufscar.dc.dsw.dao.LocacaoDAO;
//import br.ufscar.dc.dsw.locacao.bean.NovaLocacaoFormBean;
//import br.ufscar.dc.dsw.model.Cliente;
//import br.ufscar.dc.dsw.model.Locacao;
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
//@WebServlet(urlPatterns = {"/GravarLocacaoServlet"})
//public class GravarLocacaoServlet extends HttpServlet {
//	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//	throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		
//                NovaLocacaoFormBean nlfb = (NovaLocacaoFormBean) session.getAttribute("novaLocacao");
//		session.removeAttribute("novaLocacao");
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String nascimento_cliente = null;
//		try {
//                    Date data_dia = sdf.parse(nlfb.getData_dia());
//		} 
//		catch (ParseException e) {
//			request.setAttribute("mensagem", e.getLocalizedMessage());
//			request.getRequestDispatcher("erro.jsp").forward(request, response);
//			}
//		try {
//			LocacaoDAO locacacaoDAO = new LocacaoDAO();
//			Locacao locacao = new Locacao();
//			
//			//TODO: COLOCAR AS VARIAVEIS E GETTERS E SETTERS CORRETAMENTE
//			locacao.setData_dia(nlfb.getData_locacao());
//			locacao.setId_locacao(nlfb.getId_locacao());
//			locacao.setCpf_cliente(nlfb.getCpf_cliente());
//			locacao.setCnpj_locadora(nlfb.getCnpj_locadora);
//			locacao = locacaoDAO.gravarLocacao(locacao);
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