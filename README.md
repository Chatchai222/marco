# marco
Spring boot application with postgres database

Link to swagger UI
http://marco.cooldev.win:8080/swagger-ui/index.html

Link to simple ER diagram
https://app.diagrams.net/#G168-27kW6Eyo_ZPvsdxCVn4D5AtF1IDsP

## systemd service
On marco.cooldev.win there is a service file to can be used turn on and turn off the service

Start the service
```
sudo systemctl start marco
```

Stop the service
```
sudo systemctl stop marco
```

## To deploy something
1. Push code to marco repository at "main" branch
2. SSH into marco@marco.cooldev.win
3. cd into folder "marco"
4. sudo systemctl stop marco
5. git fetch origin
6. git merge origin/main
7. sudo systemctl start marco


