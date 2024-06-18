# 解决sa-token无法在RPC环境使用StpUtil类的问题

## 1. 问题描述
例如在RPC接口中使用StpUtil.xxx方法，会报如下错误：“非Web上下文无法获取Request” 类似的错误。

## 2.源码分析
- 定位问题
```java
public static HttpServletRequest getRequest() {
    ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    if (servletRequestAttributes == null) {
        throw new SaTokenException("非Web上下文无法获取Request");
    }
    return servletRequestAttributes.getRequest();
}
```
- 找到上一层调用的位置
```java
public static SaRequest getRequest() {
    return SaManager.getSaTokenContextOrSecond().getRequest();
}
```
这里可以发现一个点：SaManager.getSaTokenContextOrSecond()方法是返回一个上下文对象。点进去上下文接口发现有三个实现
- SaTokenContextDefaultImpl
- SaTokenContextForSpring
- SaTokenContextForThreadLocal
- 并且发现还有一个二级上下文，是个空接口
### 2.1 继续跟踪getSaTokenContextOrSecond方法
```java
public static SaTokenContext getSaTokenContextOrSecond() {

    // s1. 一级Context可用时返回一级Context
    if (saTokenContext != null) {
        if (saTokenSecondContext == null || saTokenContext.isValid()) {
            // 因为 isValid 是一个耗时操作，所以此处假定：二级Context为null的情况下无需验证一级Context有效性 
            // 这样可以提升6倍左右的上下文获取速度 
            return saTokenContext;
        }
    }

    // s2. 一级Context不可用时判断二级Context是否可用 
    if (saTokenSecondContext != null && saTokenSecondContext.isValid()) {
        return saTokenSecondContext;
    }

    // s3. 都不行，就返回默认的 Context 
    return SaTokenContextDefaultImpl.defaultContext;
}
```
可以发现如果二级上下文实现了且是有效的话，就返回二级上下文，反之使用一级上下文，否则就返回默认的上下文。

# 3.解决方案
实现SaTokenSecondContext接口，并实现isValid方法，返回true即可。并创建自定义的Request、Response等对象。最后实现一个CustomerSaTokenSecondContextCreator接口注入Spring容器。具体看代码结构

