package com.example.LambdaError;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mac")
class MacController{

    public MacDao md;

    MacController(MacDao md){
        this.md=md;
    }

    public List<Mac> lst= Collections.singletonList(
        new Mac(1L,"c++","22")
    );

    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<Mac> getAll(){
        return md.findAll().stream().map(m->{
            return new Mac(m.id,m.name,m.age);
        }).collect(Collectors.toList());
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Mac getId(@PathVariable Long id) throws CustomExp{
        //return md.findAll().stream().filter(m->m.id.equals(id)).findFirst().get();
        //return md.findById(id).get();
        //md.findById(id).ifPresent(customer->{System.out.println(customer.toString());});

        return md.findById(id)
                .orElseThrow(() -> new CustomExp(id));
    }


    @RequestMapping(value = "",method = RequestMethod.POST)
    public Mac add(@Valid @RequestBody Mac mac){
        return md.save(mac);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Mac update(@PathVariable Long id,@RequestBody Mac mac){
        return md.findById(id)
                .map(m -> {
                    m.setName(mac.name);
                    m.setAge(mac.age);
                    return md.save(m);
                })
                .orElseGet(() -> {
                    mac.setId(id);
                    return md.save(mac);
                });
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        lst.removeIf(m->m.id.equals(id));
    }

    /*@ExceptionHandler(CustomExp.class)
    public String Custom(){
        return "customErr";
    }*/


}
