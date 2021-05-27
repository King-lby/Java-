package com.LBY.web.webmvc.entity;

import com.LBY.web.common.util.UrlUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.regex.Pattern;

/**

 * 其实这个类 就相当于 我们的handlermapping 封装请求参数和路径参数
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MethodDetail {
    // target method
    private Method method;
    // url parameter mapping
    private Map<String, String> urlParameterMappings;
    // url query parameter mapping
    private Map<String, String> queryParameterMappings;
    // json type http post request data
    private String json;

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Map<String, String> getUrlParameterMappings() {
        return urlParameterMappings;
    }

    public void setUrlParameterMappings(Map<String, String> urlParameterMappings) {
        this.urlParameterMappings = urlParameterMappings;
    }

    public Map<String, String> getQueryParameterMappings() {
        return queryParameterMappings;
    }

    public void setQueryParameterMappings(Map<String, String> queryParameterMappings) {
        this.queryParameterMappings = queryParameterMappings;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    /**
     * @Des 填充url的参数到占位符
     */
    public void build(String requestPath, Map<String, Method> requestMappings, Map<String, String> urlMappings) {
        requestMappings.forEach((key, value) -> {
            Pattern pattern = Pattern.compile(key);
            boolean b = pattern.matcher(requestPath).find();
            if (b) {
                this.setMethod(value);

                //根据初始化的时候就加载好的规则，来匹配对应的规则，有点难理解，举个例子说明一下，首先我们会在加载组件到时候把urlMappings 的规则放起来，当我们请求来的时候
                //再去匹配，大家如果还不懂，打个断点走走看哈
                String url = urlMappings.get(key);
                Map<String, String> urlParameterMappings = UrlUtil.getUrlParameterMappings(requestPath, url);
                this.setUrlParameterMappings(urlParameterMappings);
            }
        });
    }
}
