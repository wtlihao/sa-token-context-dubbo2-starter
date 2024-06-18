package cn.dev33.satoken;

import cn.dev33.satoken.context.model.SaRequest;

/**
 * 自定义二级上下文Request
 * User: wangtao
 * Date: 2024/6/18
 * Time: 10:27
 * Description: No Description
 */
public class CustomerSaRequest implements SaRequest {

    @Override
    public Object getSource() {
        return null;
    }

    @Override
    public String getParam(String name) {
        return "";
    }

    @Override
    public String getHeader(String name) {
        return "";
    }

    @Override
    public String getCookieValue(String name) {
        return "";
    }

    @Override
    public String getRequestPath() {
        return "";
    }

    @Override
    public String getUrl() {
        return "";
    }

    @Override
    public String getMethod() {
        return "";
    }
}
