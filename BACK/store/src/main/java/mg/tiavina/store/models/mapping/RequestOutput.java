package mg.tiavina.store.models.mapping;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.catalina.connector.Connector;

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

    public void validate(Connection connection) throws Exception {
        connection.setAutoCommit(false);
        try {
            VOutput output = new VOutput();
            output.setArticleId(this.getArticleId());
            output.setStoreId(this.getStoreId());
            output.setDateOutput(this.getValidationDate());
            output.validation(connection);
            this.updateValidation(connection);
            connection.commit();
        } catch (Exception ex) {
            connection.rollback();
            throw ex;
        }
    }

    // public void validate(Date validationDate, Connection connection) throws SQLException {
    //     connection.setAutoCommit(false);
    //     try {
    //         Output output = new Output();
    //         output.setDateOutput(this.getRequestDate());
    //         output.setQuantity(this.getQuantity());
    //         output.setArticleId(this.getArticleId());
    //         output.setStoreId(this.getStoreId());
    //         this.setValidationDate(validationDate);
    //         this.setState(20);
    //         this.updateValidation(connection);
    //         connection.commit();
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         connection.rollback();
    //     }
    // }

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
        String sql = "INSERT INTO \"public\".request_outputs ( id, request_date, quantity, article_id, store_id, validation_date, \"state\") VALUES ( default, ?, ?, ?, ?, ?, default ) RETURNING id";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            System.out.println(stmt.toString());
            stmt.executeUpdate();
            stmt.setDate(1, this.getRequestDate());
            stmt.setDouble(2, this.getQuantity());
            stmt.setInt(3, this.getArticleId());
            stmt.setInt(4, this.getStoreId());
            stmt.setDate(5, null);
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
