package mg.tiavina.store.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mg.tiavina.store.models.mapping.RequestOutput;
import mg.tiavina.store.models.mapping.views.VOutput;
import mg.tiavina.store.models.mapping.views.VRequestOutput;
import mg.tiavina.store.models.special.Stock;
import mg.tiavina.store.util.MyJSON;

@RestController
public class RequestOutputController {
    
    @PostMapping("/add-output")
    public MyJSON test(@RequestBody RequestOutput output) {
        MyJSON json = new MyJSON();
        try {
            output.save(null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            json.setError(e.getMessage());
        }
        return json;
    }

    @PostMapping("/validate-request") 
    public MyJSON validate(@RequestBody VRequestOutput output) {
        MyJSON json = new MyJSON();
        try {
            VRequestOutput model = new VRequestOutput().findByIdByViews(output.getId(), null);
            model.setValidationDate(output.getValidationDate());
            System.out.println(output.getValidationDate());
            System.out.println(model);
            model.validate(null);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            json.setError(ex.getMessage());
        }
        return json;
    }

    @GetMapping("/requests") 
    public MyJSON validate() {
        MyJSON json = new MyJSON();
        try {
            List<VRequestOutput> models = new VRequestOutput().findAllNotValidatedByViews(null);
            System.out.println(models.size());
            json.setData(models);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            json.setError(ex.getMessage());
        }
        return json;
    }

}
