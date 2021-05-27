package com.LBY.web.webmvc.hander;

import io.netty.handler.codec.http.FullHttpRequest;

/**
 *  处理从Netty出来的通用处理接口
 */
public interface RequestHandler {
    Object handle(FullHttpRequest fullHttpRequest) throws Exception;
}
