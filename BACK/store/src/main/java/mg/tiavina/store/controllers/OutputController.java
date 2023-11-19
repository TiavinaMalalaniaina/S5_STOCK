package mg.tiavina.store.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mg.tiavina.store.models.mapping.views.VOutput;
import mg.tiavina.store.models.special.Stock;

@RestController
public class OutputController {
    
    @PostMapping("/add-output")
    public void test(@RequestBody VOutput output) {
        try {
            System.out.println(output.getArticleId());
            new Stock().newOutput(output, null);
            System.out.println("DONE");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
