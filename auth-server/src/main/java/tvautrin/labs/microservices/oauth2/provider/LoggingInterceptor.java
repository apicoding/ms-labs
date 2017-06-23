package tvautrin.labs.microservices.oauth2.provider;

import java.util.Collection;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Thomas VAUTRIN on 13/02/2017.
 */
public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.err.println("---[AUTHSERVER]---");
        System.err.println("--- preHandle - Request---" + request.getRequestURL().toString());
        Enumeration<String> headers = request.getHeaderNames();
        if (headers != null) {
            while (headers.hasMoreElements()) {
                String headerName = headers.nextElement();
                System.err.println(headerName + " : " + request.getHeader(headerName));
            }
        }
        System.err.println("--- preHandle - Response---");
        Collection<String> responseHeaderNames = response.getHeaderNames();
        if (responseHeaderNames != null) {
            for (String respHeader : responseHeaderNames) {
                System.err.println(respHeader + " : " + response.getHeader(respHeader));
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.err.println("---[AUTHSERVER]---");
        System.err.println("--- postHandle - Request---");
        Enumeration<String> headers = request.getHeaderNames();
        if (headers != null) {
            while (headers.hasMoreElements()) {
                String headerName = headers.nextElement();
                System.err.println(headerName + " : " + request.getHeader(headerName));
            }
        }
        System.err.println("--- postHandle - Response---");
        Collection<String> responseHeaderNames = response.getHeaderNames();
        if (responseHeaderNames != null) {
            for (String respHeader : responseHeaderNames) {
                System.err.println(respHeader + " : " + response.getHeader(respHeader));
            }
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.err.println("---[AUTHSERVER]---");
        System.err.println("--- afterCompletion - Request---");
        Enumeration<String> headers = request.getHeaderNames();
        if (headers != null) {
            while (headers.hasMoreElements()) {
                String headerName = headers.nextElement();
                System.err.println(headerName + " : " + request.getHeader(headerName));
            }
        }
        System.err.println("--- afterCompletion - Response---");
        Collection<String> responseHeaderNames = response.getHeaderNames();
        if (responseHeaderNames != null) {
            for (String respHeader : responseHeaderNames) {
                System.err.println(respHeader + " : " + response.getHeader(respHeader));
            }
        }
    }
}
