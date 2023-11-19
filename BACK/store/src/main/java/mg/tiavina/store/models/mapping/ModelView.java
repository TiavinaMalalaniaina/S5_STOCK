package mg.tiavina.store.models.mapping;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ModelView<T> {
    List<T> findAllByViews(Connection connection) throws SQLException;
    T findByIdByViews(int id, Connection connection) throws SQLException;
}
