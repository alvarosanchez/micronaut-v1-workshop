package hello.galaxy

import groovy.transform.CompileStatic
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@CompileStatic
@Controller("/hello")
class HelloController {

//tag::action[]
    @Get("/")
    String index() {
        return "Hello Galaxy!"
    }
//end::action[]
    
}