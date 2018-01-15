# Spring Boot JMS Sample

A very simple JMS client application 

Place a message on the queue at the url /test
Responds with message + timestamp if no error occurs placing a message on the queue. Default message is the word 'hi'. 

In the logs you can see the output of the message by the consumer and the receiver

Works with 

* ActiveMQ

## Running the Application

Deploy on Openshift with the base Red Hat OpenJDK 8 image

Configure these parameters:

* BROKER_URL: (ex. tcp://amq-broker:61616)
* AMQ_USER
* AMQ_PASSWORD
* QUEUE_NAME

Ideally the last 2 will be configured in a secret

The main configuration for the samples is in `application.properties`.


