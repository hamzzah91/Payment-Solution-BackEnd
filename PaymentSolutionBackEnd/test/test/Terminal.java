
package test;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "terminalId",
    "branchId"
})
public class Terminal implements Serializable
{

    @JsonProperty("terminalId")
    private String terminalId;
    @JsonProperty("branchId")
    private String branchId;
    @JsonProperty("platform")
    private String platform;
    private final static long serialVersionUID = 628803175220784829L;

    @JsonProperty("terminalId")
    public String getTerminalId() {
        return terminalId;
    }

    @JsonProperty("terminalId")
    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    @JsonProperty("branchId")
    public String getBranchId() {
        return branchId;
    }

    @JsonProperty("branchId")
    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }
    @JsonProperty("platform")
	public String getPlatform() {
		return platform;
	}
	@JsonProperty("platform")
	public void setPlatform(String platform) {
		this.platform = platform;
	}

}
