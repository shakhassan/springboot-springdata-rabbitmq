package my.winapp.springdatabootrabbitmqsender.domain;

import java.util.UUID;

public class JSONCustomMessage {
	
	private UUID userUUID;
	private String phoneNumber;
	
	public UUID getUserUUID() {
		return userUUID;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public JSONCustomMessage(UUID userUUID, String phoneNumber) {
		super();
		this.userUUID = userUUID;
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		
		//return super.toString();
		
		return "CustomMessage{" +
		      "userUUID='" + userUUID +
		      "', phoneNumber='" + phoneNumber + '\'' +
		      '}';
	}

}
