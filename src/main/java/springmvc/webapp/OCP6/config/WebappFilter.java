package springmvc.webapp.OCP6.config;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class WebappFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	private static final Collection<String> ALLOWED_PATHS = Arrays.asList("/account", "/account/login",
			"/account/logout", "/account/registrationForm", "/list", "/spots/searchSpots");

	private static final Collection<String> ALLOWED_PATHS_USERLOGGED = Arrays.asList("showForm",
			"updateForm", "delete", "saveForm", "mylist","toposlist", "/voies/list","userlist","requestlist");

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession(false);
		String path = request.getRequestURI().substring(request.getContextPath().length()).replaceAll("[/]+$", "");
		boolean loggedIn = (session != null && session.getAttribute("user") != null);
		Optional<String> MatchunLogged = ALLOWED_PATHS.stream().filter(path::contains)
				.max(Comparator.comparingInt(String::length));
		
		boolean allowedPath = MatchunLogged.isPresent();
		Optional<String> MatchLogged = ALLOWED_PATHS_USERLOGGED.stream().filter(path::contains)
				.max(Comparator.comparingInt(String::length));
		
		boolean allowedPathUserLogged = MatchLogged.isPresent();;

		if (allowedPath) {
			chain.doFilter(req, res);
		} else if (loggedIn && allowedPathUserLogged) {
			chain.doFilter(req, res);

		} else {
			response.sendRedirect(request.getContextPath() + "/account");
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
