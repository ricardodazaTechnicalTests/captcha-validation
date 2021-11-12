# Captcha validation with SpringBoot and Cage Library for Java

This API provides a form with captcha validation. This captcha can be numeric or alphanumeric and configurable in the number
of characters (between 4 and 8). The number of attemps that the user has to introduce the captcha correctly is also configurable
the captcha correctly.

## How it works

Run the application
```
./gradlew run
```
Now you can access to the application by using the URL "localhost:8080"

In order to configure settings, you can use the endpoint "/settings" with this JSON (all attributes are optional):
```
{
    "maxRetries": 5,
    "alphanumeric": false,
    "length": 4
}
```
If everything is okay, you will receive status code 200. If length is incorrect (not between 4 and 8), you will received the next 
error message:
```
Length must be between 4 and 8
```