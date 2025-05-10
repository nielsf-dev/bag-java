//package org.bag.security
//
//import org.springframework.security.core.AuthenticationException
//import org.springframework.security.web.AuthenticationEntryPoint
//import org.springframework.stereotype.Component
//
//import jakarta.servlet.http.HttpServletRequest
//import jakarta.servlet.http.HttpServletResponse
//import java.io.IOException
//
///**
// * The Entry Point will not redirect to any sort of Login - it will return the 401
// */
//@Component
//class RestAuthenticationEntryPoint : AuthenticationEntryPoint {
//
//    override fun commence(
//            request: HttpServletRequest,
//            response: HttpServletResponse,
//            authException: AuthenticationException) {
//
//        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Mag niet")
//    }
//
//}
