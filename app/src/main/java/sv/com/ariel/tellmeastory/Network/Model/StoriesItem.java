package sv.com.ariel.tellmeastory.Network.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class StoriesItem implements Parcelable{

	@SerializedName("url_banner")
	private Object urlBanner;

	@SerializedName("id_category")
	private int idCategory;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("deleted_at")
	private Object deletedAt;

	@SerializedName("url")
	private String url;

	@SerializedName("autor")
	private Autor autor;

	@SerializedName("sections")
	private List<SectionsItem> sections;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("id_usuario")
	private String idUsuario;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("state")
	private int state;

	@SerializedName("category")
	private Category category;

	@SerializedName("likes")
	private int likes;

	protected StoriesItem(Parcel in) {
		idCategory = in.readInt();
		createdAt = in.readString();
		url = in.readString();
		updatedAt = in.readString();
		idUsuario = in.readString();
		name = in.readString();
		id = in.readInt();
		state = in.readInt();
		likes = in.readInt();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(idCategory);
		dest.writeString(createdAt);
		dest.writeString(url);
		dest.writeString(updatedAt);
		dest.writeString(idUsuario);
		dest.writeString(name);
		dest.writeInt(id);
		dest.writeInt(state);
		dest.writeInt(likes);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<StoriesItem> CREATOR = new Creator<StoriesItem>() {
		@Override
		public StoriesItem createFromParcel(Parcel in) {
			return new StoriesItem(in);
		}

		@Override
		public StoriesItem[] newArray(int size) {
			return new StoriesItem[size];
		}
	};

	public void setUrlBanner(Object urlBanner){
		this.urlBanner = urlBanner;
	}

	public Object getUrlBanner(){
		return urlBanner;
	}

	public void setIdCategory(int idCategory){
		this.idCategory = idCategory;
	}

	public int getIdCategory(){
		return idCategory;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setDeletedAt(Object deletedAt){
		this.deletedAt = deletedAt;
	}

	public Object getDeletedAt(){
		return deletedAt;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setAutor(Autor autor){
		this.autor = autor;
	}

	public Autor getAutor(){
		return autor;
	}

	public void setSections(List<SectionsItem> sections){
		this.sections = sections;
	}

	public List<SectionsItem> getSections(){
		return sections;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setIdUsuario(String idUsuario){
		this.idUsuario = idUsuario;
	}

	public String getIdUsuario(){
		return idUsuario;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setState(int state){
		this.state = state;
	}

	public int getState(){
		return state;
	}

	public void setCategory(Category category){
		this.category = category;
	}

	public Category getCategory(){
		return category;
	}

	public void setLikes(int likes){
		this.likes = likes;
	}

	public int getLikes(){
		return likes;
	}

	@Override
 	public String toString(){
		return 
			"StoriesItem{" +
			"url_banner = '" + urlBanner + '\'' + 
			",id_category = '" + idCategory + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",deleted_at = '" + deletedAt + '\'' + 
			",url = '" + url + '\'' + 
			",autor = '" + autor + '\'' + 
			",sections = '" + sections + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",id_usuario = '" + idUsuario + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",state = '" + state + '\'' + 
			",category = '" + category + '\'' + 
			",likes = '" + likes + '\'' + 
			"}";
		}
}