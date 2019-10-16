package cn.algerfan.springboot09validate.pojo;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class Users {
	@NotBlank(message="用户名不能为空") //非空校验
	@Length(min=2,max=6,message="最小长度为2位，最大长度为6位")
	private String name;
	@NotEmpty
	private String password;
	@Min(value=15)
	private Integer age;
	@Email
	private String email;

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Users [name=" + name + ", password=" + password + ", age=" + age + "]";
	}

}
