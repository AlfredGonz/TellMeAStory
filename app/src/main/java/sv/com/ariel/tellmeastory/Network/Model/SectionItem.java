package sv.com.ariel.tellmeastory.Network.Model;


import com.google.gson.annotations.SerializedName;


public class SectionItem{

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