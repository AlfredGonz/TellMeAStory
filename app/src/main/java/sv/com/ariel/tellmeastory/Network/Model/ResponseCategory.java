package sv.com.ariel.tellmeastory.Network.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseCategory implements Parcelable {

	@SerializedName("data")
	private List<Category> data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	protected ResponseCategory(Parcel in) {
		data = in.createTypedArrayList(Category.CREATOR);
		success = in.readByte() != 0;
		message = in.readString();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeTypedList(data);
		dest.writeByte((byte) (success ? 1 : 0));
		dest.writeString(message);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<ResponseCategory> CREATOR = new Creator<ResponseCategory>() {
		@Override
		public ResponseCategory createFromParcel(Parcel in) {
			return new ResponseCategory(in);
		}

		@Override
		public ResponseCategory[] newArray(int size) {
			return new ResponseCategory[size];
		}
	};

	public void setData(List<Category> data){
		this.data = data;
	}

	public List<Category> getData(){
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
			"ResponseCategory{" +
			"data = '" + data + '\'' + 
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}