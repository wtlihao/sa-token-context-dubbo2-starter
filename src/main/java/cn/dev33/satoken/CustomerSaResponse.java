package cn.dev33.satoken;

import cn.dev33.satoken.context.model.SaResponse;

/**
 * 自定义二级上下文Request
 * User: wangtao
 * Date: 2024/6/18
 * Time: 10:27
 * Description: No Description
 */
public class CustomerSaResponse implements SaResponse {

    @Override
    public Object getSource() {
        return null;
    }

    @Override
    public SaResponse setStatus(int sc) {
        return null;
    }

    @Override
    public SaResponse setHeader(String name, String value) {
        return null;
    }

    @Override
    public SaResponse addHeader(String name, String value) {
        return null;
    }

    @Override
    public Object redirect(String url) {
        return null;
    }
}
