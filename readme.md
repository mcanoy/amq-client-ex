# Spring Boot JMS Sample

A very simple JMS client application 

Place a message on the queue at the url /test
Responds with success if no error occurs placing a message on the queue. The message is the word 'hi' with a timestamp

In the logs you can see the output of the message by the consumer and the receiver

Works with 

* ActiveMQ

## Running the application

Deploy on Openshift with the base Red Hat OpenJdk 8 image

Configure these parameters:

BROKER_URL: (ex. tcp://amq-broker:61616)
AMQ_USER
AMQ_PASSWORD

Ideally the last 2 will be configured in a secret

The main configuration for the samples is in `application.properties`.


