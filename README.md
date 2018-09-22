An example repository for an article about running Spring Cloud Functions on AWS Lambda.

The article is available here: https://dzone.com/articles/run-code-with-spring-cloud-function-on-aws-lambda


Command to test the function, not from external, only internal aws:
`sls remove && mvn clean install && sls deploy && sls invoke -f jvmTime

Example to run commands

$ sls invoke -f jvmTime<br>
{"currentTime":"2018-09-22T22:30:50.842","timeSource":"JVM"}

$ sls invoke -f databaseTime<br>
{"currentTime":"2018-09-22T22:30:50.842","timeSource":"DATABASE"}
