package com.hemika.configuration;


import com.hemika.controller.CreateUserRes;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api")
@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig(){
        register(CORSFilter.class);
        register(CreateUserRes.class);
        packages("com.hemika.controller");
        packages("com.hemika.controller.filter");
    }

}
