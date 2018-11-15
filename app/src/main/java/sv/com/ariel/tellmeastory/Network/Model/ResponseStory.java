package sv.com.ariel.tellmeastory.Network.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class ResponseStory  implements Parcelable {

	@SerializedName("data")
	private List<StoriesItem> data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	protected ResponseStory(Parcel in) {
		data = in.createTypedArrayList(StoriesItem.CREATOR);
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

	public static final Creator<ResponseStory> CREATOR = new Creator<ResponseStory>() {
		@Override
		public ResponseStory createFromParcel(Parcel in) {
			return new ResponseStory(in);
		}

		@Override
		public ResponseStory[] newArray(int size) {
			return new ResponseStory[size];
		}
	};

	public void setData(List<StoriesItem> data){
		this.data = data;
	}

	public List<StoriesItem> getData(){
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
			"ResponseStory{" +
			"data = '" + data + '\'' + 
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}