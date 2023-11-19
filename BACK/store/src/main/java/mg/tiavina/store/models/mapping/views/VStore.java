package mg.tiavina.store.models.mapping.views;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mg.tiavina.store.models.mapping.ModelView;
import mg.tiavina.store.models.mapping.Store;

import static mg.tiavina.store.util.PostgreSQLConnection.getConnection;

public class VStore extends Store implements ModelView<VStore> {

    @Override
    public List<VStore> findAllByViews(Connection connection) throws SQLException {
        List<VStore> models = new ArrayList<>(); 
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = getConnection();
        } 
        String sql = "SELECT * FROM v_stores";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            System.out.println(stmt.toString());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                VStore model = new VStore();
                model.setId(rs.getInt("id"));
                model.setCode(rs.getString("code"));
                model.setName(rs.getString("name"));
                models.add(model);
            }
        }

        if (!wasConnected) {
            connection.close();
        }
        return models;
    }

    @Override
    public VStore findByIdByViews(int id, Connection connection) throws SQLException {
        VStore model = null;
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = getConnection();
        } 
        String sql = "SELECT * FROM v_stores WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            System.out.println(stmt.toString());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                model = new VStore();
                model.setId(rs.getInt("id"));
                model.setCode(rs.getString("code"));
                model.setName(rs.getString("name"));
            }
        }

        if (!wasConnected) {
            connection.close();
        }
        return model;
    }
    


}
