package com.jedlab.vertee;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

public class DatabaseServiceImpl implements DatabaseService
{

    @Override
    public void persist(JsonObject document, Handler<AsyncResult<JsonObject>> resultHandle)
    {
        System.out.println("Persist to database");
        JsonObject result = document.copy();
        result.put("result", "persisted");
        resultHandle.handle(Future.succeededFuture(result));
    }

}
