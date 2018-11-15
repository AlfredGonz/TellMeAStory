package sv.com.ariel.tellmeastory.Network.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ResponseSingleStory implements Parcelable {

	@SerializedName("data")
	private StoriesItem data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;


	protected ResponseSingleStory(Parcel in) {
		data = in.readParcelable(StoriesItem.class.getClassLoader());
		success = in.readByte() != 0;
		message = in.readString();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeParcelable(data, flags);
		dest.writeByte((byte) (success ? 1 : 0));
		dest.writeString(message);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<ResponseSingleStory> CREATOR = new Creator<ResponseSingleStory>() {
		@Override
		public ResponseSingleStory createFromParcel(Parcel in) {
			return new ResponseSingleStory(in);
		}

		@Override
		public ResponseSingleStory[] newArray(int size) {
			return new ResponseSingleStory[size];
		}
	};

	public StoriesItem getData() {
		return data;
	}

	public void setData(StoriesItem data) {
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}