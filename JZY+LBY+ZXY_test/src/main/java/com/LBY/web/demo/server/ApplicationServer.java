package com.LBY.web.demo.server;

import com.LBY.web.server.HttpServer;
import com.LBY.web.webmvc.factory.DispatcherMethodMapper;


public class ApplicationServer {
    public static void main(String[] args) throws Exception {
        DispatcherMethodMapper.loadRoutes();

        // 8091为启动端口,启动Netty
        HttpServer server = new HttpServer(8091);
        server.start();
    }
}