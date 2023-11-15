package mg.tiavina.store.models.mapping;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Store implements Model<Store> {
    int id;
    String code;
    String name;

    @Override
    public void delete(int id, Connection connection) throws SQLException{
        // TODO Auto-generated method stub
        
    }

    @Override
    public void save(Connection connection) throws SQLException{
        // TODO Auto-generated method stub
        
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
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    
}
