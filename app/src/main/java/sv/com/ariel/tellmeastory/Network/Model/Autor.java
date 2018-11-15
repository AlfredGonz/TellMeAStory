package sv.com.ariel.tellmeastory.Network.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Autor  implements Parcelable {

	@SerializedName("file")
	private String file;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("last_name")
	private String lastName;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private String id;

	@SerializedName("first_name")
	private String firstName;

	@SerializedName("deleted_at")
	private Object deletedAt;

	@SerializedName("email")
	private String email;

	protected Autor(Parcel in) {
		file = in.readString();
		updatedAt = in.readString();
		lastName = in.readString();
		createdAt = in.readString();
		id = in.readString();
		firstName = in.readString();
		email = in.readString();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(file);
		dest.writeString(updatedAt);
		dest.writeString(lastName);
		dest.writeString(createdAt);
		dest.writeString(id);
		dest.writeString(firstName);
		dest.writeString(email);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<Autor> CREATOR = new Creator<Autor>() {
		@Override
		public Autor createFromParcel(Parcel in) {
			return new Autor(in);
		}

		@Override
		public Autor[] newArray(int size) {
			return new Autor[size];
		}
	};

	public void setFile(String file){
		this.file = file;
	}

	public String getFile(){
		return file;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setDeletedAt(Object deletedAt){
		this.deletedAt = deletedAt;
	}

	public Object getDeletedAt(){
		return deletedAt;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"Autor{" + 
			"file = '" + file + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",last_name = '" + lastName + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			",first_name = '" + firstName + '\'' + 
			",deleted_at = '" + deletedAt + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}