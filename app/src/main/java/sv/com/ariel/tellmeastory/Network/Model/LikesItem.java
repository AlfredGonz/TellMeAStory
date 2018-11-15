package sv.com.ariel.tellmeastory.Network.Model;

import com.google.gson.annotations.SerializedName;

public class LikesItem {

	@SerializedName("id_story")
	private int idStory;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("id_usuario")
	private String idUsuario;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("state")
	private int state;

	@SerializedName("comentario")
	private String comentario;

	@SerializedName("deleted_at")
	private Object deletedAt;

	public void setIdStory(int idStory){
		this.idStory = idStory;
	}

	public int getIdStory(){
		return idStory;
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

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
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

	public void setComentario(String comentario){
		this.comentario = comentario;
	}

	public String getComentario(){
		return comentario;
	}

	public void setDeletedAt(Object deletedAt){
		this.deletedAt = deletedAt;
	}

	public Object getDeletedAt(){
		return deletedAt;
	}

	@Override
 	public String toString(){
		return 
			"LikesItem{" +
			"id_story = '" + idStory + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",id_usuario = '" + idUsuario + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			",state = '" + state + '\'' + 
			",comentario = '" + comentario + '\'' + 
			",deleted_at = '" + deletedAt + '\'' + 
			"}";
		}
}