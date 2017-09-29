package com.target.retailproduct.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {

	@JsonProperty("online_description")
	private OnlineDescription onlineDescription;

	public OnlineDescription getOnlineDescription() {
		return onlineDescription;
	}

	public void setOnlineDescription(OnlineDescription onlineDescription) {
		this.onlineDescription = onlineDescription;
	}
}
