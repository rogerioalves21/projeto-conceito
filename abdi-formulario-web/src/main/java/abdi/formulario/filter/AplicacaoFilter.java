package abdi.formulario.filter;

import abdi.formulario.security.UsuarioLogado;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rogerio.Rodrigues
 */
public class AplicacaoFilter implements Filter {

    public AplicacaoFilter() {
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        // verifica se o usuario esta logado
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        UsuarioLogado usuario = (UsuarioLogado) req.getUserPrincipal();
        if (null == usuario) {
            resp.sendRedirect(req.getContextPath() + "/index.html");
        }
        
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

}
