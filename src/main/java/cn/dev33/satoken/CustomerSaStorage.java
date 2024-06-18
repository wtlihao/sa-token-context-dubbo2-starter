package cn.dev33.satoken;

import cn.dev33.satoken.context.model.SaStorage;

/**
 * 自定义二级上下文Request
 * User: wangtao
 * Date: 2024/6/18
 * Time: 10:27
 * Description: No Description
 */
public class CustomerSaStorage implements SaStorage {


    @Override
    public Object getSource() {
        return null;
    }

    @Override
    public Object get(String key) {
        return null;
    }

    @Override
    public SaStorage set(String key, Object value) {
        return null;
    }

    @Override
    public SaStorage delete(String key) {
        return null;
    }
}
