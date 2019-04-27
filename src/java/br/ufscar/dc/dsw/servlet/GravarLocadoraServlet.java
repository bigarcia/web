/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.servlet;

import br.ufscar.dc.dsw.dao.LocadoraDAO;
import br.ufscar.dc.dsw.locacao.bean.NovaLocadoraFormBean;
import br.ufscar.dc.dsw.model.Locadora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author bianca
 */
@WebServlet(urlPatterns = {"/GravarLocadoraServlet"})
public class GravarLocadoraServlet extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		HttpSession session = request.getSession();
		NovaLocadoraFormBean nlfb = (NovaLocadoraFormBean) session.getAttribute("novaLocadora");
		session.removeAttribute("novaLocadora");
		
		try {
			LocadoraDAO locadoraDAO = new LocadoraDAO();
                        String cnpj_locadora = nlfb.getCnpj_locadora();
                        String email_locadora = nlfb.getEmail_locadora();
                        String senha_locadora = nlfb.getSenha_locadora();
                        String nome_locadora = nlfb.getNome_locadora();
                        String cidade_locadora = nlfb.getCidade_locadora();
                        

                        Locadora locadora = new Locadora(cnpj_locadora, email_locadora, senha_locadora, nome_locadora, cidade_locadora);
			
                        /*Locadora locadora = new Locadora();
			locadora.setCpnj_locadora(nlfb.getCnpj_locadora());
			locadora.setEmail_locadora(nlfb.getEmail_locadora());
			locadora.setSenha_locadora(nlfb.getSenha_locadora());
			locadora.setNome_locadora(nlfb.getNome_locadora());
			locadora.setCidade_locadora(nlfb.getCidade_locadora());
			locadora = locadoraDAO.gravarLocadora(locadora);*/
			
			request.setAttribute("mensagem", "Obrigado pelo Cadastro!");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		} 
		catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("mensagem", e.getLocalizedMessage());
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
	}
}