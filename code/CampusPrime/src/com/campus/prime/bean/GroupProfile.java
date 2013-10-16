package com.campus.prime.bean;

public class GroupProfile {
	private int id;
	
	private String name;
	
	private String description;
	
	private String avatar;
	
	private UserProfileItem founder;
	
	private String created;
	
	private int total;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public UserProfileItem getFounder() {
		return founder;
	}

	public void setFounder(UserProfileItem founder) {
		this.founder = founder;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "GroupProfile [id=" + id + ", name=" + name + ", description="
				+ description + ", avatar=" + avatar + ", founder=" + founder
				+ ", created=" + created + ", total=" + total + "]";
	}

	
	
}
