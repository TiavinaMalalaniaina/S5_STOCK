package mg.tiavina.store.models.mapping;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.catalina.connector.Connector;

import mg.tiavina.store.models.exception.QuantityException;
import mg.tiavina.store.models.mapping.views.VOutput;

import static mg.tiavina.store.util.PostgreSQLConnection.getConnection;

public class RequestOutput implements Model<RequestOutput> {
    int id;
    Date requestDate;
    double quantity;
    int articleId;
    int storeId;
    Date validationDate;
    int state;


   

    @Override
    public void delete(int id, Connection connection) throws SQLException {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void save(Connection connection) throws SQLException {
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = getConnection();
        } 
        String sql = "INSERT INTO \"public\".request_outputs ( id, quantity, article_id, store_id, \"state\") VALUES ( default, ?, ?, ?, default ) RETURNING id";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            System.out.println(stmt.toString());
            stmt.setDouble(1, this.getQuantity());
            stmt.setInt(2, this.getArticleId());
            stmt.setInt(3, this.getStoreId());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                this.setId(rs.getInt("id"));
            }
        }

        if (!wasConnected) {
            connection.close();
        }
        
    }
    @Override
    public void update(Connection connection) throws SQLException {
        // TODO Auto-generated method stub
        
    }

    public void updateValidation(Connection connection) throws SQLException {
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = getConnection();
        } 
        String sql = "UPDATE request_outputs SET validation_date=?,state=? WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            System.out.println(stmt.toString());
            stmt.setDate(1, this.getValidationDate());
            stmt.setInt(2, this.getState());
            stmt.setInt(3, this.getId());
            stmt.executeUpdate();
        }

        if (!wasConnected) {
            connection.close();
        }
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Date getRequestDate() {
        return requestDate;
    }
    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }
    public double getQuantity() {
        return quantity;
    }
    public void setQuantity(double quantity) {
        this.quantity = quantity;
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
    public Date getValidationDate() {
        return validationDate;
    }
    public void setValidationDate(Date validationDate) {
        this.validationDate = validationDate;
    }
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }



    
}
