# Original Readme
An example repository for an article about running Spring Cloud Functions on AWS Lambda.

The article is available here: https://dzone.com/articles/run-code-with-spring-cloud-function-on-aws-lambda

# Ergänzungen Jonas

## AWS Lambda
Zwei Lambda-Funktionen, jeweils als Component ("lowercaseFunction" und "uppercaseFuntion"). Bei Upload als AWS-Lambda muss:
- der korrekte Function-Handler gesetzt werden
- und das Property FUNCTION_NAME muss auf den Bean-Namen gesetzt werden

So kann man aus einer jar zwei Lambdas in AWS anlegen, mit unterschiedlichen Funktionen. 
(Bei Starten des Lambdas werden alle vorhandenen Beans initialisiert, auch die nicht benötigten -> Einschränkung ggf. sinnvoll, über @Conditional..?)

## Lokale Nutzung

Durch Einbinden des `spring-cloud-starter-function-web` kann man die Anwendung lokal starten und kann auf die Funktionen zugreifen:
- Body: {  "input" : "VERTrag" }
- POST http://localhost:8080/lowercaseFunction<br>
-> {resultString": "vertrag"}
- POST http://localhost:8080/uppercaseFunction<br>
-> {result": "VERTRAG"}
