package com.example.helloworld.resources;

import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.Timed;
import com.example.helloworld.HelloWorldConfiguration;
import com.example.helloworld.api.Saying;
import io.dropwizard.jersey.caching.CacheControl;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldResource.class);

    private final AtomicLong counter;
    private final HelloWorldConfiguration configuration;

    public HelloWorldResource(HelloWorldConfiguration configuration) {
        this.counter = new AtomicLong();
        this.configuration = configuration;
    }

    @GET
    @CacheControl(maxAge = 1, maxAgeUnit = TimeUnit.DAYS)
    public Saying sayHello(@QueryParam("name") Optional<String> name) {
        return new Saying(counter.incrementAndGet(), name.orElse(configuration.getContent()));
    }
}
