package com.greeting.grpc.server;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {
    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        HelloResponse response = HelloResponse
                .newBuilder()
                .setGreeting("Hello from GRPC! Welcome " + request.getFirstName() + " " + request.getLastName())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
