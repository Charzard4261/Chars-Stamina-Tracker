# URealmsUI
An unofficial multiuser stamina &amp; actions tracker for Robert Moran's tabletop game 'URealms'

## Getting Started

It's pretty simple to get a version of this up and running, at least on the client side of things.

### Prerequisites

```
Java 1.8.0 or later (untested on older versions)
(Server) Knowledge of port-forwarding
```

### Downloading

Head on over to the [latest release](https://github.com/Charzard4261/URealmsUI/releases/latest) page and download the ZIP file attatched.
Extract the .jar to somewhere you can easily find, for example, your desktop.

That's all it takes to setup the program. The whole thing is contained in one .jar file.
Keep reading for how to host and connect to servers.

### Client

Run the .jar file
Click the 'Client'button
Enter the host's IP address (or, in the host's case, leave it as 127.0.0.1, it redirects to the host machine)
Set the port to the host's choosen port (default 9002)
Select the screen you want it to run on 
Click 'connect'

### Server

Run the .jar file
Click the 'Server' button

## Errors

### Clientside

```
Couldn't read IP address
```
Check the IP, it should only have numbers separated by full-stops (.)

```
Couldn't get IO for the connection to <IP>
```
The IP does not have a server, does not have a server on the requested port, or host has shut down a connected server

### Serverside

```
Couldn't bind port <port>
```
An application is already using the selected port

# Credits
Images:
  - Created using the [Eclipse](https://www.eclipse.org/) Java Oxygen IDE and [Swing Window Builder](https://en.wikipedia.org/wiki/Swing_(Java))  
  - Images created by [Konpaatre](https://www.urealms.com/profile/Konpaatre)
