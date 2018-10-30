package news.web.filter;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestFilter extends OncePerRequestFilter {

	public String filter(HttpServletRequest request, String input) {
		if (StringUtils.isNotEmpty(input)) {
            input = input.trim();
		}
		return input;
	}

	@Override
	protected void doFilterInternal(final HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {

		chain.doFilter(new HttpServletRequestWrapper(request) {
			@Override
			public String getParameter(String name) {
				String value = super.getParameter(name);
				return filter(this, value);
			}

			@Override
			public String[] getParameterValues(String name) {
				String[] values = super.getParameterValues(name);
				if (values == null) {
					return null;
				}
				for (int i = 0; i < values.length; i++) {
					values[i] = filter(this, values[i]);
				}
				return values;
			}
		}, response);
	}
}