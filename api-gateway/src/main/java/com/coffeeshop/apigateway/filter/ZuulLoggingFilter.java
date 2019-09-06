package com.coffeeshop.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ZuulLoggingFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public String filterType() {
        return "pre" ;//Filter should happen before the request is executed. To filter only error request set "error"
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;//Execute in every filter
    }

    @Override
    public Object run() throws ZuulException {

        final HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        logger.info("Request -> {} request uri -> {}",request,request.getRequestURI());
        return null;
    }
}
