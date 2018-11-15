package sv.com.ariel.tellmeastory.Network.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseLikes {

	@SerializedName("data")
	private List<LikesItem> data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public void setData(List<LikesItem> data){
		this.data = data;
	}

	public List<LikesItem> getData(){
		return data;
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
			"ResponseLikes{" +
			"data = '" + data + '\'' + 
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}