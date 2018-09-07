package test;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeviceEventParent {

	@JsonProperty("deviceEvent")
	private List<DeviceEvent> deviceEvent;

	@JsonProperty("deviceEvent")
	public List<DeviceEvent> getDeviceEvent() {
		return deviceEvent;
	}

	@JsonProperty("deviceEvent")
	public void setDeviceEvent(List<DeviceEvent> deviceEvent) {
		this.deviceEvent = deviceEvent;
	}
	
}
