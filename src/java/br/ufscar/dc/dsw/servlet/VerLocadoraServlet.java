package br.ufscar.dc.dsw.servlet;

import br.ufscar.dc.dsw.dao.LocadoraDAO;
import br.ufscar.dc.dsw.model.Locadora;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/VerLocadoraServlet"})
public class VerLocadoraServlet extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String cidade_locadora = request.getParameter("cidade_locadora");
		List<Locadora> todasLocadoras;
		try {
			LocadoraDAO locadoraDAO = new LocadoraDAO();
			if (cidade_locadora == null) {
				todasLocadoras = locadoraDAO.listarTodasLocadoras();
			} 
			else {
				todasLocadoras = locadoraDAO.listarTodasPorCidade(cidade_locadora);
			}
			request.setAttribute("listaLocadora", todasLocadoras);
			request.getRequestDispatcher("listaLocadora.jsp").forward(request, response);
		} 
		catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("mensagem", e.getLocalizedMessage());
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
	}
}
