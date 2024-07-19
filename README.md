
1) Install Elasticsearch version 7.10 locally and start it up.
2) Add the VM options
```
-javaagent:/{PROJECT_PATH}/lib/aspectjweaver-1.9.22.jar 
-javaagent:/{PROJECT_PATH}/lib/spring-instrument-6.1.10.jar.
```
3) Start the application.
4) Check the console for any error logs.
