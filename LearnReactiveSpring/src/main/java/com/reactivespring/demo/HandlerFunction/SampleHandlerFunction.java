package com.reactivespring.demo.HandlerFunction;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
//for Functional web end point we are not at all using @rest controller 
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Component
public class SampleHandlerFunction {
public Mono<ServerResponse> flux(ServerRequest serverrequest){
	
	return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(Flux.just(1,2,3,4).log(),Integer.class);
}
}
