package com.omnia.pie.cm.access.filters;

import java.io.IOException;

import javax.faces.application.ViewExpiredException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionValidationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException, ViewExpiredException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
		
	    HttpSession session = request.getSession();
	   // System.err.println("loggedFlag ? :" + session.getAttribute("loggedFlag"));
	   if (session != null && session.getAttribute("loggedFlag") != null && ((String)session.getAttribute("loggedFlag")).equals("true")) 
	    {

    	System.err.println("session is not null");

	    }
	    else
	    {
	    	//System.err.println("session is null ,sorry");
	      /* try
	        {
	        	System.err.println(request.getContextPath());
	        	response.sendRedirect(request.getContextPath()+"/index.jsp"); 
	        	//ec.redirect(ec.getApplicationContextPath());
	        }
	        catch(IOException e)
	        {
	        	System.err.println("exception");
	            // log exception...
	        }*//*
	    	   throw new ViewExpiredException();*/

	     }
       chain.doFilter(req, res);

    }

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

    // ...
}
