package com.reactivespring.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
@WebFluxTest
public class FluxAndMonoControllerTest {
@Autowired
WebTestClient webclient;       //  Test rest template fo blocking in MVC//Web TEst clientNon Blocking client
@Test
public void mono_Approach() {
	Integer value = 123;
	webclient.get().uri("/mono").accept(MediaType.TEXT_EVENT_STREAM).exchange()
	.expectStatus().is2xxSuccessful().
	expectBody();
	;
}
@Test
public void flux_approach() {
Flux<Integer> integerFlux=	webclient.get().uri("/flux")
	.accept(MediaType.TEXT_EVENT_STREAM)	.exchange()
	.expectStatus().is2xxSuccessful()
	.returnResult(Integer.class).getResponseBody();

StepVerifier.create(integerFlux)
.expectSubscription()
.expectNext(1,2,3,4,5)
.verifyComplete();
}


//@Test
//public void flux_approach2() {
//	
//	Flux<String> stringFlux= webclient.get().uri("/fluxstream")
//	.accept(MediaType.APPLICATION_JSON)
//	.exchange()
//	.expectStatus().is2xxSuccessful().
//	returnResult(String.class).getResponseBody();
//	
//	StepVerifier.create(stringFlux)
//	.expectSubscription()
//	.expectNext("Mani","Baswa","info")
//	
//	.verifyComplete();
//	
//}


}
