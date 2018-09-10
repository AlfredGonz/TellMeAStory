package sv.com.ariel.tellmeastory.Network.Model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;


public class SectionItem implements Parcelable {

	@SerializedName("idStory")
	private int idStory;

	@SerializedName("Order")
	private int order;

	@SerializedName("Description")
	private String description;

	@SerializedName("id")
	private int id;

	@SerializedName("Url")
	private String url;

	@SerializedName("Name")
	private String name;

	protected SectionItem(Parcel in) {
		idStory = in.readInt();
		order = in.readInt();
		description = in.readString();
		id = in.readInt();
		url = in.readString();
		name = in.readString();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(idStory);
		dest.writeInt(order);
		dest.writeString(description);
		dest.writeInt(id);
		dest.writeString(url);
		dest.writeString(name);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<SectionItem> CREATOR = new Creator<SectionItem>() {
		@Override
		public SectionItem createFromParcel(Parcel in) {
			return new SectionItem(in);
		}

		@Override
		public SectionItem[] newArray(int size) {
			return new SectionItem[size];
		}
	};

	public void setIdStory(int idStory){
		this.idStory = idStory;
	}

	public int getIdStory(){
		return idStory;
	}

	public void setOrder(int order){
		this.order = order;
	}

	public int getOrder(){
		return order;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	@Override
 	public String toString(){
		return 
			"SectionItem{" + 
			"idStory = '" + idStory + '\'' + 
			",order = '" + order + '\'' + 
			",description = '" + description + '\'' + 
			",id = '" + id + '\'' + 
			",url = '" + url + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}
}