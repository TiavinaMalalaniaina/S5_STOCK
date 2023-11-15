package mg.tiavina.store.models.mapping;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface Model<T> {
    
    void save(Connection connection)throws SQLException;
    void update(Connection connection)throws SQLException;
    void delete(int id, Connection connection)throws SQLException;

}
