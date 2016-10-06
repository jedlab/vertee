package com.jedlab.vertee;

import io.vertx.core.AbstractVerticle;
import io.vertx.servicediscovery.Record;
import io.vertx.servicediscovery.ServiceDiscovery;
import io.vertx.servicediscovery.ServiceDiscoveryOptions;
import io.vertx.servicediscovery.types.EventBusService;
import io.vertx.serviceproxy.ProxyHelper;

import com.jedlab.vertee.DatabaseService;
import com.jedlab.vertee.Runner;

public class DatabaseVerticle extends AbstractVerticle
{

    public static void main(String[] args)
    {
        Runner.runClusteredExample(DatabaseVerticle.class);
    }


    @Override
    public void start() throws Exception
    {
        DatabaseService service = new DatabaseServiceImpl();
        ProxyHelper.registerService(DatabaseService.class, vertx, service, "db.service");
        Record r = EventBusService.createRecord("database", // The service name
                "db.service", // the service address,
                DatabaseService.class // the service interface as string
                );
        ServiceDiscovery discovery = ServiceDiscovery.create(vertx, new ServiceDiscoveryOptions(config()));
        discovery.publish(r, rh ->
        {
            if (rh.succeeded())
            {
                System.out.println(r.getName());
            }
            else
            {
                System.out.println("fail");
            }
        });

    }

}
