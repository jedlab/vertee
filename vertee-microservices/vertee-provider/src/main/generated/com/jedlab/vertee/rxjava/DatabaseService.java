/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.jedlab.vertee.rxjava;

import java.util.Map;
import rx.Observable;
import io.vertx.rxjava.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;


public class DatabaseService {

  final com.jedlab.vertee.DatabaseService delegate;

  public DatabaseService(com.jedlab.vertee.DatabaseService delegate) {
    this.delegate = delegate;
  }

  public Object getDelegate() {
    return delegate;
  }

  public static DatabaseService create(Vertx vertx) { 
    DatabaseService ret = DatabaseService.newInstance(com.jedlab.vertee.DatabaseService.create((io.vertx.core.Vertx)vertx.getDelegate()));
    return ret;
  }

  public static DatabaseService createProxy(Vertx vertx, String address) { 
    DatabaseService ret = DatabaseService.newInstance(com.jedlab.vertee.DatabaseService.createProxy((io.vertx.core.Vertx)vertx.getDelegate(), address));
    return ret;
  }

  public void persist(JsonObject document, Handler<AsyncResult<JsonObject>> resultHandle) { 
    delegate.persist(document, resultHandle);
  }

  public Observable<JsonObject> persistObservable(JsonObject document) { 
    io.vertx.rx.java.ObservableFuture<JsonObject> resultHandle = io.vertx.rx.java.RxHelper.observableFuture();
    persist(document, resultHandle.toHandler());
    return resultHandle;
  }


  public static DatabaseService newInstance(com.jedlab.vertee.DatabaseService arg) {
    return arg != null ? new DatabaseService(arg) : null;
  }
}
