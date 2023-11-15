package mg.tiavina.store.models.mapping.functions;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static mg.tiavina.store.util.PostgreSQLConnection.getConnection;

public class FStock {
    int articleId;
    String articleName;
    String articleCode;
    int storeId;
    String storeName;
    String storeCode;
    double quantity;
    Date stockDate;

    public List<FStock> findOn(Date dateStock, Connection connection) throws SQLException {
        List<FStock> models = new ArrayList<>();
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = getConnection();
        }
        String sql = "SELECT * FROM f_stock(?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, dateStock);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                FStock model = new FStock();
                model.setArticleId(rs.getInt("article_id"));
                model.setArticleName(rs.getString("name_article"));
                model.setArticleCode(rs.getString("code_article"));
                model.setStoreId(rs.getInt("store_id"));
                model.setStoreName(rs.getString("name_store"));
                model.setStoreCode(rs.getString("code_store"));
                model.setQuantity(rs.getDouble("quantity"));
                model.setStockDate(rs.getDate("date_stock"));
                models.add(model);
            }
        }

        if (!wasConnected) {
            connection.close();
        }
        return models;
    }





    public int getArticleId() {
        return articleId;
    }
    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }
    public String getArticleName() {
        return articleName;
    }
    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }
    public String getArticleCode() {
        return articleCode;
    }
    public void setArticleCode(String articleCode) {
        this.articleCode = articleCode;
    }
    public int getStoreId() {
        return storeId;
    }
    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }
    public String getStoreName() {
        return storeName;
    }
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
    public String getStoreCode() {
        return storeCode;
    }
    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }
    public double getQuantity() {
        return quantity;
    }
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    public Date getStockDate() {
        return stockDate;
    }
    public void setStockDate(Date stockDate) {
        this.stockDate = stockDate;
    }

    

}
