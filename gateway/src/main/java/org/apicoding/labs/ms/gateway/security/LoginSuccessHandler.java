package org.apicoding.labs.ms.gateway.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Thomas VAUTRIN on 24/02/2017.
 */
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response, final Authentication authentication)
            throws IOException, ServletException {

        super.onAuthenticationSuccess(request, response, authentication);

        HttpSession session = request.getSession(true);

        try {
            System.err.println("test");
            /*if (CurrentUser.isUserInRole("USER")) {
                session.setAttribute("Flag", "user");
            }*/
        } catch (Exception e) {
            logger.error("Error in getting User()", e);
        }
    }

}
