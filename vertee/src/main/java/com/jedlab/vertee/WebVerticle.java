package com.jedlab.vertee;

import io.vertx.core.AbstractVerticle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class WebVerticle extends AbstractVerticle
{

    @Override
    public void start() throws Exception
    {
        System.out.println("Start");
        //
        getByJava();
//        vertx.createHttpClient().getNow(8580, "localhost", "", response ->
//        {
//            response.bodyHandler(System.out::println);
//        });
        //
        System.out.println("End");
    }

    public void getByJava() throws IOException
    {
        new Thread(new Runnable() {
            
            @Override
            public void run()
            {
                try
                {
                    
                    URL site = new URL("http://localhost:8580/");
                    BufferedReader in = new BufferedReader(new InputStreamReader(site.openStream()));
                    
                    String inputLine;
                    while ((inputLine = in.readLine()) != null)
                    {
                        System.out.println(inputLine);
                    }
                    in.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void main(String[] args)
    {
        Runner.runExample(WebVerticle.class);
    }

}
