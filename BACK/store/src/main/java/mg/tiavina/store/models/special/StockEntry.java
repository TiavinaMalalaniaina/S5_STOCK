package mg.tiavina.store.models.special;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import mg.tiavina.store.models.exception.QuantityException;
import mg.tiavina.store.models.mapping.Entry;
import mg.tiavina.store.models.mapping.Output;
import mg.tiavina.store.models.mapping.views.VEntry;
import mg.tiavina.store.models.mapping.views.VOutput;


/**
 * relation entre une entrée et de nombreuse sortie
 */
public class StockEntry extends VEntry {
    List<VOutput> outputs;
    double leftQuantity;

    public StockEntry(VEntry entry) {
        this.setId(entry.getId());
        this.setDateEntry(entry.getDateEntry());
        this.setArticleId(entry.getArticleId());
        this.setStoreId(entry.getStoreId());
        this.setQuantity(entry.getQuantity());
        this.setUnitPrice(entry.getUnitPrice());
        this.setCodeArticle(entry.getCodeArticle());
        this.setNameArticle(entry.getNameArticle());
        this.setType(entry.getType());
        this.setUnityId(entry.getUnityId());
        this.setUnity(entry.getUnity());
        this.setCodeStore(entry.getCodeStore());
        this.setNameStore(entry.getNameStore());
        this.setArticle(entry.getArticle());
        this.setStore(entry.getStore());
    }

    public StockEntry findOutput(Connection connection) throws SQLException {
        this.setOutputs(new VOutput().findByEntryId(getId(), connection));
        return this;
    }

    public void setLeft() throws QuantityException {
        double quantityInit = this.getQuantity();
        double outputQuantity = this.getOutputsQuantity();
        double leftQuantity = quantityInit-outputQuantity;
        this.setLeftQuantity(leftQuantity);
    }

    private double getOutputsQuantity() {
        double total = 0;
        for (Output output : this.getOutputs()) {
            total += output.getQuantity();
        }
        return total;
    }

    public List<VOutput> getOutputs() {
        return outputs;
    }

    public void setOutputs(List<VOutput> outputs) {
        this.outputs = outputs;
    }

    public double getLeftQuantity() {
        return leftQuantity;
    }

    public void setLeftQuantity(double leftQuantity) throws QuantityException{
        if (leftQuantity < 0) throw new QuantityException(leftQuantity);
        this.leftQuantity = leftQuantity;
    }

    public void addOutput(VOutput output, Connection connection) throws QuantityException, SQLException {
        this.setLeft();
        double left = this.getLeftQuantity()-output.getQuantity();
        System.out.println("left: "+left+ ";; output:" + output.getQuantity());
        if (this.getLeftQuantity() == 0) throw new QuantityException(output.getQuantity(), output.getQuantity());
        if (left > 0) {
            output.setEntryId(this.getId());
            output.save(connection);
        } else {
            QuantityException ex = new QuantityException(output.getQuantity(), -left);
            output.setEntryId(this.getId());
            output.setQuantity(this.getLeftQuantity());
            output.save(connection);
            throw ex;
        }
    }

    
}
