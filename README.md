# Restful Web Services

[![Build Status](https://cloud.drone.io/api/badges/JavaRestSpringIntegrations/restwebservices/status.svg)](https://cloud.drone.io/JavaRestSpringIntegrations/restwebservices)
![GitHub repo size](https://img.shields.io/github/repo-size/JavaRestSpringIntegrations/restwebservices)
[![GitHub license](https://img.shields.io/github/license/JavaRestSpringIntegrations/restwebservices)](https://github.com/JavaRestSpringIntegrations/restwebservices/blob/master/LICENSE)


Repository for ReST web Services.

Enable logging level for spring framework. In the **application.properties** create the below entry:
`logging.level.org.springframework = debug`

## What is Dispatcher Servlet?

## Who is configuring the Dispatcher Servlet?

The below information is from the logs:

`o.s.b.w.s.ServletContextInitializerBeans : Mapping servlets: dispatcherServlet urls=[/]`

## Modifcations
### How do we return to the user if an 'id' is not found?

1. Create 'UserNotFoundException'

![](images/not_found_404.png)

The above message is generated by default error handling of Spring boot and Spring MVC framework. It's important to have
consistent error message for the services ( Standard Exception structure ).