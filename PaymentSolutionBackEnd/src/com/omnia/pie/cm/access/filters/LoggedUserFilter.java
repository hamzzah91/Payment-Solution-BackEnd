package com.omnia.pie.cm.access.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import com.omnia.pie.cm.access.utils.LoggedUser;
import com.omnia.pie.cm.data.model.Users;

public class LoggedUserFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {


		HttpSession session = ((HttpServletRequest) req).getSession();
		Users user = (Users) session.getAttribute("loggedUser");
		if (user != null) {
			LoggedUser.init(user);
		}
		chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
