package mg.tiavina.store.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mg.tiavina.store.models.mapping.views.VArticle;
import mg.tiavina.store.util.MyJSON;

@RestController
public class ArticleController {
    
    @GetMapping("/articles-fini")
    public MyJSON findFinaux() {
        MyJSON json = new MyJSON();
        try {
            json.setData(new VArticle().findAllFinalArticle(null));
        } catch (Exception e) {
            System.err.println(e);
        }
        return json;
    }

    @GetMapping("/articles")
    public MyJSON findall() {
        MyJSON json = new MyJSON();
        try {
            json.setData(new VArticle().findAllByViews(null));
        } catch (Exception e) {
            System.err.println(e);
        }
        return json;
    }

}
