
package test;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "transactionType",
    "transactionNumber",
    "sessionId"
})
public class TransactionData implements Serializable
{

    @JsonProperty("transactionType")
    private String transactionType;
    @JsonProperty("transactionNumber")
    private String transactionNumber;
    @JsonProperty("sessionId")
    private String sessionId;
    private final static long serialVersionUID = 3497813334106387968L;

    @JsonProperty("transactionType")
    public String getTransactionType() {
        return transactionType;
    }

    @JsonProperty("transactionType")
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    @JsonProperty("transactionNumber")
    public String getTransactionNumber() {
        return transactionNumber;
    }

    @JsonProperty("transactionNumber")
    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    @JsonProperty("sessionId")
    public String getSessionId() {
        return sessionId;
    }

    @JsonProperty("sessionId")
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

}
