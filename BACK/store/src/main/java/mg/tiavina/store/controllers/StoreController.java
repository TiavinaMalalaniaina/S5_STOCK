package mg.tiavina.store.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import mg.tiavina.store.models.mapping.views.VStore;
import mg.tiavina.store.util.MyJSON;

@RestController
public class StoreController {
    
    @GetMapping("/stores")
    public MyJSON find() throws JsonProcessingException {
        MyJSON json = new MyJSON();
        try {
            json.setData(new VStore().findAllByViews(null));
        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
        }
        return json;
    }

}
