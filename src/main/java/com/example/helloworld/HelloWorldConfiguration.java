package com.example.helloworld;

import io.dropwizard.core.Configuration;

public class HelloWorldConfiguration extends Configuration {
    private String content = "Stranger";

    public String getContent() {
        return content;
    }
}
