package com.jedlab.vertee;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

public class MessageProducer extends AbstractVerticle
{

    
    @Override
    public void start() throws Exception
    {
        Router router = Router.router(vertx);
        Route route = router.route("/pub").handler(this::handleRequest);        
        vertx.createHttpServer().requestHandler(router::accept).listen(8580);
        System.out.println("server started at port 8580");
    }
    
    public void handleRequest(RoutingContext rc)
    {
        vertx.eventBus().publish("my-address", "Hi event bus");
        rc.response().end("even has been published");
    }
    
    public static void main(String[] args)
    {
        Runner.runClusteredExample(MessageProducer.class);
    }
    
    
}
