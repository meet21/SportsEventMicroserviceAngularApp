package com.cognizant.participationMicroservice.utilModel;

public class PlayerResponse {
	private String playerName;
	private int age;
	private long contactNumber;
	private String email;
	private String gender;
	private String sportsName;
	private String eventName;

	public PlayerResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlayerResponse(String playerName, int age, long contactNumber, String email, String gender, String sportsName,
			String eventName) {
		super();
		this.playerName = playerName;
		this.age = age;
		this.contactNumber = contactNumber;
		this.email = email;
		this.gender = gender;
		this.sportsName = sportsName;
		this.eventName = eventName;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSportsName() {
		return sportsName;
	}

	public void setSportsName(String sportsName) {
		this.sportsName = sportsName;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
}
