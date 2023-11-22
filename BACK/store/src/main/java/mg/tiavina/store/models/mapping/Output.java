package mg.tiavina.store.models.mapping;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static mg.tiavina.store.util.PostgreSQLConnection.getConnection;

public class Output implements Model<Output> {
    int id;
    Date dateOutput;
    double quantity;
    int entryId;

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
        String sql = "INSERT INTO \"public\".outputs ( id, date_output, quantity, entry_id) VALUES ( default, ?, ?, ? ) RETURNING id";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, this.getDateOutput());
            stmt.setDouble(2, this.getQuantity());
            stmt.setInt(3, this.getEntryId());
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
    public void update(Connection connection) throws SQLException {
        // TODO Auto-generated method stub
    }

    public Date getDateOutput() {
        return dateOutput;
    }

    public void setDateOutput(Date dateOutput) {
        this.dateOutput = dateOutput;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public int getEntryId() {
        return entryId;
    }

    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }

    
}
