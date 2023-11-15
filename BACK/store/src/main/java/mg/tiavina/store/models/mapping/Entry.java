package mg.tiavina.store.models.mapping;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class Entry implements Model<Entry> {
    int id;
    Date dateEntry;
    int articleId;
    int storeId;
    double quantity;
    double unitPrice;

    public Entry() {}
    public Entry(int articleId, int storeId) {
        this.setArticleId(articleId);
        this.setStoreId(storeId);
    }

    @Override
    public void delete(int id, Connection connection) throws SQLException{
        // TODO Auto-generated method stub
        
    }

    @Override
    public void save(Connection connection) throws SQLException{
        // TODO Auto-generated method stub
        
    }

    @Override
    public void update(Connection connection) throws SQLException{
        // TODO Auto-generated method stub
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateEntry() {
        return dateEntry;
    }

    public void setDateEntry(Date dateEntry) {
        this.dateEntry = dateEntry;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }


    

}

