package namecard;

public class Name_Card_VO {
	
	String Name;
	String PhoneNumber;
	String Company;
	
	public Name_Card_VO(String name, String phoneNumber, String company) {
		super();
		Name = name;
		PhoneNumber = phoneNumber;
		Company = company;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
	}

	@Override
	public String toString() {
		return "이름:" + Name + ", 전화번호:" + PhoneNumber + ", 회사명: " + Company;
	}
	
	
	
	

}
