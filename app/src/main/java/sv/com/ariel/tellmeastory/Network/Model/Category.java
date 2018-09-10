package sv.com.ariel.tellmeastory.Network.Model;


import com.google.gson.annotations.SerializedName;

public class Category{

	@SerializedName("name")
	private String name;

	@SerializedName("idCategory")
	private int idCategory;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setIdCategory(int idCategory){
		this.idCategory = idCategory;
	}

	public int getIdCategory(){
		return idCategory;
	}

	@Override
 	public String toString(){
		return 
			"Category{" + 
			"name = '" + name + '\'' + 
			",idCategory = '" + idCategory + '\'' + 
			"}";
		}
}