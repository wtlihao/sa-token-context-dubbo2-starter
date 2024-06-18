package cn.dev33.satoken;

import cn.dev33.satoken.context.second.SaTokenSecondContext;
import cn.dev33.satoken.context.second.SaTokenSecondContextCreator;

/**
 * Description
 * User: wangtao
 * Date: 2024/6/18
 * Time: 10:43
 * Description: No Description
 */
public class CustomerSaTokenSecondContextCreator implements SaTokenSecondContextCreator {
    @Override
    public SaTokenSecondContext create() {
        return new SaTokenSecondContextForDubbo();
    }
}
