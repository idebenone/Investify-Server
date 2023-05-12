package com.example.weinv.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.weinv.config.UserUserDetailsService;
import com.example.weinv.service.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private UserUserDetailsService detailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authHeader = request.getHeader("Authorization");
		String token = null;
		String email = null;
		if(authHeader != null && authHeader.startsWith("Bearer " )) {
			token = authHeader.substring(7);
			email = jwtService.extractEmail(token);
		}
		
		if(email != null && SecurityContextHolder.getContext().getAuthentication()==null ) {
			UserDetails details =  detailsService.loadUserByUsername(email);
			if(jwtService.validateToken(token, details)) {
				UsernamePasswordAuthenticationToken authenticationToken  = new UsernamePasswordAuthenticationToken(email,null, details.getAuthorities());
				authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}
		}
		filterChain.doFilter(request, response);
	}

}
