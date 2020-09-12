// This Java source file was generated on 2020-09-11 14:55:02 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.transaction;

import java.time.ZonedDateTime;

public class TransactionPagesResponse {
    private ZonedDateTime from;
    private ZonedDateTime to;
    private Integer pageSize;
    private TransactionFilter[] type;
    private Integer count;
    private String[] pages;
    private String lastTransactionID;

    public ZonedDateTime getFrom() {
        return from;
    }

    public void setFrom(ZonedDateTime from) {
        this.from = from;
    }

    public ZonedDateTime getTo() {
        return to;
    }

    public void setTo(ZonedDateTime to) {
        this.to = to;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public TransactionFilter[] getType() {
        return type;
    }

    public void setType(TransactionFilter[] type) {
        this.type = type;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String[] getPages() {
        return pages;
    }

    public void setPages(String[] pages) {
        this.pages = pages;
    }

    public String getLastTransactionID() {
        return lastTransactionID;
    }

    public void setLastTransactionID(String lastTransactionID) {
        this.lastTransactionID = lastTransactionID;
    }

}
