package sv.com.ariel.tellmeastory.Network.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;


public class ResponseSingleLike implements Parcelable {

	@SerializedName("data")
	private LikesItem data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;


	protected ResponseSingleLike(Parcel in) {
		success = in.readByte() != 0;
		message = in.readString();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeByte((byte) (success ? 1 : 0));
		dest.writeString(message);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<ResponseSingleLike> CREATOR = new Creator<ResponseSingleLike>() {
		@Override
		public ResponseSingleLike createFromParcel(Parcel in) {
			return new ResponseSingleLike(in);
		}

		@Override
		public ResponseSingleLike[] newArray(int size) {
			return new ResponseSingleLike[size];
		}
	};

	public LikesItem getData() {
		return data;
	}

	public void setData(LikesItem data) {
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