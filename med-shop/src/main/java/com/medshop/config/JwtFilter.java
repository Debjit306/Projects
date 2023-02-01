package com.medshop.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

public class JwtFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		final HttpServletResponse response1= (HttpServletResponse) response;
		final HttpServletRequest request1=(HttpServletRequest) request;
		final String authHeader= request1.getHeader("authorization");
		
		if("OPTIONS".equals(request1.getMethod()))
		{
			response1.setStatus(HttpServletResponse.SC_OK);
			chain.doFilter(request, response1);
		}
		else
		{
			if(authHeader==null || !authHeader.startsWith("Bearer "))
			{
				throw new ServletException("Invalid or missing Authorization.");
			}
			final String token = authHeader.substring(7);
			try {
				
				Claims claims=Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody();
				request1.setAttribute("claims", claims);
				
			}
			catch(final SignatureException e)
			{
				throw new ServletException("Invalid Token.");
			}
			
			chain.doFilter(request, response1);
		}

		
	}

}
