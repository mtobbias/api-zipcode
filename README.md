
# API ZIPCODE
[https://api-zipcode.herokuapp.com/swagger-ui/](https://api-zipcode.herokuapp.com/swagger-ui/)

![enter image description here](https://raw.githubusercontent.com/mtobbias/api-zipcode/main/assets/img001.png?token=GHSAT0AAAAAABRRC55WKMUUCV2HC6NTHJ24YQ7YCPA)

**RUN SONAR**  
mvn sonar:sonar -Dsonar.projectKey=api-zipcode -Dsonar.host.url=http://127.0.0.1:9000 -Dsonar.login=<YOUR_KEY>

**Docker composer**
- image: 'mtobbias/api-zipcode:0.0.1'
- image: sonarqube:community
- image: redis:alpine3.15
