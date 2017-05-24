# Lightstreamer-example-OverrideMetadataProxy-adapter-java
A dummy plug-in which override the Metadata Remote Adapter to just add log prints for NotifyNewTables and notifyTablesClose.

The OverrideMetadataProxy class override the RobustNetworkedMetadataProvider and specializes in three methods:
 - init
 - wantsTablesNotification
 - notifyNewTables
 - notifyTablesClose
 
The code of the methods is quite simply; added some logs for the incoming parameters and then call to the super.
This assume that the Adapter share the logging support and configuration with the Server. The logger name used is: LightstreamerProxyAdapters

## Compile

To compile the Java class OverrideMetadataProxy and obtain the .class to use in the adapter deploy, from the home of the project launch:

`javac -nowarn -g -classpath lib/ls-proxy-adapters.jar;lib/ls-adapter-interface.jar;lib/slf4j-api-1.7.21.jar;lib/logback-classic-1.1.7.jar;lib/logback-core-1.1.7.jar src/com/lightstreamer/adapters/OverrideMetadataProxy.java`

You can use java 6, 7 or 8 but it would be better to use the same version of the jvm running the server.

## Deploy

You can find an example of deploy in the latest release of the project.




