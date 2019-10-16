package cn.algerfan.springboot.domain;

/**
 * <p>
 * 自定义Realm
 * </p>
 *
 * @author algerfan
 * @since 2019/7/31 13
 */
public class User {
	private Integer id;
	private String name;
	private String password;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	
}
