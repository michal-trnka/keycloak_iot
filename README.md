#IoT security example
This example serves as example of using keycloak for securing devices in the IoT. Application as it stands provides just central hub for services. For the complete overview I suggest to use it with https://github.com/slowercz/rpi_HC-SR501 and https://github.com/slowercz/rpi_DS18B20. For future I plan to add possibility to mock sensors, without actuall need for them and Raspberry Pi.

#Requirements
1. keycloak 1.5.0 Final (though possibly could run on 1.3+)
2. wildfly 9.0.1 Final

#Setup

##Keycloak
1. create realm IoT and client iot in it.
2. turn on direct grants only
3. access type: public
4. create roles: "motionSensor" and "temperatureSensor"
5. create users: "motion-sensor" and "temperature-sensor"
6. assign motionSensor role to motion-sensor user and temperatureSensor to temperature-sensor
7. set password for motion-sensor to "motSens" and for temperature-sensor to "tempSens"
8. (optional) configure keycloak to use SSL
9. generate  keycloak.json (watch for correct auth-server-url if you will try to access it from other computers and not only from localhost)
 
##Application
1. import correct keycloak.json
2. run wildfly
3. run comman mvn clean package wildfly:deploy

##End devices
1. set correct IP address in restClient.js for both sensors
2. in case keycloak runs on different IP then application alter methods "sendMotion" and "sendTemperature" to match the correct address

#Usage
You can view results of your sensors on address [server-address:port]/iot-hub-example/

##Manual usage
There is nothing preventing you from connecting to hub manually HTTP calls.

###Authentication
You can get your token on address [keycloak-address:port]/auth/realms/iot/protocol/openid-connect/token as described in keycloak documentation. After that you need to add "Authorization" header to ever request done on secured resources. You need to make separate authentication for each "sensor".

###Movement management
1. List of movements is obtained using GET method on [server-address:port]/iot-hub-example/rest/movement/list . This endpoint is public
2. You can add movement using POST method on [server-address:port]/iot-hub-example/rest/movement/add/{MovementDescription}
 
###Temperature management
1. List of temperatures is obtained using GET method on [server-address:port]/iot-hub-example/rest/temperature/list . This endpoint is public
2. You can add movement using POST method on [server-address:port]/iot-hub-example/rest/temperature/add/{MovementDescription}
