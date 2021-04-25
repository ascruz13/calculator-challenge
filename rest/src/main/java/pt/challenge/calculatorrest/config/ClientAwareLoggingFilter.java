package pt.challenge.calculatorrest.config;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Component
public class ClientAwareLoggingFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String uniqueId = UUID.randomUUID().toString();
		
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		httpResponse.setHeader("UUID", uniqueId);
		
		try {
			MDC.put("UUID", uniqueId);
			
			chain.doFilter(request, response);
		}
		finally {
			MDC.remove("UUID");
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {}	
	
	public void destroy() {}

}
