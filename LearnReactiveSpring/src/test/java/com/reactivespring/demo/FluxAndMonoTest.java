package com.reactivespring.demo;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class FluxAndMonoTest {
	@Test
	public void fluxTest() {
		Flux<String> stringflux = Flux.just("spring", "springboot", "ReactiveSpringBoot")

				// .concatWith(Flux.error(new RuntimeException("Exception Occured")))
				.log();

		stringflux.subscribe(System.out::println, (z) -> System.err.println(z));

	}

	@Test
	public void fluxTestwithError() {
		Flux<String> stringflux = Flux.just("spring", "springboot", "ReactiveSpringBoot")
				.concatWith(Flux.error(new RuntimeException("Exception Occured")))
				.log();

		StepVerifier.create(stringflux)
				.expectNext("spring", "springboot", "ReactiveSpringBoot")
				.expectError(RuntimeException.class)
				.verify();										//Verify is acts as like Oncomplete()
																//Here there is no oncomplete() because Error will occur
	
		
	}
	@Test
	public void fluxTestwithoutError() {
		Flux<String> stringflux = Flux.just("spring", "springboot", "ReactiveSpringBoot").
			
				log();

		StepVerifier.create(stringflux)
		.expectNext("spring", "springboot", "ReactiveSpringBoot")
		.verifyComplete();
	}
	
	@Test
	public void mono() {
		Mono<String> mono = Mono.just("value")
								.log();

		mono.subscribe(System.out::println);
	}
	@Test
	public void monoTest() {
		
		Mono<String> mono = Mono.just("Manikanta");
		StepVerifier.create(mono.log())
		.expectNext("Manikanta")
		.verifyComplete();
	}
	@Test
	public void monoTestwithError() {
		
		Mono<String> mono = Mono.just("Manikanta").error(new RuntimeException("Error occured"));
		StepVerifier.create(mono.log())
		.expectError(RuntimeException.class)
		.verify();
		
	}
										
}
