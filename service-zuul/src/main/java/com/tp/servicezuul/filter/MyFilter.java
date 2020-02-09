package com.tp.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * FileName: MyFilter
 * Author:   TP
 * Date:     2020-02-08 11:02
 * Description: Zuul自定义过滤器
 */
@Component
public class MyFilter extends ZuulFilter {
    private static Logger logger = LoggerFactory.getLogger(MyFilter.class);

    /**
     * 指定自定义过滤器的类型，可选值为：pre、post、routing、error 4个
     *
     * @return 过滤器的类型
     */
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    /**
     * 指定自定义过滤器的顺序，返回一个整数，数值越小，优先级越高
     *
     * @return 过滤器的顺序
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 指定自定义过滤器是否执行过滤逻辑，如果为true则执行run()方法，如果为false则不执行run()方法
     *
     * @return 自定义过滤器是否执行过滤逻辑
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 指定自定义过滤器具体的过滤逻辑，本例校验请求中是否有token
     *
     * @return Object
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        Object token = request.getParameter("token");
        if (token == null) {
            logger.warn(">>>>MyFilter check token: ERROR");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
            try {
                ctx.getResponse().getWriter().write("sorry, token can not be empty");
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
            return null;
        }
        logger.info(">>>>MyFilter check token: OK");
        return null;
    }
}
