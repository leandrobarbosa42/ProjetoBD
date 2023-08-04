package model.bean;

public class Usuario {
	
	private int Id;
	private String login;
	private String senha;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	

}
