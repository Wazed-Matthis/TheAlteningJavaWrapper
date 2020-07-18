# TheAlteningJavaWrapper
A Wrapper for the TheAltening Api

# Usage
Add the jar as a library, then you have to call 
```javascript
Api.init();
``` 
at the start of your program.

and to Generate an Account you have to call 
```javascript
Generator.getInstance().generate("<YourApiToken>");
``` 
this call returns an account you browse through the code it is semi well documented

# Info
Note that you still have to change your Auth service and your session service in minecraft while logging into the account!
services: 
```java
private static final String ALTENING_AUTH_SERVER = "http://authserver.thealtening.com/"
private static final String ALTENING_SESSION_SERVER = "http://sessionserver.thealtening.com/"
```
