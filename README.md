# Tracing with zipkin and spring-cloud-sleuth


## Intro
This is a tutorial repo regarding examplify how distributed tracing can be accomplished using zipkin and a java springboot application using the springcloud-sleuth.
This repo contains three different springboot applications that talks to each other. This tutorial shows how zipkin and sleuth can visualize latency, log correlation on request and visualize a application dependency graph. All of these are extremely important and useful in a microservice architecture.

Communication for this example is as follows:

service-lookup -> service-middleman -> service-quote -> remote rest endpoint (aka internet)

## Requirements
* Java 1.8+
* Gradle (preferebly version 3.+)
* Docker (preferebly 1.12 and upwards)

## Setup
* Start docker container for zipkin: **gradle dockerzipkin**
* Build project: **gradle clean build**
* Start each java app: 
  - java -jar applications/service-lookup/build/libs/applications/service-lookup.jar
  - java -jar applications/service-quote/build/libs/applications/service-quote.jar
  - java -jar applications/service-middleman/build/libs/applications/service-middleman.jar
* Make a get request to trigger communication chain: **curl -XGET localhost:7000/lookup**
* View results in Zipkin in the browser: http://localhost:9411

## More info
I also wrote a [blog post](https://rogerwelin.github.io/zipkin/java/tracing/2017/08/06/distributed-tracing-with-zipkin.html) about this that does more in-depth
