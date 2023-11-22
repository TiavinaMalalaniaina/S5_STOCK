package mg.tiavina.store.models.special;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mg.tiavina.store.models.exception.QuantityException;
import mg.tiavina.store.models.mapping.views.VEntry;
import mg.tiavina.store.models.mapping.views.VOutput;

import static mg.tiavina.store.util.PostgreSQLConnection.getConnection;

/**
 * 
 */
public class Stock {
    List<StockEntry> stockEntries;

    public List<StockEntry> findByArticleAndStore(int articleId, int storeId, Connection connection) throws SQLException{
        List<StockEntry> models = new ArrayList<>();
        List<VEntry> entries = new VEntry().findByStoreAndArticle(articleId, storeId, connection);
        for (VEntry entry : entries) {
            System.out.println(entry.getId());
            StockEntry model = new StockEntry(entry).findOutput(connection);
            models.add(model);
        }
        return models;
    }

    public Stock findStock(VOutput output, Connection connection) throws SQLException {
        return this.findStock(output.getArticleId(), output.getStoreId(), connection);
    }

    public Stock findStock(int articleId, int storeId, Connection connection) throws SQLException {
        this.setStockEntries(this.findByArticleAndStore(articleId, storeId, connection));
        return this;
    }

    public void newOutput(VOutput output, Connection connection) throws SQLException, QuantityException{
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = getConnection();
        }
        try {
            this.findStock(output, connection);
            this.newOutput(output, connection, 0);
        } catch (IndexOutOfBoundsException ex) {
            throw ex;//TODO change to quantityException
        } finally {
            if (!wasConnected) {
                connection.close();
            }
        }
    }
    
    public void newOutput(VOutput output, Connection connection, int index) throws SQLException, QuantityException, IndexOutOfBoundsException {
        try {
            this.getStockEntries().get(index).addOutput(output, connection);
        } catch (QuantityException ex) {
            output.setQuantity(ex.getLeft());
            this.newOutput(output, connection, index+1);
        }
    }

    public List<StockEntry> getStockEntries() {
        return stockEntries;
    }

    public void setStockEntries(List<StockEntry> stockEntries) {
        this.stockEntries = stockEntries;
    }

    public Stock checkQuantity(VOutput output) throws QuantityException{
        double quantity = this.getLeftQuantity();
        if (quantity - output.getQuantity() < 0) {
            throw new QuantityException();
        }
        return this;
    }

    public double getLeftQuantity() {
        double total = 0;
        for (StockEntry stockEntry : this.getStockEntries()) {
            total += stockEntry.getLeftQuantity();
        }
        return total;
    }
    
    
}
