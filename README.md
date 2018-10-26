# SpringBoot-AWS-EC2/Beanstalk

SpringBoot project demonstrating Service Discovery using AWS Ec2 instance .
The eureka server and the services are deployed across differnt ec2 instances (with same security group to allow traffic)and Eureka here use private dns to discover services . Here public dns can also be used instead of private dns(For Ec2 instances only)

Please look into pom.xml for dependencies required for AWS EC2

# SpringBoot-AWS-Beanstalk

SpringBoot project demonstrating Service Discovery using Amazon Beanstalk .The service displaying hello world is only dockerised (The client project consumes this service with endpoint /client). Others apps can also be dockerised similarly
NOTE : For service discovery using beanstalk the service needs to be dockerised
Follow the steps to create a docker container
docker build -t feign-hello-server:0.0.3 .
docker image ls
1Start the service discovery in an ec2 instance or dockerise it  
2docker run -env HOST_NAME='ip' feign-hello-server:0.0.3

3To push docker images to the docker hub
4docker login
5docker tag feign-hello-server:0.0.3 yourusername/feign-hello-server:0.0.3

6docker push yourusername/feign-hello-server:0.0.3
7 Create a docker.aws.json to deploy to beanstalk
8 For beanstalk cli create a folder .ebextensions/environmentvariables.config - This would hold all run time dynamic configuration values(host_name is added as a config variable here. However aws acess key and secret can also be mentioned here) 
9 Create a zip folder with docker.aws.json and .ebextensions and upload
9 For beanstalk UI go to Beanstalk->Configuration->Environment varibles and add necessary values for your docker to start(In this only docker.aws.json is needed with zip extension)
10 Your service should be deployed successfully
11 The docker with container details is registered to eureka server (http://ip:8761)would have the info(Container would hold information of url and port) 
12 Containerize the client project similarly and register to eureka server  with ip http://ip:8761. The service discovery capability should work now. The client will be able to consume and display "Heelo World"


