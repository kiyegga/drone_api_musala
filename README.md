# drone_api_musala
In this project, drone API will be used to transport light weight medication with the use of drones.
-Database used is H2 in memory database, which is among dependencies of the project, once project is 
downloaded and maven dependencies installed, run the project database will start upon starting the project plus pre-loaded data included.
Access of data in the database from UI, launch chrome browser or browser of your choice and use this link ‘http://localhost:8081/h2-console/login.do?jsessionid=244e3a02b9ceeb97b33eeb8a8da4438e’, provided the project is started, use username=sa, password=password as logins for the database in graphical user interface.
The project has for entity classes (database table), that is to say Drone entity, Medication entity, DroneActivities entity and DroneBatteryLevel entity, which are in relationships. For example:-
Drone entity and Medication entity are many to many (simply because drone can deliver a number of medication as well medication can be delivered by a number of drones) which lead to born of DroneActivities table for tracking which medication curried or delivered by which drone.
Drone and DroneBatteryLevel entities in relationship of one to many (simply because DroneBatteryLevel entity is for tracking battery levels for each drone in time intervals for audit in future)
There are number of endpoints created and some data seeding upon loading the project but mainly drones, you can be able to check available drones for loading medication, you will not be able to add medication without drone being loaded, either use one of existing idle drones or register a drone before using it to transport medication.
The service is able to record battery level for all registered drone automatically in intervals of five (5) minutes once the project is loaded (for proof check DroneBatteryLevel table in database)
I will be able to share postman collections for all existing endpoints, have not been able to document this API as well as writing test cases due to limited time.
NB:- I had a number of assumptions to implement but I could not be able due to limited time, I had just started to write test cases for controller class though didn’t manage to complete.

