//package org.bag.security
//
//import org.springframework.security.core.Authentication
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler
//import org.springframework.security.web.savedrequest.HttpSessionRequestCache
//import org.springframework.security.web.savedrequest.RequestCache
//import org.springframework.security.web.savedrequest.SavedRequest
//import org.springframework.stereotype.Component
//import org.springframework.util.StringUtils
//
//import jakarta.servlet.ServletException
//import jakarta.servlet.http.HttpServletRequest
//import jakarta.servlet.http.HttpServletResponse
//import java.io.IOException
//
//@Component
//class MySavedRequestAwareAuthenticationSuccessHandler : SimpleUrlAuthenticationSuccessHandler() {
//
//    private var requestCache: RequestCache = HttpSessionRequestCache()
//
//    override fun onAuthenticationSuccess(request: HttpServletRequest, response: HttpServletResponse, authentication: Authentication) {
//        val savedRequest = requestCache.getRequest(request, response)
//
//        if (savedRequest == null) {
//            clearAuthenticationAttributes(request)
//            return
//        }
//        val targetUrlParameter = targetUrlParameter
//        if (isAlwaysUseDefaultTargetUrl || targetUrlParameter != null && StringUtils.hasText(request.getParameter(targetUrlParameter))) {
//            requestCache.removeRequest(request, response)
//            clearAuthenticationAttributes(request)
//            return
//        }
//
//        clearAuthenticationAttributes(request)
//    }
//
//    fun setRequestCache(requestCache: RequestCache) {
//        this.requestCache = requestCache
//    }
//}
