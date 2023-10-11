KMITL thesis for indoor navigation system

A spring boot application for create, read, replace, and delete of beacon and location.
GET -> Read
POST -> Create
DELETE -> Delete
PUT -> Replace

Data schema
Beacon(Long id, String macAddress, String floorName, Double x, Double y)

Location(Long id, String name, String floorName, Double x, Double y)


Assuming this is on the server marco.cooldev.win:8080

Beacon

GET
http://marco.cooldev.win:8080/api/v1/beacon/all

Return all beacon json object in a list
Example response: 
[{"id":1,"macAddress":"FF:00:CC:CC:EE:DD","floorName":"8th floor","x":52.4,"y":32.5},{"id":2,"macAddress":"55:55:55:AA:AA:BB","floorName":"8th floor","x":32.41,"y":12.3}]

GET
http://marco.cooldev.win:8080/api/v1/beacon/id?id=1

Return a single beacon json object based on id
Example response:
{"id":1,"macAddress":"FF:00:CC:CC:EE:DD","floorName":"8th floor","x":52.4,"y":32.5}

GET 
http://marco.cooldev.win:8080/api/v1/beacon/macAddress?macAddress=FF:00:CC:CC:EE:DD

Return a single beacon json object based on mac address
Example response:
{"id":1,"macAddress":"FF:00:CC:CC:EE:DD","floorName":"8th floor","x":52.4,"y":32.5}

Location

GET
http://marco.cooldev.win:8080/api/v1/location/all

Return all location json object in a list
Example response: 
[{"id":1,"name":"ECC804","floorName":"8th floor","x":23.4,"y":24.2},{"id":2,"name":"Prof Pipat Office","floorName":"8th floor","x":32.4,"y":25.5}]

GET
http://marco.cooldev.win:8080/api/v1/location/id?id=2

Return a single location json object based on id
Example response:
{"id":2,"name":"Prof Pipat Office","floorName":"8th floor","x":32.4,"y":25.5}



