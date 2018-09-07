
package test;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "className",
    "event",
    "value",
    "timestamp",
    "transactionData",
    "terminal"
})
public class DeviceEvent implements Serializable
{

    @JsonProperty("id")
    private String id;
    @JsonProperty("className")
    private String className;
    @JsonProperty("event")
    private String event;
    @JsonProperty("value")
    private String value;
    @JsonProperty("timestamp")
    private String timestamp;
    @JsonProperty("transactionData")
    private TransactionData transactionData;
    @JsonProperty("terminal")
    private Terminal terminal;
    private final static long serialVersionUID = 8042052010074568121L;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("className")
    public String getClassName() {
        return className;
    }

    @JsonProperty("className")
    public void setClassName(String className) {
        this.className = className;
    }

    @JsonProperty("event")
    public String getEvent() {
        return event;
    }

    @JsonProperty("event")
    public void setEvent(String event) {
        this.event = event;
    }

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonProperty("timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty("transactionData")
    public TransactionData getTransactionData() {
        return transactionData;
    }

    @JsonProperty("transactionData")
    public void setTransactionData(TransactionData transactionData) {
        this.transactionData = transactionData;
    }

    @JsonProperty("terminal")
    public Terminal getTerminal() {
        return terminal;
    }

    @JsonProperty("terminal")
    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

}
