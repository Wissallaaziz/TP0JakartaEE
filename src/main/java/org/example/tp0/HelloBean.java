package org.example.tp0;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

/** Managed bean JSF (CDI @Named) utilisé par la page index.xhtml. */
@Named
@RequestScoped
public class HelloBean implements Serializable {

    @Inject
    private GreetingService greetingService;

    private String name;
    private String message;

    public void sayHello() {
        message = greetingService.greet(name);
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getMessage() { return message; }
}
