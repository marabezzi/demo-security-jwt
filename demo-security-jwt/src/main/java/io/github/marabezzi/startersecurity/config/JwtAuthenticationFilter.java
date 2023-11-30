package io.github.marabezzi.startersecurity.config;

import java.io.IOException;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Configuration
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	
	@Override
	protected void doFilterInternal(
			@NonNull	HttpServletRequest request,
			@NonNull	HttpServletResponse response,
			@NonNull	FilterChain filterChain) 
			throws ServletException, IOException {
					
 }

}
