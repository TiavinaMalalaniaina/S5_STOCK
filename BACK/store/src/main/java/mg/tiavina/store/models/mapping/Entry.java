package mg.tiavina.store.models.mapping;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static mg.tiavina.store.util.PostgreSQLConnection.getConnection;

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
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = getConnection();
        } 
        String sql = "INSERT INTO \"public\".entries ( id, date_entry, quantity, article_id, store_id, unit_price ) VALUES ( default, ?, ?, ?, ?, ? ) RETURNING id";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, this.getDateEntry());
            stmt.setDouble(2, this.getQuantity());
            stmt.setInt(3, this.getArticleId());
            stmt.setInt(4, this.getStoreId());
            stmt.setDouble(5, this.getUnitPrice());
            System.out.println(stmt.toString());
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

