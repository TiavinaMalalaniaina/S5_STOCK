package mg.tiavina.store.models.mapping.functions;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mg.tiavina.store.models.mapping.views.VArticle;
import mg.tiavina.store.models.mapping.views.VStore;

import static mg.tiavina.store.util.PostgreSQLConnection.getConnection;

public class FStockBetween {
    int articleId;
    String articleName;
    String articleCode;
    int storeId;
    String unity;
    String storeCode;
    String storeName;
    double quantityInit;
    double quantityFinal;
    double quantityEntry;
    double quantityOutput;
    double amountInit;
    double amountFinal;

    public List<FStockBetween> findOn(Date dateInit, Date dateFinal, int articleId, int storeId, Connection connection) throws SQLException {
        List<FStockBetween> models = new ArrayList<>();
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = getConnection();
        }
        VArticle article = new VArticle().findByIdByViews(articleId, connection);
        VStore store = new VStore().findByIdByViews(storeId, connection);
        models = findOn(dateInit, dateFinal, article.getCode(), store.getCode(), connection);
        if (!wasConnected) {
            connection.close();
        }
        return models;
    }
    
    public List<FStockBetween> findOn(Date dateInit, Date dateFinal, String articleCode, String storeCode, Connection connection) throws SQLException {
        List<FStockBetween> models = new ArrayList<>();
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = getConnection();
        }
        String sql = "SELECT * FROM f_stocks_between(?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, dateInit);
            stmt.setDate(2, dateFinal);
            stmt.setString(3, articleCode);
            stmt.setString(4, storeCode);
            System.out.println(stmt.toString());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                FStockBetween model = new FStockBetween();
                model.setArticleId(rs.getInt("article_id"));
                model.setArticleName(rs.getString("article_name"));
                model.setArticleCode(rs.getString("article_code"));
                model.setStoreId(rs.getInt("store_id"));
                model.setStoreName(rs.getString("store_name"));
                model.setStoreCode(rs.getString("store_code"));
                model.setQuantityInit(rs.getDouble("quantity_init"));
                model.setQuantityFinal(rs.getDouble("quantity_final"));
                model.setQuantityEntry(rs.getDouble("quantity_entry"));
                model.setQuantityOutput(rs.getDouble("quantity_output"));
                model.setAmountInit(rs.getDouble("amount_init"));
                model.setAmountFinal(rs.getDouble("amount_final"));
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


    public String getStoreCode() {
        return storeCode;
    }


    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }


    public String getStoreName() {
        return storeName;
    }


    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }


    public double getQuantityInit() {
        return quantityInit;
    }


    public void setQuantityInit(double quantityInit) {
        this.quantityInit = quantityInit;
    }


    public double getQuantityFinal() {
        return quantityFinal;
    }


    public void setQuantityFinal(double quantityFinal) {
        this.quantityFinal = quantityFinal;
    }


    public double getQuantityEntry() {
        return quantityEntry;
    }


    public void setQuantityEntry(double quantityEntry) {
        this.quantityEntry = quantityEntry;
    }


    public double getQuantityOutput() {
        return quantityOutput;
    }


    public void setQuantityOutput(double quantityOutput) {
        this.quantityOutput = quantityOutput;
    }


    public double getAmountInit() {
        return amountInit;
    }


    public void setAmountInit(double amountInit) {
        this.amountInit = amountInit;
    }


    public double getAmountFinal() {
        return amountFinal;
    }


    public void setAmountFinal(double amountFinal) {
        this.amountFinal = amountFinal;
    }

    public String getUnity() {
        return unity;
    }

    public void setUnity(String unity) {
        this.unity = unity;
    }


    
}
