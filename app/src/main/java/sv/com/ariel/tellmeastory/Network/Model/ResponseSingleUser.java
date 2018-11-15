package sv.com.ariel.tellmeastory.Network.Model;

import com.google.gson.annotations.SerializedName;

public class ResponseSingleUser{

	@SerializedName("userItem")
	private UserItem userItem;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public void setUserItem(UserItem userItem){
		this.userItem = userItem;
	}

	public UserItem getUserItem(){
		return userItem;
	}

	public void setSuccess(boolean success){
		this.success = success;
	}

	public boolean isSuccess(){
		return success;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"ResponseSingleUser{" + 
			"userItem = '" + userItem + '\'' +
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}