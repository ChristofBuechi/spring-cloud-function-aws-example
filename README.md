An example repository for an article about running Spring Cloud Functions on AWS Lambda.

The article is available here: https://dzone.com/articles/run-code-with-spring-cloud-function-on-aws-lambda


Command to test the function, not from external, only internal aws:
`sls remove && mvn clean install && sls deploy && sls invoke -f uppercase -l -d '{"input":"message"}'`

Example to run commands

$ sls invoke -f time
{
    "time": "2018-08-27T21:17:31.039"
}

$ sls invoke -f time -d '{"currentTime":"23"}'
{
    "time": "2018-08-27T21:13:48.499"
}

$ sls invoke -f members -d '{"currentTime":"23"}'
{
    "currentTime": "23",
    "timeSource": "MEDICAL"
}

$ sls invoke -f uppercase -d '{"userId":"asdfjasldf"}'
{
    "userId": "ASDFJASLDF"
}

