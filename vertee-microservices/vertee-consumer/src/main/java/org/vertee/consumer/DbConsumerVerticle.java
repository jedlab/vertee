package org.vertee.consumer;

import com.jedlab.vertee.DatabaseService;
import com.jedlab.vertee.Runner;


import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonObject;
import io.vertx.servicediscovery.ServiceDiscovery;
import io.vertx.servicediscovery.ServiceDiscoveryOptions;
import io.vertx.servicediscovery.types.EventBusService;

public class DbConsumerVerticle extends AbstractVerticle
{

    @Override
    public void start() throws Exception
    {
        ServiceDiscovery discovery = ServiceDiscovery.create(vertx, new ServiceDiscoveryOptions(config()));
        vertx.createHttpServer().requestHandler(h->{
            
            EventBusService.getProxy(discovery, DatabaseService.class, ar ->
            {
                DatabaseService result = ar.result();
                if(result != null)
                {
                    result.persist(new JsonObject(), rh->{
                        System.out.println(rh.result());
                    });
                }
            });
            h.response().end("calling service");
        }).listen(8580);
    }

    public static void main(String[] args)
    {
        Runner.runClusteredExample(DbConsumerVerticle.class);
    }

}
