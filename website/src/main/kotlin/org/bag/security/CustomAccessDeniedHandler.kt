package org.bag.security

import org.springframework.security.access.AccessDeniedException
import org.springframework.security.web.access.AccessDeniedHandler
import org.springframework.stereotype.Component

import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.io.IOException

@Component
class CustomAccessDeniedHandler : AccessDeniedHandler {

    override fun handle(request: HttpServletRequest, response: HttpServletResponse, ex: AccessDeniedException) {
        response.outputStream.print("Je moer")
        response.status = 403
        // response.sendRedirect("/my-error-page");
    }

}
