package com.jedlab.vertee;

import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.serviceproxy.ProxyHelper;

@ProxyGen
@VertxGen
public interface DatabaseService
{

    static DatabaseService create(Vertx vertx)
    {
        return new DatabaseServiceImpl();
    }

    static DatabaseService createProxy(Vertx vertx, String address)
    {
        return ProxyHelper.createProxy(DatabaseService.class, vertx, address);
    }

    void persist(JsonObject document, Handler<AsyncResult<io.vertx.core.json.JsonObject>> resultHandle);

}
