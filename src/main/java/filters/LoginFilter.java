package filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String url = req.getRequestURI();
        if(url.endsWith(".js") || url.endsWith(".css") || url.endsWith(".TTF")){
            filterChain.doFilter(req, resp);
            return;

        }


        Object isLogin = ((HttpServletRequest) servletRequest).getSession().getAttribute("isLogin");
        if (isLogin == null && url.endsWith("/login")){
            filterChain.doFilter(req, resp);
            return;


        }


        if(isLogin != null){
            filterChain.doFilter(req, resp);
            return;

        }

        resp.sendRedirect("/login");

    }

    @Override
    public void destroy() {

    }
}
