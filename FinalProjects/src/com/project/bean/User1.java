package com.project.bean;


public class User1 {
	 private Long id;
    private String fullname;
    private String username;
    private String password;
    private String utype;
    
	public User1(Long id, String fullname, String username, String password, String utype) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.username = username;
		this.password = password;
		this.utype = utype;
	}


	public User1(String fullname, String username, String password, String utype) {
		super();
		this.fullname = fullname;
		this.username = username;
		this.password = password;
		this.utype = utype;
	}



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


    public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
	public String getUtype() {
		return utype;
	}
	public void setUtype(String utype) {
		this.utype = utype;
	}
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int)(id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User1 other = (User1) obj;
        if (id != other.id)
            return false;
        return true;
    }
}