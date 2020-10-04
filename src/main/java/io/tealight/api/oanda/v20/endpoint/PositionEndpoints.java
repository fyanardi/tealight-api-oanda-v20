package io.tealight.api.oanda.v20.endpoint;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Objects;

import io.tealight.api.oanda.v20.FxTradeContext;
import io.tealight.api.oanda.v20.def.ErrorResponse;
import io.tealight.api.oanda.v20.def.position.PositionCloseRejectResponse;
import io.tealight.api.oanda.v20.def.position.PositionCloseRequest;
import io.tealight.api.oanda.v20.def.position.PositionCloseResponse;
import io.tealight.api.oanda.v20.def.position.PositionsResponse;
import io.tealight.api.oanda.v20.exception.FxTradeException;
import io.tealight.api.oanda.v20.http.HttpMethod;

/**
 * Position endpoints
 * 
 * https://developer.oanda.com/rest-live-v20/position-ep/
 *
 * @author Fredy Yanardi
 */
public class PositionEndpoints {

    private static final String POSITIONS =  "/v3/accounts/%s/positions";
    private static final String OPEN_POSITIONS = "/v3/accounts/%s/openPositions";
    private static final String POSITIONS_INSTRUMENTS = "/v3/accounts/%s/positions/%s";
    private static final String CLOSE_POSITIONS = "/v3/accounts/%s/positions/%s/close";

    private final FxTradeContext fxTradeContext;

    public PositionEndpoints(FxTradeContext fxTradeContext) {
        this.fxTradeContext = fxTradeContext;
    }

    /**
     * List all Positions for an Account. The Positions returned are for every instrument that has
     * had a position during the lifetime of an the Account.
     *
     * @param accountId Account Identifier [required]
     * @return list all Positions for an Account
     * @throws FxTradeException thrown if the request to the fxTrade server is not successful
     * @throws IOException thrown if I/O Exception occurs during the request
     */
    public PositionsResponse getPositions(String accountId) throws FxTradeException,
            IOException {
        Objects.requireNonNull(accountId);

        String endpoint = String.format(POSITIONS, accountId);

        return fxTradeContext.requestEndpoint(endpoint, PositionsResponse.class);
    }

    /**
     * List all open Positions for an Account. An open Position is a Position in an Account that
     * currently has a Trade opened for it.
     *
     * @param accountId Account Identifier [required]
     * @return list all open Positions for an Account
     * @throws FxTradeException thrown if the request to the fxTrade server is not successful
     * @throws IOException thrown if I/O Exception occurs during the request
     */
    public PositionsResponse getOpenPositions(String accountId) throws FxTradeException,
            IOException {
        Objects.requireNonNull(accountId);

        String endpoint = String.format(OPEN_POSITIONS, accountId);

        return fxTradeContext.requestEndpoint(endpoint, PositionsResponse.class);
    }

    /**
     * Get the details of a single Instrument’s Position in an Account. The Position may by open or
     * not.
     *
     * @param accountId Account Identifier [required]
     * @param instrument Name of the Instrument [required]
     * @return the details of a single Instrument’s Position in an Account
     * @throws FxTradeException thrown if the request to the fxTrade server is not successful
     * @throws IOException thrown if I/O Exception occurs during the request
     */
    public PositionsResponse getPositionsByInstrument(String accountId, String instrument)
            throws FxTradeException, IOException {
        Objects.requireNonNull(accountId);
        Objects.requireNonNull(instrument);

        String endpoint = String.format(POSITIONS_INSTRUMENTS, accountId, instrument);

        return fxTradeContext.requestEndpoint(endpoint, PositionsResponse.class);
    }

    /**
     * Closeout the open Position for a specific instrument in an Account.
     *
     * @param accountId Account Identifier [required]
     * @param instrument Name of the Instrument [required]
     * @param positionCloseRequest the PositionCloseRequest instance that specifies the close
     *      request [required]
     * @return Position close response when the position close has been successfully processed.
     * @throws FxTradeException thrown if the request to the fxTrade server is not successful
     * @throws IOException thrown if I/O Exception occurs during the request
     */
    public PositionCloseResponse closePosition(String accountId, String instrument,
            PositionCloseRequest positionCloseRequest) throws FxTradeException, IOException {
        Objects.requireNonNull(accountId);
        Objects.requireNonNull(instrument);
        Objects.requireNonNull(positionCloseRequest);

        String endpoint = String.format(CLOSE_POSITIONS, accountId, instrument);

        return fxTradeContext.requestEndpoint(endpoint, PositionCloseResponse.class, HttpMethod.PUT,
                null, positionCloseRequest,  (httpResponseCode) -> {
                    if (httpResponseCode == HttpURLConnection.HTTP_BAD_REQUEST ||
                            httpResponseCode == HttpURLConnection.HTTP_NOT_FOUND) {
                        return PositionCloseRejectResponse.class;
                    }
                    return ErrorResponse.class;
                });
    }

}
