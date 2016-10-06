package com.jedlab.vertee;

import io.vertx.core.AbstractVerticle;

public class ServerVerticle extends AbstractVerticle
{

    
    @Override
    public void start() throws Exception
    {
     vertx.createHttpServer().requestHandler(rh->{
         try
        {
            Thread.sleep(2000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
         rh.response().end("Hello JEDLab");
     }).listen(8580);   
    }
    
    public static void main(String[] args)
    {
        Runner.runExample(ServerVerticle.class);
    }
    
    
}
