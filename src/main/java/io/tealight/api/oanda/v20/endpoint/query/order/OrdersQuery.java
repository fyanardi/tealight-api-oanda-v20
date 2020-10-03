package io.tealight.api.oanda.v20.endpoint.query.order;

import java.util.List;

import io.tealight.api.oanda.v20.def.order.OrderStateFilter;

public class OrdersQuery {

    /**
     * List of Order IDs to retrieve
     * type: List of OrderID (csv)
     */
    private List<String> ids;

    /**
     * The state to filter the requested Orders by [default=PENDING]
     * type: OrderStateFilter
     */
    private OrderStateFilter state;

    /**
     * The instrument to filter the requested orders by
     * type: InstrumentName
     */
    private String instrument;

    /**
     * The maximum number of Orders to return [default=50, maximum=500]
     * type: integer
     */
    private Integer count;

    /**
     * The maximum Order ID to return. If not provided the most recent Orders in the Account are
     * returned
     * type: OrderID
     */
    private String beforeID;

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public OrderStateFilter getState() {
        return state;
    }

    public void setState(OrderStateFilter state) {
        this.state = state;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getBeforeID() {
        return beforeID;
    }

    public void setBeforeID(String beforeID) {
        this.beforeID = beforeID;
    }
}
