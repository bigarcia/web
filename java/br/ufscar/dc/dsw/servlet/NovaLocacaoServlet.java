package br.ufscar.dc.dsw.servlet;

import br.ufscar.dc.dsw.locacao.bean.NovaLocacaoFormBean;
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
@WebServlet(urlPatterns = {"/novolocacao"})
public class NovaLocacaoServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    public void destroy() {
    }

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException, IllegalAccessException, InvocationTargetException, InvocationTargetException {

        NovaLocacaoFormBean nlofb = new NovaLocacaoFormBean();
        BeanUtils.populate(nlofb,request.getParameterMap());
        request.getSession().setAttribute("novaLocacao", nlofb);
        List<String> mensagens = nlofb.validar();
        if (mensagens.isEmpty()) {
            request.getRequestDispatcher("confirmaLocacao.jsp").forward(request, response);
        } else {
            request.setAttribute("mensagens", mensagens);
            request.getRequestDispatcher("novaLocacao.jsp").forward(request, response);
        }

    }
}
