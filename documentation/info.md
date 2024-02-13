# Welcome to SmartPi Home

# Build command for prod ready

mvn clean package -DskipTests -Pprod

# Prod Live URL

[http://mcirstea92.go.ro:7373/SmartLighting](http://mcirstea92.go.ro:7373/SmartLighting)

To autostart a terminal in Raspberry PI and send a command just edit this file
```shell
sudo nano /etc/xdg/lxsession/LXDE-pi/autostart
```
and insert before @screensaver a line like the following:
```
@lxterminal --command "/path/to/executable.sh"
```

IP - Port Mappings

| Device Name | Device public URL      | Internal IP   | Internal port | MAC               |
|-------------|------------------------|---------------|---------------|-------------------|
| RTSP 1      | mcirstea92.go.ro:13001 | 192.168.1.151 | 554           | 3C-84-6A-A3-E4-23 |
| RTSP 2      | mcirstea92.go.ro:13002 | 192.168.1.152 | 554           | 3C-84-6A-A3-FA-28 |
| RTSP 3      | mcirstea92.go.ro:13003 | 192.168.1.153 | 554           | 3C-84-6A-A4-09-C9 |
| RTSP 4      | mcirstea92.go.ro:13004 | 192.168.1.154 | 554           | 3C-84-6A-A3-FB-5F |
| RTSP 5      | mcirstea92.go.ro:13005 | 192.168.1.155 | 554           | 10-27-F5-EA-83-57 |
| RTSP 6      | mcirstea92.go.ro:13006 | 192.168.1.156 | 554           | B4-B0-24-E6-22-A4 |
| ONVIF 1     | mcirstea92.go.ro:14001 | 192.168.1.151 | 2020          | 3C-84-6A-A3-E4-23 |
| ONVIF 2     | mcirstea92.go.ro:14002 | 192.168.1.152 | 2020          | 3C-84-6A-A3-FA-28 |
| ONVIF 3     | mcirstea92.go.ro:14003 | 192.168.1.153 | 2020          | 3C-84-6A-A4-09-C9 |
| ONVIF 4     | mcirstea92.go.ro:14004 | 192.168.1.154 | 2020          | 3C-84-6A-A3-FB-5F |
| ONVIF 5     | mcirstea92.go.ro:14005 | 192.168.1.155 | 2020          | 10-27-F5-EA-83-57 |
| ONVIF 6     | mcirstea92.go.ro:14006 | 192.168.1.156 | 2020          | B4-B0-24-E6-22-A4 |
| PLUG 1      | mcirstea92.go.ro:15001 | 192.168.1.161 | 80            | C0-06-C3-17-E7-10 |
| PLUG 2      | mcirstea92.go.ro:15002 | 192.168.1.162 | 80            | B4-B0-24-AD-3D-FB |
| PLUG 3      | mcirstea92.go.ro:15003 | 192.168.1.163 | 80            | B4-B0-24-AD-12-AC |
| PLUG 4      | mcirstea92.go.ro:15004 | 192.168.1.164 | 80            | 54-AF-97-7C-A3-75 |
| PLUG 5      | mcirstea92.go.ro:15005 | 192.168.1.165 | 80            | B4-B0-24-AC-EF-27 |
| AC Unit     | mcirstea92.go.ro:37000 | 192.168.1.149 | 7000          | F4-91-1E-61-74-D7 |

Physical Raspberry pin connections - WiringPi command: gpio readall

| Index | Culoare fir  | Destinație    | Pin fizic Raspi         | Wiring Pi index | BCM |
|-------|--------------|---------------|-------------------------|-----------------|-----|
| 0     | Portocaliu   | 5V            | [2,4]                   | -               |  -  |
| 1     | Alb          | Terasă        | 3                       | 8               | 2   |
| 2     | Galben       | Scară         | 7                       | 7               | 4   |
| 3     | Verde        | Dormitor 1    | 22                      | 6               | 25  |
| 4     | Roșu         | Dormitor 2    | 18                      | 5               | 24  |
| 5     | Galben       | Living 1      | 16                      | 4               | 23  |
| 6     | Albastru     | Living 2      | 15                      | 3               | 22  |
| 7     | Verde închis | Baie          | 13                      | 2               | 27  |
| 8     | Maro         | Bucătărie     | 12                      | 1               | 18  |
| 9     | Roșu         | 3.3V          | [1,17]                  | -               |  -  |
| 10    | Maro         | 0v            | [6,9,14,20,25,30,34,39] | -               |  -  |
| 11    | Portocaliu   | Senzor Living | 37                      | 25              | 26  |
| 12    | Albastru     | Senzor Afară  | 36                      | 27              | 16  |

Todos:

- implement cookie based authentication
- implement error page (change default whitelabel error page from spring) with redirect possibility to home index
- arrange login and signup pages
- graphic reports (charts for temperature fluctuations)
- implement min/max, avg temperature per day, week, month

My Tomcat is running on localhost:27562 and it is forwarded to 7373 external port. I shall try to forward it to 80/443.

[SSL certificate authority for local https development](https://deliciousbrains.com/ssl-certificate-authority-for-local-https-development/)

```xsdregexp
mvn -T 1.5C clean package -DskipTests -Pdev 
mvn -T 4C clean package -DskipTests -Pprod
```

## Steps to install on Raspi

1. Clone skeleton project from https://github.com/mcirstea92/smarthome-lighting/ and build it using Maven
2. Install prerequisites:
    - Java
        - apt update
        - apt install default-openjdk
        - Or for 64bit aarch64: https://superuser.com/questions/1468851/raspberry-pi-aarch64-openjdk11
        - Set up JAVA_HOME accordingly
    - MySql
        - [https://pimylifeup.com/raspberry-pi-mysql/](https://pimylifeup.com/raspberry-pi-mysql/)
        - [https://www.digitalocean.com/community/tutorials/how-to-create-a-new-user-and-grant-permissions-in-mysql](https://www.digitalocean.com/community/tutorials/how-to-create-a-new-user-and-grant-permissions-in-mysql)
        - Set up user and password as well as creating a new database
            - CREATE USER 'marius'@'localhost' IDENTIFIED BY '*********';
            - GRANT ALL PRIVILEGES ON * . * TO 'marius'@'localhost';
            - FLUSH PRIVILEGES;
            - SHOW GRANTS FOR 'marius'@'localhost';
            - mysql -u marius -p
            - CREATE DATABASE smarthome;
            - USE DATABASE smarthome;
            - SHOW TABLES;
    - Apache Tomcat (8.5.69): https://tomcat.apache.org/download-80.cgi#8.5.69
        1. Installation and setup with user and
           group: [https://www.digitalocean.com/community/tutorials/how-to-install-apache-tomcat-9-on-debian-10](https://www.digitalocean.com/community/tutorials/how-to-install-apache-tomcat-9-on-debian-10)
        2. Allow other hosts to use Tomcat Manager
           GUI: [https://stackoverflow.com/questions/36703856/access-tomcat-manager-app-from-different-host](https://stackoverflow.com/questions/36703856/access-tomcat-manager-app-from-different-host)
        3. Set up rewrite config inside ~/conf/Catalina/localhost/rewrite.config with the following content:

            ```shell
            RewriteCond %{REQUEST_PATH} !-f
            RewriteRule ^/SmartLighting/(.*) /SmartLighting/index.html
            ```

        4. Create manager.xml with the following content in /tomcat/conf/Catalina/localhost

           ```xml
            <Context privileged="true" antiResourceLocking="false" docBase="${catalina.home}/webapps/manager">
                <Valve className="org.apache.catalina.valves.RemoteAddrValve" allow=".*" />
            </Context>
            ```

        5. Add user to /conf/tomcat-users.xml file like:

            ```xml
            <user username="marius" password="whateverpassword" roles="manager-gui" />
            ```

        6. Allow max upload size for WARs

           Edit webapps/manager/WEB-INF/web.xml - search for multipart-config -> max-file-size and max-request-size

        7. To start a service at boot, use the enable command:

            ```shell
            sudo systemctl enable tomcat.service
            ```

        8. Add tomcat user to gpio group. Before this make sure WiringPi is install:

            ```shell
           sudo chown root.gpio /dev/mem
           sudo chmod g+rw /dev/mem
            gpio -v
           ```

           Otherwise install it
           using [http://wiringpi.com/download-and-install/](http://wiringpi.com/download-and-install/)

        9. Save and restart tomcat: sudo systemctl restart tomcat

- Spring Boot Application

- Angular app
    - Set baseUrl to http://mcirstea92.go.ro:7373/SmartLighting
    - [https://material.angular.io/guide/theming](https://material.angular.io/guide/theming)
    - [https://www.positronx.io/create-angular-material-8-custom-theme/](https://www.positronx.io/create-angular-material-8-custom-theme/)

# RTSPtoWeb repository (used for video player)

[https://github.com/deepch/RTSPtoWeb](https://github.com/deepch/RTSPtoWeb)
Install docker:

```shell
curl -fsSL https://get.docker.com -o get-docker.sh
sh ./get-docker.sh
```

[Install GO on Raspberry 3 and 4](https://shores.dev/install-go-language-on-raspberry-pi-3-and-4/)

# Autostart terminal and run command on login

[https://forums.raspberrypi.com/viewtopic.php?t=274658](https://forums.raspberrypi.com/viewtopic.php?t=274658)

# Install coTURN server and configure it to listen on port 3478

[Install and configure coTURN server on Ubuntu](https://www.bloggernepal.com/2021/05/setup-stun-and-turn-server-on-ubuntu.html)

Or simply use already working public TURN server like:

```json
{
  "ice_servers": [
    "turn:numb.viagenie.ca"
  ],
  "ice_username": "webrtc@live.com",
  "ice_credential": "muazkh"
}
```

Local config example for RTSPtoWebRTC

```dockerfile
docker build RTSPtoWebRTC -t local:RTSPtoWebRTC
docker run -d --restart always --name rtsp-to-webrtc -v /PATH_TO_CONFIG/config.json:/config/config.json --network host local:RTSPtoWebRTC
```

To edit files inside docker container

```dockerfile
docker exec -u 0 -it <containerId> /bin/bash
cat << EOT >> config.json
{ 
    ... rest of the lines here ... 
}
EOT
```

To read again the config.json file, we need to recreate the container (or just research more on how to change it inside
container)

```dockerfile
docker container stop <containerId>
docker container rm <containerId>
docker container ps -a
docker image ls
docker image rm <repository:TAG>
rebuild using above steps [navigate to the root directory containing the RTSPtoWebRTC folder eg: /home/pi/Downloads]
docker build RTSPtoWebRTC -t local:RTSPtoWebRTC
docker run -d --restart always --name rtsp-to-webrtc --network host local:RTSPtoWebRTC
docker exec -u root -ti <containerId> /bin/bash
```

By default, this runs on 8083 port and you can check by heading to [http://localhost:8083/](http://localhost:8083/)

```json
{
  "ice_servers": [
    "turn:mcirstea92.go.ro:33478"
  ],
  "ice_username": "marius",
  "ice_credential": "cirstea",
  "webrtc_port_min": 50000,
  "webrtc_port_max": 50005
}
```

Coturn turnserver.conf example:

```text
# /etc/turnserver.conf
# STUN server port is 3478 for UDP and TCP, and 5349 for TLS.
# Allow connection on the UDP port 3478 - expose this port on router, outside = 33478
listening-port=3478
# and 5349 for TLS (secure)
tls-listening-port=5349

# Require authentication
fingerprint
lt-cred-mech

# We will use the longterm authentication mechanism, but if
# you want to use the auth-secret mechanism, comment lt-cred-mech and 
# uncomment use-auth-secret
# Check: https://github.com/coturn/coturn/issues/180#issuecomment-364363272
#The static auth secret needs to be changed, in this tutorial
# we'll generate a token using OpenSSL
# use-auth-secret
# static-auth-secret=replace-this-secret
# ----
# If you decide to use use-auth-secret, After saving the changes, change the auth-secret using the following command:
# sed -i "s/replace-this-secret/$(openssl rand -hex 32)/" /etc/turnserver.conf
# This will replace the replace-this-secret text on the file with the generated token using openssl. 

# Specify the server name and the realm that will be used
# if is your first time configuring, just use the domain as name
server-name=mcirstea92.go.ro
realm=mcirstea92.go.ro

# Important: 
# Create a test user if you want
# You can remove this user after testing
user=guest:somepassword

total-quota=100
stale-nonce=600

# Path to the SSL certificate and private key. In this example we will use
# the letsencrypt generated certificate files.
#cert=/etc/letsencrypt/live/stun.bloggernepal.com/cert.pem
#pkey=/etc/letsencrypt/live/stun.bloggernepal.com/privkey.pem

# Specify the allowed OpenSSL cipher list for TLS/DTLS connections
cipher-list="ECDHE-RSA-AES256-GCM-SHA512:DHE-RSA-AES256-GCM-SHA512:ECDHE-RSA-AES256-GCM-SHA384:DHE-RSA-AES256-GCM-SHA384:ECDHE-RSA-AES256-SHA384"

# Specify the process user and group
proc-user=turnserver
proc-group=turnserver

```

[https://www.learninjava.com/angular-router-config-apache-nginx-tomcat/](https://www.learninjava.com/angular-router-config-apache-nginx-tomcat/)

[https://www.yawintutor.com/application-has-no-explicit-mapping-for-error-whitelabel-error-page-with-status-404/](https://www.yawintutor.com/application-has-no-explicit-mapping-for-error-whitelabel-error-page-with-status-404/)

Set up static IP inside Raspberry
[https://pimylifeup.com/raspberry-pi-static-ip-address/](https://pimylifeup.com/raspberry-pi-static-ip-address/)

Don't forget to forward all the required ports in your router!

Linux useful commands:

Check what user named x can run:

```
sudo -U user -l
```

Before running following command, you need to specify using visudo the abilities for the tomcat user, like this

``` 
sudo visudo /etc/sudoers.d/other

Cmnd_Alias ALLOWED_SERVICES = \
   /bin/systemctl restart coturn.service, \
   /bin/systemctl restart tomcat.service, \
   /usr/sbin/reboot

tomcat ALL = (root) NOPASSWD: ALLOWED_SERVICES
```

Run sudo command with password for current user:

```
echo 'tomcat' | sudo -S systemctl restart coturn.service
```