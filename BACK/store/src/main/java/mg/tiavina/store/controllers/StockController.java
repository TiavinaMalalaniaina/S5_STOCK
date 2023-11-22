package mg.tiavina.store.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mg.tiavina.store.models.display.StockFilter;
import mg.tiavina.store.models.mapping.functions.FStockBetween;
import mg.tiavina.store.util.MyJSON;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StockController {

    @PostMapping("stocks")
    public MyJSON get(@RequestBody StockFilter filter) {
        System.out.println(filter.toString());
        MyJSON json = new MyJSON();
        try {
            List<FStockBetween> models = new FStockBetween().findOn(filter.getStart(), filter.getEnd(), filter.getArticleId(), filter.getStoreId(), null);
            json.setData(models);
        } catch (Exception e) {
            json.setError(e.getMessage());
        }
        return json;
    }

    @PostMapping("stocks-final")
    public MyJSON get2(@RequestBody StockFilter filter) {
        System.out.println(filter.toString());
        MyJSON json = new MyJSON();
        try {
            System.out.println("STOCKS");
            
            FStockBetween model = new FStockBetween().find(filter.getStart(), filter.getEnd(), filter.getArticleId(), filter.getStoreId(), null);
            List<FStockBetween> models = new ArrayList<>();
            models.add(model);
            json.setData(models);
        } catch (Exception e) {
            json.setError(e.getMessage());
        }
        return json;
    }
}
