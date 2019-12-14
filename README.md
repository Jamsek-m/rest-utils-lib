# REST Utils library 1.0.0

[![GitHub release (latest SemVer)](https://img.shields.io/github/v/release/Jamsek-m/rest-utils-lib)](https://github.com/Jamsek-m/rest-utils-lib/releases)
![Build Status](https://jenkins.mjamsek.com/buildStatus/icon?job=rest-utils-lib)
[![GitHub license](https://img.shields.io/github/license/Jamsek-m/rest-utils-lib)](https://github.com/Jamsek-m/rest-utils-lib/blob/develop/LICENSE)

> Utility library for REST services

## Requirements

Library is compatible with Java 11+

## Usage

Import library in your project:
```xml
<dependency>
    <groupId>com.mjamsek.rest</groupId>
    <artifactId>rest-utils</artifactId>
    <version>${rest-utils-lib.version}</version>
</dependency>
``` 

## Library content

### Validator

Library provides validating service.

#### Usage

```java
@Inject
private Validator validator;

// Asserts object is not null
validator.assertNotNull(request.field);
// Asserts string is not null or empty (spaces are trimmed)
validator.assertNotBlank(request.field);
// Asserts string matches regex pattern
validator.assertRegex(request.field, regexp);
```

All of these methods throw ValidationException if assertion fails. More in [exceptions](#validation-exception)

There are also available overloaded methods to provide additional information to user. 

### Additional HTTP constants

Library introduces new statuses: 

* 422 (validation failed)

```java
int status = HttpStatus.VALIDATION_FAILED;
```

* 424 (validation failed)

```java
int status = HttpStatus.FAILED_DEPENDENCY;
```

It also provides header fields:

* *X-Total-Count*

```java
String header = HttpHeaders.X_TOTAL_COUNT;
```

* *Content-Disposition*

```java
String header = HttpHeaders.CONTENT_DISPOSITION;
```

* *Authorization*

```java
String header = HttpHeaders.AUTHORIZATION;
```

* *X-Service-Name*

```java
String header = HttpHeaders.X_SERVICE_NAME;
```

* *X-Service-Version*

```java
String header = HttpHeaders.X_SERVICE_VERSION;
```

* *X-Powered-By*

```java
String header = HttpHeaders.X_POWERED_BY;
```

* *X-Content-Type-Options*
```java
String header = HttpHeaders.X_CONTENT_TYPE_OPTIONS;
```

* *X-XSS-Protection*
```java
String header = HttpHeaders.X_XSS_PROTECTION;
```

* *X-Frame-Options*
```java
String header = HttpHeaders.X_FRAME_OPTIONS;
```

* *Strict-Transport-Security*
```java
String header = HttpHeaders.STRICT_TRANSPORT_SECURITY;
```

* *Content-Security-Policy*
```java
String header = HttpHeaders.CONTENT_SECURITY_POLICY;
```

* *Access-Control-Allow-Origin*
```java
String header = HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN;
```

* *Access-Control-Expose-Headers*
```java
String header = HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS;
```

* *Access-Control-Allow-Credentials*
```java
String header = HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS;
```

* *Access-Control-Allow-Methods*
```java
String header = HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS;
```

* *Access-Control-Allow-Headers*
```java
String header = HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS;
```

* *Timing-Allow-Origin*
```java
String header = HttpHeaders.TIMING_ALLOW_ORIGIN;
```

### Exceptions

#### Rest exception

Generic base exception. All other exceptions inherit from it.

#### ServiceCall exception

Thrown when call to other service fails. Returns code 503.

#### Validation exception

Validation exception uses self-enclosing data (`ExceptionResponse`), so there is no need to map its data. To provide better message to users, simply provide exception mapper:

```java
import com.mjamsek.rest.exceptions.ValidationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ValidationExceptionMapper implements ExceptionMapper<ValidationException> {
    
    @Override
    public Response toResponse(ValidationException e) {
        return e.getResponse().createResponse();
    }
}
```

#### Bad Request exception

Error when receiveing bad data from user. Returns 400.

#### Forbidden & Unauthorized exception

Return 401 or 403 if user lacks proper permissions.

#### Not Found exception

Thrown when requested entity does not exists and returns 404. It also provides overloaded constructor to easily describe to user what is missing.
