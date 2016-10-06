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

package com.jedlab.vertee.groovy;
import groovy.transform.CompileStatic
import io.vertx.lang.groovy.InternalHelper
import io.vertx.core.json.JsonObject
import io.vertx.groovy.core.Vertx
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
@CompileStatic
public class DatabaseService {
  private final def com.jedlab.vertee.DatabaseService delegate;
  public DatabaseService(Object delegate) {
    this.delegate = (com.jedlab.vertee.DatabaseService) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  public static DatabaseService create(Vertx vertx) {
    def ret = InternalHelper.safeCreate(com.jedlab.vertee.DatabaseService.create(vertx != null ? (io.vertx.core.Vertx)vertx.getDelegate() : null), com.jedlab.vertee.groovy.DatabaseService.class);
    return ret;
  }
  public static DatabaseService createProxy(Vertx vertx, String address) {
    def ret = InternalHelper.safeCreate(com.jedlab.vertee.DatabaseService.createProxy(vertx != null ? (io.vertx.core.Vertx)vertx.getDelegate() : null, address), com.jedlab.vertee.groovy.DatabaseService.class);
    return ret;
  }
  public void persist(Map<String, Object> document, Handler<AsyncResult<Map<String, Object>>> resultHandle) {
    delegate.persist(document != null ? new io.vertx.core.json.JsonObject(document) : null, resultHandle != null ? new Handler<AsyncResult<io.vertx.core.json.JsonObject>>() {
      public void handle(AsyncResult<io.vertx.core.json.JsonObject> ar) {
        if (ar.succeeded()) {
          resultHandle.handle(io.vertx.core.Future.succeededFuture((Map<String, Object>)InternalHelper.wrapObject(ar.result())));
        } else {
          resultHandle.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
  }
}
