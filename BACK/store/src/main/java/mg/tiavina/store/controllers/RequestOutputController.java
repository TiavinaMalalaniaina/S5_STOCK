package mg.tiavina.store.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mg.tiavina.store.models.mapping.RequestOutput;
import mg.tiavina.store.models.mapping.views.VOutput;
import mg.tiavina.store.models.special.Stock;

@RestController
public class RequestOutputController {
    
    @PostMapping("/add-output")
    public void test(@RequestBody RequestOutput output) {
        try {
            output.save(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/validate-request") 
    public void validate(@RequestBody RequestOutput output) {
        try {
            output.validate(null);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
