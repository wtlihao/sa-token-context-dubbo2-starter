package cn.dev33.satoken;

import cn.dev33.satoken.context.second.SaTokenSecondContextCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description
 * User: wangtao
 * Date: 2024/6/18
 * Time: 17:30
 * Description: No Description
 */
@Configuration
public class CustomerSaTokenSecondContextCreatorConfig {
    @Bean
    public SaTokenSecondContextCreator saTokenSecondContextCreator() {
        return new CustomerSaTokenSecondContextCreator();
    }
}
