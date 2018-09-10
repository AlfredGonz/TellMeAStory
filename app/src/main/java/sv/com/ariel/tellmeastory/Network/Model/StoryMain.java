package sv.com.ariel.tellmeastory.Network.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class StoryMain{

	@SerializedName("data")
	private List<Story> data;

	@SerializedName("Error")
	private boolean error;

	public void setData(List<Story> data){
		this.data = data;
	}

	public List<Story> getData(){
		return data;
	}

	public void setError(boolean error){
		this.error = error;
	}

	public boolean isError(){
		return error;
	}

	@Override
 	public String toString(){
		return 
			"StoryMain{" + 
			"data = '" + data + '\'' + 
			",error = '" + error + '\'' + 
			"}";
		}
}