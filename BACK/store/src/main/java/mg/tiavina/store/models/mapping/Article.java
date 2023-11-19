package mg.tiavina.store.models.mapping;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

public class Article implements Model<Article> {
    public static final int LIFO = 1;
    public static final int FIFO = 2;
    private HashMap<Integer, String> METHODE_TYPE = new HashMap<>();

    int id;
    String code;
    String name;
    int type;
    int unityId;

    public String getOrder() {
        return METHODE_TYPE.get(this.getType());
    }

    private void prepare() {
        METHODE_TYPE.put(LIFO, "DESC");
        METHODE_TYPE.put(FIFO, "ASC");
    }

    public Article() {
        prepare();
    }

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

    
}
