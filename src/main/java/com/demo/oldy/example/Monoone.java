package com.demo.oldy.example;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Monoone {

    public static void main(String[] args) {
        Mono<String> mono = Mono.just("Hello");
        mono.subscribe(System.out::println);

        Flux<Integer> flux = Flux.just(1, 2, 3);
        flux.subscribe(System.out::println);

    }
}
