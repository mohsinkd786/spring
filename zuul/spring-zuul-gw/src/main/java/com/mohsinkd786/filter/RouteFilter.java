package com.mohsinkd786.filter;

import com.netflix.ribbon.proxy.annotation.Http;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.util.ZuulRuntimeException;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;

public class RouteFilter extends ZuulFilter {

    private Logger LOG = LoggerFactory.getLogger(RouteFilter.class);

    @Override
    public String filterType() {
        return "route";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        authenticate(context);

        LOG.info("Route Filter was triggered ");
        return null;
    }

    public boolean authenticate(RequestContext context) throws ZuulException{
        String token = context.getRequest().getHeader("token");
        LOG.info("Route Filter :: Token "+token);
        if(!token.equalsIgnoreCase("1234")){

            context.addZuulResponseHeader("Content-Type","application/json");
            context.setResponseStatusCode(HttpStatus.FORBIDDEN.value());
            context.setResponseBody("{ \"message\": \"Invalid or no token specified\", \"errorCode\":"+ HttpStatus.FORBIDDEN.value()+ "}");
            context.setSendZuulResponse(false);

            return false;
            //throw new ZuulException(new Exception("Invalid or no token specified"), HttpStatus.FORBIDDEN.value(),"Invalid or no token specified");
        }
        else {
            return true;
        }
    }
}
