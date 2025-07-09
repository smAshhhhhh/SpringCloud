application_name=service-test
PID=`ps -ef | grep $application_name | grep -v ' grep' | awk '{print $2}'`
if [ ! -e $PID ]
then
	echo "kill $application_name PID is $PID"
	kill -9 $PID
else
	echo "$application_name not run"
fi
git pull
mvn clean install -DskipTests
java -jar service-test/target/service-test-0.0.1-SNAPSHOT.jar >> /cloud/logs/service-test.log 2>&1 &
tail -500f /cloud/logs/service-test.log