package com.reactivespring.demo.HandlerFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class SamplerRouterFunction {
@Bean
public RouterFunction<ServerResponse> route(SampleHandlerFunction shf){
	return RouterFunctions
			.route(GET("/functional/mono").and(accept(MediaType.APPLICATION_JSON)), shf::flux);
				
					
	
}
}
