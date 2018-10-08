# SpringBoot-AWS-EC2

SpringBoot project demonstrating Service Discovery using AWS Ec2 instance .
The eureka server and the services are deployed in differnt ec2 instances (with same security group to allow traffic)and Eureka here use private dns to discover services . Here public dns can also be used instead of private dns

Please look into pom.xml for dependencies required for AWS EC2 
