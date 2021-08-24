# LagomBasicDemo

In this Project I simply make a route using the Lagom framework so, when a user hit that path it generates a String "Hello! $name from Lagom Service" as the response.

To run this project in your system simply clone it and run the `sbt runAll` command through your terminal under the project location. After running the command in the end the output should look like:
```[info] play.api.Play [] - Application started (Dev) (no global state)
[info] Service HelloService-impl listening for HTTP on 127.0.0.1:55527
[info] (Service started, press enter to stop and go back to the console...)
```

Now the service is running successfully and user can hit the endpoint. To hit the endpoint user can simply go to any browser and write `http://127.0.0.1:55527/api/hello/Yash` in the url tab and hit enter/search button.

The service will generates the response as string `Hello! Yash from Lagom service`

**Note**: SBT should be installed in your system, or you can use an IDE for example - In Intellij you have to open the cloned folder 
and wait until it loaded successfully, 
now open the terminal and run command `sbt runAll` it will run your project and generate the output at mentioned port.