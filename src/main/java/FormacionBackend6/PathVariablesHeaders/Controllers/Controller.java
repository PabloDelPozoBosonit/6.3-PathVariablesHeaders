package FormacionBackend6.PathVariablesHeaders.Controllers;

import FormacionBackend6.PathVariablesHeaders.Greeting.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class Controller {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @PostMapping("json")
    public Greeting returnJson(@RequestBody Greeting greeting) {

        return greeting;
    }

    @PostMapping("user/{id}")
    public void addUser(@PathVariable long id) {
        System.out.println("User added");
    }

    @PutMapping()
    public String put(@RequestParam(value = "var1", defaultValue = "No existen variables")String var1){
        return "Valor de la variable: " + var1;
    }
}
