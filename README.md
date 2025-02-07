# Receipt Processor

A simple receipt-processor webservice. An implementation of the API described 
[here](https://github.com/fetch-rewards/receipt-processor-challenge).
The API schema can be found in 
[api.yml](https://github.com/fetch-rewards/receipt-processor-challenge/blob/main/api.yml).

NOTE: The API implemented has only the required validations and behavior outlined in the challenge.
No validations on the field formats have been implemented and the program assumes that the format of the fields in the 
requests will be according to the schema.

## Language

The web service is programmed with JAVA 17 language using Spring Boot.

## How to build

This service can be built into a docker image. 
So, you only need Docker installed on your machine.

Execute the following to build the image:
```shell
  docker build -t receipt-processor .
```

## How to run

To run, execute the following to spin up a container of the image created above:

```shell
  docker run -p 8080:8080 -t receipt-processor
```

NOTE: The web service API is exposed on port 8080, 
so you need to expose a port on the container linked with 8080 to access it on you local machine.

Example API requests to test can be found in this [Postman Collection](Receipt-Processor.postman_collection.json).
