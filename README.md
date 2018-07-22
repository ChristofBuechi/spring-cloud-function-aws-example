An example repository for an article about running Spring Cloud Functions on AWS Lambda.

The article is available here: https://dzone.com/articles/run-code-with-spring-cloud-function-on-aws-lambda


Command to test the function, not from external, only internal aws:
`sls remove && mvn clean install && sls deploy && sls invoke -f uppercase -l -d '{"input":"message"}'`
