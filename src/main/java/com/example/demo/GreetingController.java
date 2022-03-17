package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

// In Spring’s approach to building RESTful web services, HTTP requests are handled by a controller.
// This RESTful web service controller handles GET requests for the /greeting service by populating
// and returning a new instance of the Greeting class.
// The object data will be written directly to the HTTP response as JSON.

// The @RestController annotation marks the class as a controller where every method returns a domain
// object instead of a view. It is shorthand for including both @Controller and @ResponseBody (Note to self:
// I need to look into these).
@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    // The @GetMapping annotation ensures that HTTP GET requests to the /greeting service are mapped to
    // the greeting() method. Other annotations include e.g. @PostMapping for POST. These derive from the
    // @RequestMapping annotation, which can be used as a synonym (e.g. @RequestMapping(method=GET)).
    @GetMapping("/greeting")
    // @RequestParam binds the value of the query string parameter* "name" into the "name" parameter
    // of the greeting() method. If the "name" parameter is absent in the request, the default value
    // is used.
    // *The query string is indicated by a '?' in the URL, and when we receive a request for the page,
    // the query string may be passed to our program for use in its processing.
    // So, in this case, we can provide a query string parameter of e.g. "User" like:
    // http://localhost:8080/greeting?name=User
    // and then we use the query string to format our greeting message.
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
