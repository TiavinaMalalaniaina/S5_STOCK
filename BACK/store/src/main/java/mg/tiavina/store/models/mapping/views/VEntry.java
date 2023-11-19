package mg.tiavina.store.models.mapping.views;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import mg.tiavina.store.models.mapping.ModelDate;
import mg.tiavina.store.models.mapping.ModelView;
import mg.tiavina.store.models.mapping.Store;
import mg.tiavina.store.models.mapping.Article;
import mg.tiavina.store.models.mapping.Entry;

import static mg.tiavina.store.util.PostgreSQLConnection.getConnection;

public class VEntry extends Entry implements ModelDate<VEntry>, ModelView<VEntry> {
    double unitPrice;
    String codeArticle;
    String nameArticle;
    int type;
    int unityId;
    String unity;
    String codeStore;
    String nameStore;
    Article article;
    Store store;

    public VEntry() {
        super();
    }
    public VEntry(int articleId, int storeId) {
        super(articleId, storeId);
    }

    public List<VEntry> findByStoreAndArticle(int articleId, int storeId, Connection connection) throws SQLException{
        VArticle article = new VArticle().findByIdByViews(articleId, connection);
        List<VEntry> models = new ArrayList<>();
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = getConnection();
        } 
        String sql = "SELECT * FROM v_entries WHERE article_id=? AND store_id=? ";
        sql += String.format("ORDER BY date_entry %s", article.getOrder());
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, articleId);
            stmt.setInt(2, storeId);
            System.out.println(stmt.toString());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                VEntry model = new VEntry();
                model.setId(rs.getInt("id"));
                model.setDateEntry(rs.getDate("date_entry"));
                model.setQuantity(rs.getDouble("quantity"));
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
    public List<VEntry> findAfter(Date date, Connection connection) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public List<VEntry> findBefore(Date date, Connection connection) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public List<VEntry> findBetween(Date date, Connection connection) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public List<VEntry> findAllByViews(Connection connection) throws SQLException{
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public VEntry findByIdByViews(int id, Connection connection) throws SQLException{
        // TODO Auto-generated method stub
        return null;
    }
    public double getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
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

    


}
