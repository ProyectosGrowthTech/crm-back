To debug the code, you can use the following profile to the IntelliJ Idea:

Edit Configurations -> Add New Configuration -> Remote JVM Debug and set:

Set the localhost and port to 8080

Run a maven goal:

clean package -Dspring.profiles.active=docker -e

And run the application in Docker