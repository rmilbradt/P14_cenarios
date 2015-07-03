package br.ufsm.csi.p14.spring;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by politecnico on 26/05/2015.
 */
public class AutenticacaoInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (request.getRequestURI().endsWith(".priv")) {
            Object usuario = request.getSession().getAttribute("usuario");
            if (usuario == null) {
                response.sendRedirect("login.htm");
                return false;
            }
        }

        System.out.println(request.getPathInfo());
        return true;
    }
}
