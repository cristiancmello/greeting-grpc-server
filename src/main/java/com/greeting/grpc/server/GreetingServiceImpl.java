package com.greeting.grpc.server;

import io.grpc.stub.StreamObserver;

import net.devh.boot.grpc.server.service.GrpcService;

import com.greeting.grpc.gen.proto.GreetingServiceGrpc;
import com.greeting.grpc.gen.proto.HelloRequest;
import com.greeting.grpc.gen.proto.HelloResponse;

@GrpcService
public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {
    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        String name = request.getName();
        String dog = request.getDog();
        String greeting = String.format("%s have a dog called %s", name, dog);
        boolean loveDog = request.getILoveMyDog();

        if (loveDog) {
            greeting += " and ❤️ your dog";
        }

        HelloResponse response = HelloResponse
                .newBuilder()
                .setGreeting(greeting)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
