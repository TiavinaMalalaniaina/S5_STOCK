package mg.tiavina.store.models.display;

import java.sql.Date;

public class StockFilter {
    Date start;
    Date end;
    int articleId;
    int storeId;

    @Override
    public String toString() {
        return String.format("start: %s;; end: %s;; articleId: %s;; storeId: %s", start, end, articleId, storeId);
    }
    
    public Date getStart() {
        return start;
    }
    public void setStart(Date start) {
        this.start = start;
    }
    public Date getEnd() {
        return end;
    }
    public void setEnd(Date end) {
        this.end = end;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }
   
    
}
