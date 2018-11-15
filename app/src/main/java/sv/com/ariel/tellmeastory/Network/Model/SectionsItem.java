package sv.com.ariel.tellmeastory.Network.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class SectionsItem  implements Parcelable {

	@SerializedName("id_story")
	private int idStory;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("name")
	private String name;

	@SerializedName("description")
	private String description;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("audio_url")
	private Object audioUrl;

	@SerializedName("id")
	private int id;

	@SerializedName("deleted_at")
	private Object deletedAt;

	@SerializedName("url")
	private String url;

	protected SectionsItem(Parcel in) {
		idStory = in.readInt();
		updatedAt = in.readString();
		name = in.readString();
		description = in.readString();
		createdAt = in.readString();
		id = in.readInt();
		url = in.readString();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(idStory);
		dest.writeString(updatedAt);
		dest.writeString(name);
		dest.writeString(description);
		dest.writeString(createdAt);
		dest.writeInt(id);
		dest.writeString(url);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<SectionsItem> CREATOR = new Creator<SectionsItem>() {
		@Override
		public SectionsItem createFromParcel(Parcel in) {
			return new SectionsItem(in);
		}

		@Override
		public SectionsItem[] newArray(int size) {
			return new SectionsItem[size];
		}
	};

	public int getIdStory() {
		return idStory;
	}

	public void setIdStory(int idStory) {
		this.idStory = idStory;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public Object getAudioUrl() {
		return audioUrl;
	}

	public void setAudioUrl(Object audioUrl) {
		this.audioUrl = audioUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Object getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Object deletedAt) {
		this.deletedAt = deletedAt;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}