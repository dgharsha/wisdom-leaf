# wisdom-leaf

# pre-requisites 
jdk 17
maven 3+

# Building application:
mvn clean install

# This generates codetest-0.0.1-SNAPSHOT.jar under target folder

# Running application
java -jar target/codetest-0.0.1-SNAPSHOT.jar

# Two apis exposed with this
1. http://localhost:8080/announce/time/23:59
   This announces time 
2. http://localhost:8080/announce/middayornight/23:59
   This returns whether the time is midday(11:00 to 15:59) or mid night(23:00 to 3:59)

