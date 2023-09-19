## Micronaut Tutorial  [![Twitter](https://img.shields.io/twitter/follow/piotr_minkowski.svg?style=social&logo=twitter&label=Follow%20Me)](https://twitter.com/piotr_minkowski)

[![CircleCI](https://circleci.com/gh/piomin/sample-micronaut-applications.svg?style=svg)](https://circleci.com/gh/piomin/sample-micronaut-applications)

[![SonarCloud](https://sonarcloud.io/images/project_badges/sonarcloud-black.svg)](https://sonarcloud.io/dashboard?id=piomin_sample-micronaut-applications)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=piomin_sample-micronaut-applications&metric=bugs)](https://sonarcloud.io/dashboard?id=piomin_sample-micronaut-applications)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=piomin_sample-micronaut-applications&metric=coverage)](https://sonarcloud.io/dashboard?id=piomin_sample-micronaut-applications)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=piomin_sample-micronaut-applications&metric=ncloc)](https://sonarcloud.io/dashboard?id=piomin_sample-micronaut-applications)

Detailed description can be found here: 
1. [Micronaut Tutorial: Beans and Scopes](https://piotrminkowski.com/2019/04/15/micronaut-tutorial-beans-and-scopes/)
2. [Micronaut Tutorial: Server Application](https://piotrminkowski.com/2019/04/23/micronaut-tutorial-server-application/)
3. [Micronaut Tutorial: Security](https://piotrminkowski.com/2019/04/25/micronaut-tutorial-security/)
4. [Micronaut Tutorial: Reactive](https://piotrminkowski.com/2019/11/12/micronaut-tutorial-reactive/)


# Docker Build & K8s Deployment
1. `docker pull docker.io/library/openjdk:17`
2. `sudo  docker build -t sample-micronaut-applications . `
2. `docker run -p 8100:8100 sample-micronaut-applications:latest`
3. `docker image tag sample-micronaut-applications:latest dileepg2k/sample-micronaut-applications:latest`
4. `docker login` , `docker push dileepg2k/sample-micronaut-applications:latest`
5. `kind create cluster --name local-k8s`
6. `kubectl cluster-info --context kind-local-k8s`
7. kubectl create secret docker-hub-sec NAME --docker-username=dileepg2k --docker-password=AkulRocks@1202
8. Load image to kind cluster `kind load docker-image dileepg2k/sample-micronaut-applications:latest --name local-k8s` 
9. `kubectl get nodes local-k8s-control-plane -o yaml`
10. `kubectl create -f ./devops/deployment_values.yaml`

# Kafka Integration
1. `zookeeper-server-start /Users/xxx/kafka/zookeeper.properties`
2. `kafka-server-start /Users/xxx/kafka/server.properties`

# Health Checks
1. [Local Health Check Endpoint](http://localhost:8100/health)

