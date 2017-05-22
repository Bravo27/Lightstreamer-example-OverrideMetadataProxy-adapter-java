# Lightstreamer-example-OverrideMetadataProxy-adapter-java
A dummy plug-in which override the Metadata Remote Adapter to just add println to NotifyNewTables.

The OverrideMetadataProxy class override the RobustNetworkedMetadataProvider and specializes in three methods:
 - init
 - wantsTablesNotification
 - notifyNewTables
 
In the init and notifyNewTables code was simplu added some println for the incoming parameters and the call to the super.

## Compile

To compile the Java class OverrideMetadataProxy and obtain the .class to use in the adapter deploy, from the home of the project launch:

`javac -nowarn -g -classpath lib/ls-proxy-adapters.jar;lib/ls-adapter-interface.jar src/com/lightstreamer/adapters/OverrideMetadataProxy.java`

You can use java 6, 7 or 8 but it would be better to use the same version of the jvm running the server.

## Deploy

You can fin an example of deploy in the latest release of the project.




