package sv.com.ariel.tellmeastory.Network.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class UserItem implements Parcelable{

	@SerializedName("id")
	private String id;

	@SerializedName("file")
	private String file;

	@SerializedName("last_name")
	private String lastName;

	@SerializedName("first_name")
	private String firstName;

	@SerializedName("email")
	private String email;

	protected UserItem(Parcel in) {
		id = in.readString();
		file = in.readString();
		lastName = in.readString();
		firstName = in.readString();
		email = in.readString();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(id);
		dest.writeString(file);
		dest.writeString(lastName);
		dest.writeString(firstName);
		dest.writeString(email);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<UserItem> CREATOR = new Creator<UserItem>() {
		@Override
		public UserItem createFromParcel(Parcel in) {
			return new UserItem(in);
		}

		@Override
		public UserItem[] newArray(int size) {
			return new UserItem[size];
		}
	};

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}