# REST Utils Library

[![Maven Central](https://img.shields.io/maven-central/v/com.mjamsek.rest/rest-utils)](https://mvnrepository.com/artifact/com.mjamsek.rest/rest-utils)
[![Last commit](https://img.shields.io/github/last-commit/Jamsek-m/rest-utils-lib/develop)](https://github.com/Jamsek-m/rest-utils-lib/commits/develop)
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
import javax.inject.Inject;

import com.mjamsek.rest.factories.ValidatorFactory;
import com.mjamsek.rest.services.Validator;

class Sample {
    
    @Inject
    private Validator validator;
    
    public void init() {
        // Get new instance in non-CDI context
        this.validator = LocalizatorFactory.getNewInstance();
    }
    
    public void sample() {
        // Asserts object is not null
        validator.assertNotNull(request.field);
        // Asserts string is not null or empty (spaces are trimmed)
        validator.assertNotBlank(request.field);
        // Asserts string matches regex pattern
        validator.assertRegex(request.field, regexp);
        // Asserts string matches email pattern (compliant with RFC 5322)
        validator.assertEmail(request.field);
        // Asserts that value is not after second argument
        validator.assertNotAfter(new Date(), request.getExpirationDate());
        // Asserts that value is not before second argument
        validator.assertNotBefore(new Date(), request.getStartDate());
    }
}
```

All of these methods throw ValidationException if assertion fails. More in [exceptions](#validation-exception).

Library also provides overloaded methods to provide additional information to user. 

### Localizator
Service for localizing messages from java properties file.

#### Usage

Translations are expected to be in `classpath:/i18n/translations[_en_US].properties`.

```java
import javax.inject.Inject;

import com.mjamsek.rest.factories.LocalizatorFactory;
import com.mjamsek.rest.services.Localizator;

class Sample {
    
    @Inject
    private Localizator localizator;
    
    public void init() {
        // Get new instance in non-CDI context
        this.localizator = LocalizatorFactory.getNewInstance();
    }
    
    public void sample() {
        // If translation_en_US.properties contains 
        // code.error=Error!
        String message = localizator.getTranslation("code.error", new Locale("en", "US"));
        // then message == "Error!"
        
        // It is also possible to pass params for 
        // parameterized messages like:
        // code.error=Error occurred at line {}
        String message = localizator.getTranslation("code.error", new Locale("en", "US"), 2);
        // then message == "Error occurred at line 2"
    }
}
```

### Additional HTTP constants

#### HTTP statuses
Library provides additional statuses: 

* 422 (validation failed)

```java
int status = Rest.HttpStatus.VALIDATION_FAILED;
```

* 424 (validation failed)

```java
int status = Rest.HttpStatus.FAILED_DEPENDENCY;
```

#### HTTP headers
It also provides additional header fields:

##### Service metadata

* *X-Service-Name*

```java
String header = Rest.HttpHeaders.X_SERVICE_NAME;
```

* *X-Service-Version*

```java
String header = Rest.HttpHeaders.X_SERVICE_VERSION;
```

* *X-Service-Env*

```java
String header = Rest.HttpHeaders.X_SERVICE_END;
```

* *X-Powered-By*

```java
String header = Rest.HttpHeaders.X_POWERED_BY;
```

* *X-Request-Id*

```java
String header = Rest.HttpHeaders.X_REQUEST_ID;
```

##### Lists

* *X-Total-Count*

```java
String header = Rest.HttpHeaders.X_TOTAL_COUNT;
```

* *X-Limit*

```java
String header = Rest.HttpHeaders.X_LIMIT;
```

* *X-Offset*

```java
String header = Rest.HttpHeaders.X_OFFSET;
```

##### Multipart

* *Content-Disposition*

```java
String header = Rest.HttpHeaders.CONTENT_DISPOSITION;
```

##### Security

* *Authorization*

```java
String header = Rest.HttpHeaders.AUTHORIZATION;
```

* *X-Content-Type-Options*
```java
String header = Rest.HttpHeaders.X_CONTENT_TYPE_OPTIONS;
```

* *X-XSS-Protection*
```java
String header = Rest.HttpHeaders.X_XSS_PROTECTION;
```

* *X-Frame-Options*
```java
String header = Rest.HttpHeaders.X_FRAME_OPTIONS;
```

* *Strict-Transport-Security*
```java
String header = Rest.HttpHeaders.STRICT_TRANSPORT_SECURITY;
```

* *Content-Security-Policy*
```java
String header = Rest.HttpHeaders.CONTENT_SECURITY_POLICY;
```

##### CORS

* *Access-Control-Allow-Origin*
```java
String header = Rest.HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN;
```

* *Access-Control-Expose-Headers*
```java
String header = Rest.HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS;
```

* *Access-Control-Allow-Credentials*
```java
String header = Rest.HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS;
```

* *Access-Control-Allow-Methods*
```java
String header = Rest.HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS;
```

* *Access-Control-Allow-Headers*
```java
String header = Rest.HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS;
```

* *Timing-Allow-Origin*
```java
String header = Rest.HttpHeaders.TIMING_ALLOW_ORIGIN;
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

Return 401 or 403, if user lacks proper permissions.

#### Not Found exception

Thrown when requested entity does not exist and returns 404. It also provides an overloaded constructor to easily describe to user what is missing.

#### Custom exception fields

You can also provide your own implementation of `ExceptionResponse`:

```java
import com.mjamsek.rest.exceptions.RestException;
import com.mjamsek.rest.exceptions.dto.ExceptionResponse;

import javax.ws.rs.core.Response;

class Sample {
    
    public void sample() {
        MyException myExc = new MyException()
            .setStatus(500)
            .setMessage("Server error")
            .setCode("error.server")
            .setEntity("Person")
            .setField("lastName")
            .setMoreInfo("see more at: https://google.com");
            
        throw new RestException("code.error")
            .replaceResponse(myExc);
    }
    
    public static class MyException extends ExceptionResponse {
        private String additionalField;
        
        @Override
        public Response createResponse() {
            return Response.status(this.status).entity(this).build();
        }
        
        public String getAdditionalField() {
            return this.additionalField;
        }
        
        public void setAdditionalField(String additionalField) {
            this.additionalField = additionalField;
        }
    }
}
```

## Changelog
Changes can be viewed on [releases page](https://github.com/Jamsek-m/rest-utils-lib/releases) on GitHub.

## License
MIT