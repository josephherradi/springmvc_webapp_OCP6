package springmvc.webapp.OCP6.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import springmvc.webapp.OCP6.entity.Utilisateur;

@WebFilter("/spots/showForm")
public class WebappFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	    Utilisateur loggedUser=(Utilisateur)((HttpServletRequest) request).getSession().getAttribute("theUser");

		HttpServletRequest req = (HttpServletRequest) request;
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
