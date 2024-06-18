package cn.dev33.satoken;


import cn.dev33.satoken.context.model.SaRequest;
import cn.dev33.satoken.context.model.SaResponse;
import cn.dev33.satoken.context.model.SaStorage;
import cn.dev33.satoken.context.second.SaTokenSecondContext;

/**
 * sa-token二级上下文 Dubbo实现
 * User: wangtao
 * Date: 2024/6/18
 * Time: 10:29
 * Description: No Description
 */
public class SaTokenSecondContextForDubbo implements SaTokenSecondContext {
    @Override
    public SaRequest getRequest() {
        return new CustomerSaRequest();
    }

    @Override
    public SaResponse getResponse() {
        return new CustomerSaResponse();
    }

    @Override
    public SaStorage getStorage() {
        return new CustomerSaStorage();
    }

    @Override
    public boolean matchPath(String pattern, String path) {
        return false;
    }

    @Override
    public boolean isValid() {
        return true;
    }
}
