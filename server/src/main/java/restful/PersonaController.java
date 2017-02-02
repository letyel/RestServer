package restful;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {

    private static final String template = "%s";
    private final AtomicLong counter = new AtomicLong();
    List<Persona> personas = new ArrayList<>();

    public PersonaController(){

        Persona persona = new Persona(1, "Gabriel");
        personas.add(persona);
        persona = new Persona(2, "Daniel");
        personas.add(persona);
        persona = new Persona(3, "Daniela");
        personas.add(persona);


    }
/*
    @RequestMapping("/persona")
    public Persona persona(@RequestParam(value="nombre", defaultValue="No name") String nombre) {
        return new Persona(counter.incrementAndGet(),
                String.format(template, nombre));
    }*/
    @RequestMapping("/persona")
    public List<Persona> persona(@RequestParam(value="nombre", defaultValue="") String nombre) {

        if(nombre.isEmpty())
        {
            return personas;
        }
        else {
            Persona persona = new Persona(personas.size() + 1, String.format(template, nombre));
            personas.add(persona);
            return personas;
        }
    }

}