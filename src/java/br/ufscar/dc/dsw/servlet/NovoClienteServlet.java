package br.ufscar.dc.dsw.servlet;

import br.ufscar.dc.dsw.locacao.bean.NovoClienteFormBean;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author Bianca
 */
@WebServlet(urlPatterns = {"/NovoClienteServlet"})
public class NovoClienteServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    public void destroy() {
    }

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException, IllegalAccessException, InvocationTargetException {

        //request.setCharacterEnconding("UTF-8");
        NovoClienteFormBean ncfb = new NovoClienteFormBean();
        BeanUtils.populate(ncfb, request.getParameterMap());
        request.getSession().setAttribute("novoCliente.jsp", ncfb);
        List<String> mensagens = ncfb.validar();
        if (mensagens.isEmpty()) {
            request.getRequestDispatcher("confirmaCliente.jsp").forward(request, response);
        } else {
            request.setAttribute("mensagens", mensagens);
            request.getRequestDispatcher("novoCliente.jsp").forward(request, response);
        }

    }
}
