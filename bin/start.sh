#!/bin/sh

VERSION=1.5.2
APPLICATION=tang-admin-${VERSION}.jar
PID=$(ps -ef | grep $APPLICATION | grep -v grep | awk '{print $2}')

if [ -n "$PID" ]; then
	echo Application is already running on port 8080 with PID $PID
else
	cd ../tang-admin/target
	nohup java -Dlogging.config=classpath:logback.xml -jar $APPLICATION > /dev/null 2>&1 &
	echo Application is running on port 8080 with PID $!
fi
