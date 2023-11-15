package mg.tiavina.store.models.mapping.views;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mg.tiavina.store.models.mapping.Article;
import mg.tiavina.store.models.mapping.ModelView;
import static mg.tiavina.store.util.PostgreSQLConnection.getConnection;

public class VArticle extends Article implements ModelView<VArticle> {
    String unity;

    public VArticle() {
        super();
    }


    
    @Override
    public List<VArticle> findAllByViews(Connection connection) throws SQLException {
        List<VArticle> models = new ArrayList<>();
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = getConnection();
        } 
        String sql = "SELECT * FROM v_articles";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            System.out.println(stmt.toString());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                VArticle model = new VArticle();
                model.setId(rs.getInt("id"));
                model.setCode(rs.getString("code"));
                model.setName(rs.getString("name"));
                model.setUnityId(rs.getInt("unity_id"));
                model.setType(rs.getInt("type"));
                model.setUnity(rs.getString("unity"));
                models.add(model);
            }
        }

        if (!wasConnected) {
            connection.close();
        }
        return models;
    }

    @Override
    public VArticle findByIdByViews(int id, Connection connection) throws SQLException {
        VArticle model = null;
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = getConnection();
        } 
        String sql = "SELECT * FROM v_articles WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            System.out.println(stmt.toString());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                model = new VArticle();
                model.setId(rs.getInt("id"));
                model.setCode(rs.getString("code"));
                model.setName(rs.getString("name"));
                model.setUnityId(rs.getInt("unity_id"));
                model.setType(rs.getInt("type"));
                model.setUnity(rs.getString("unity"));
            }
        }

        if (!wasConnected) {
            connection.close();
        }
        return model;
    }

    public List<VArticle> findAllFinalArticle(Connection connection) throws SQLException {
        List<VArticle> models = new ArrayList<>();
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = getConnection();
        } 
        String sql = "SELECT * FROM v_articles WHERE type<>0";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            System.out.println(stmt.toString());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                VArticle model = new VArticle();
                model.setId(rs.getInt("id"));
                model.setCode(rs.getString("code"));
                model.setName(rs.getString("name"));
                model.setUnityId(rs.getInt("unity_id"));
                model.setType(rs.getInt("type"));
                model.setUnity(rs.getString("unity"));
                models.add(model);
            }
        }

        if (!wasConnected) {
            connection.close();
        }
        return models;
    }

    public String getUnity() {
        return unity;
    }

    public void setUnity(String unity) {
        this.unity = unity;
    }
    
    

}
