package com.jedlab.vertee;

import io.vertx.core.AbstractVerticle;

public class MessageConsumer extends AbstractVerticle
{

    @Override
    public void start() throws Exception
    {
        vertx.eventBus().consumer("my-address").handler(h->{
            System.out.println(h.body());
        });
    }

    public static void main(String[] args)
    {
        Runner.runClusteredExample(MessageConsumer.class);
    }

}
