package sv.com.ariel.tellmeastory.Network.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;


public class ResponseSingleSecction implements Parcelable {

	@SerializedName("data")
	private SectionsItem data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;


	protected ResponseSingleSecction(Parcel in) {
		data = in.readParcelable(SectionsItem.class.getClassLoader());
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

	public static final Creator<ResponseSingleSecction> CREATOR = new Creator<ResponseSingleSecction>() {
		@Override
		public ResponseSingleSecction createFromParcel(Parcel in) {
			return new ResponseSingleSecction(in);
		}

		@Override
		public ResponseSingleSecction[] newArray(int size) {
			return new ResponseSingleSecction[size];
		}
	};

	public SectionsItem getData() {
		return data;
	}

	public void setData(SectionsItem data) {
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