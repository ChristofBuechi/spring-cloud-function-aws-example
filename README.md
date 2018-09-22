An example repository for an article about running Spring Cloud Functions on AWS Lambda.

The article is available here: https://dzone.com/articles/run-code-with-spring-cloud-function-on-aws-lambda


Command to test the function, not from external, only internal aws:
`sls remove && mvn clean install && sls deploy && sls invoke -f jvmTime

Example to run commands

$ sls invoke -f jvmTime<br>
{
    "time": "2018-08-27T21:17:31.039"
}

$ sls invoke -f databaseTime<br>
{
    "currentTime": "23",
    "timeSource": "MEDICAL"
}

$ sls invoke -f uppercase -d '{"userId":"asdfjasldf"}'
{
    "userId": "ASDFJASLDF"
}

