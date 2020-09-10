// This Java source file was generated on 2020-09-11 05:48:00 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.order;

import io.tealight.api.oanda.v20.def.transaction.ClientExtensions;

public class ClientExtensionsRequest {
    private ClientExtensions clientExtensions;
    private ClientExtensions tradeClientExtensions;

    public ClientExtensions getClientExtensions() {
        return clientExtensions;
    }

    public void setClientExtensions(ClientExtensions clientExtensions) {
        this.clientExtensions = clientExtensions;
    }

    public ClientExtensions getTradeClientExtensions() {
        return tradeClientExtensions;
    }

    public void setTradeClientExtensions(ClientExtensions tradeClientExtensions) {
        this.tradeClientExtensions = tradeClientExtensions;
    }

}
