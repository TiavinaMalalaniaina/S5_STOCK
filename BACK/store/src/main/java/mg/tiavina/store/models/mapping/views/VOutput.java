package mg.tiavina.store.models.mapping.views;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mg.tiavina.store.models.mapping.Article;
import mg.tiavina.store.models.mapping.ModelDate;
import mg.tiavina.store.models.mapping.ModelView;
import mg.tiavina.store.models.mapping.Output;
import mg.tiavina.store.models.mapping.Store;

import static mg.tiavina.store.util.PostgreSQLConnection.getConnection;

public class VOutput extends Output implements ModelDate<VOutput>,ModelView<VOutput> {
    Date dateEntry;
    double quantityEntry;
    double unitPrice;
    int articleId;
    int storeId;
    String codeArticle;
    String nameArticle;
    int type;
    int unityId;
    String unity;
    String codeStore;
    String nameStore;
    Article article;
    Store store;

    public List<VOutput> findByEntryId(int entryId, Connection connection) throws SQLException {
        List<VOutput> models = new ArrayList<>();
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = getConnection();
        } 
        String sql = "SELECT * FROM v_outputs WHERE entry_id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, entryId);
            System.out.println(stmt.toString());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                VOutput model = new VOutput();
                model.setId(rs.getInt("id"));
                model.setDateOutput(rs.getDate("date_output"));
                model.setQuantity(rs.getDouble("quantity"));
                model.setEntryId(rs.getInt("entry_id"));
                model.setQuantityEntry(rs.getDouble("quantity_entry"));
                model.setUnitPrice(rs.getDouble("unit_price"));
                model.setArticleId(rs.getInt("article_id"));
                model.setStoreId(rs.getInt("store_id"));
                model.setCodeArticle(rs.getString("code_article"));
                model.setNameArticle(rs.getString("name_article"));
                model.setType(rs.getInt("type"));
                model.setUnityId(rs.getInt("unity_id"));
                model.setUnity(rs.getString("unity"));
                model.setCodeStore(rs.getString("code_store"));
                model.setNameStore(rs.getString("name_store"));
                models.add(model);
            }
        }

        if (!wasConnected) {
            connection.close();
        }
        return models;
    }

    @Override
    public List<VOutput> findAllByViews(Connection connection) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public VOutput findByIdByViews(int id, Connection connection) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public List<VOutput> findAfter(Date date, Connection connection) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public List<VOutput> findBefore(Date date, Connection connection) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public List<VOutput> findBetween(Date date, Connection connection) {
        // TODO Auto-generated method stub
        return null;
    }
    public double getQuantityEntry() {
        return quantityEntry;
    }
    public void setQuantityEntry(double quantityEntry) {
        this.quantityEntry = quantityEntry;
    }
    public double getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
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
    public String getCodeArticle() {
        return codeArticle;
    }
    public void setCodeArticle(String codeArticle) {
        this.codeArticle = codeArticle;
    }
    public String getNameArticle() {
        return nameArticle;
    }
    public void setNameArticle(String nameArticle) {
        this.nameArticle = nameArticle;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public int getUnityId() {
        return unityId;
    }
    public void setUnityId(int unityId) {
        this.unityId = unityId;
    }
    public String getUnity() {
        return unity;
    }
    public void setUnity(String unity) {
        this.unity = unity;
    }
    public String getCodeStore() {
        return codeStore;
    }
    public void setCodeStore(String codeStore) {
        this.codeStore = codeStore;
    }
    public String getNameStore() {
        return nameStore;
    }
    public void setNameStore(String nameStore) {
        this.nameStore = nameStore;
    }
    public Article getArticle() {
        return article;
    }
    public void setArticle(Article article) {
        this.article = article;
    }
    public Store getStore() {
        return store;
    }
    public void setStore(Store store) {
        this.store = store;
    }

    public Date getDateEntry() {
        return dateEntry;
    }

    public void setDateEntry(Date dateEntry) {
        this.dateEntry = dateEntry;
    }
    
}
