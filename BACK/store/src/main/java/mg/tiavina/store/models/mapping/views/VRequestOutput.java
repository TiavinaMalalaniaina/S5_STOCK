package mg.tiavina.store.models.mapping.views;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mg.tiavina.store.models.exception.QuantityException;
import mg.tiavina.store.models.mapping.ModelView;
import mg.tiavina.store.models.mapping.RequestOutput;
import static mg.tiavina.store.util.PostgreSQLConnection.getConnection;

public class VRequestOutput extends RequestOutput implements ModelView<VRequestOutput> {
    String name;
    String articleName;
    String articleCode;
    int type;
    int unityId;
    String unity;
    String storeName;
    String storeCode;

    
    public void validate(Connection connection) throws Exception {
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = getConnection();
        } 
        connection.setAutoCommit(false);
        try {
            VOutput output = new VOutput();
            output.setArticleId(this.getArticleId());
            output.setStoreId(this.getStoreId());
            output.setDateOutput(this.getValidationDate());
            output.setQuantity(this.getQuantity());
            System.out.println("==>"+output);
            output.validation(connection);
            this.setState(20);
            this.updateValidation(connection);
            connection.commit();
            
        }
        catch (Exception ex) {
            connection.rollback();
            if (!wasConnected) {
                connection.close();
            }
            throw ex;
        }
        if (!wasConnected) {
            connection.close();
        }
    }
    
    @Override
    public String toString() {
        return "VRequestOutput [id="+this.getId()+", validationDate="+this.getValidationDate()+",articleId="+ this.getArticleId() +" articleName=" + articleName + ", articleCode=" + articleCode + ", storeName="
                + storeName + ", storeId="+getStoreId()+"]";
    }
    @Override
    public List<VRequestOutput> findAllByViews(Connection connection) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }
    public List<VRequestOutput> findAllNotValidatedByViews(Connection connection) throws SQLException {
        List<VRequestOutput> models = new ArrayList<>();
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = getConnection();
        } 
        String sql = "SELECT * FROM v_request_outputs_not_validated";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            System.out.println(stmt.toString());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                VRequestOutput model = new VRequestOutput();
                model.setId(rs.getInt("id"));
                model.setArticleCode(rs.getString("article_code"));
                model.setArticleName(rs.getString("article_name"));
                model.setStoreCode(rs.getString("store_code"));
                model.setStoreName(rs.getString("store_name"));
                model.setQuantity(rs.getDouble("quantity"));
                model.setArticleId(rs.getInt("article_id"));
                model.setStoreId(rs.getInt("store_id"));
                model.setName();
                models.add(model);
            }
        }

        if (!wasConnected) {
            connection.close();
        }
        return models;
    }
    @Override
    public VRequestOutput findByIdByViews(int id, Connection connection) throws SQLException {
        VRequestOutput model = new VRequestOutput();
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = getConnection();
        } 
        String sql = "SELECT * FROM v_request_outputs_not_validated WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            System.out.println(stmt.toString());
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.setId(rs.getInt("id"));
                model.setArticleCode(rs.getString("article_code"));
                model.setArticleName(rs.getString("article_name"));
                model.setStoreCode(rs.getString("store_code"));
                model.setStoreName(rs.getString("store_name"));
                model.setQuantity(rs.getDouble("quantity"));
                model.setArticleId(rs.getInt("article_id"));
                model.setStoreId(rs.getInt("store_id"));
                model.setName();
            }
        }

        if (!wasConnected) {
            connection.close();
        }
        return model;
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
    public void setName() {
        this.name = String.format("%s:%s:%s;%s;%s",this.getArticleId(), this.getArticleName(), this.getArticleCode(), this.getStoreName(), this.getQuantity());
    }
    public String getName() {
        return this.name;
    }

}
