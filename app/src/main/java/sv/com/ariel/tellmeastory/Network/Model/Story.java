package sv.com.ariel.tellmeastory.Network.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class Story {

	@SerializedName("Category")
	private Category category;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("state")
	private int state;

	@SerializedName("Section")
	private List<SectionItem> section;

	@SerializedName("idCategory")
	private int idCategory;

	public void setCategory(Category category){
		this.category = category;
	}

	public Category getCategory(){
		return category;
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

	public void setSection(List<SectionItem> section){
		this.section = section;
	}

	public List<SectionItem> getSection(){
		return section;
	}

	public void setIdCategory(int idCategory){
		this.idCategory = idCategory;
	}

	public int getIdCategory(){
		return idCategory;
	}

	@Override
 	public String toString(){
		return name;
		}
}