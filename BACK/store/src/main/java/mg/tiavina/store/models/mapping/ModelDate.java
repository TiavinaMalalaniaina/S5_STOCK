package mg.tiavina.store.models.mapping;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public interface ModelDate<T> {
    
    List<T> findBefore(Date date, Connection connection);
    List<T> findBetween(Date date, Connection connection);
    List<T> findAfter(Date date, Connection connection);

}
