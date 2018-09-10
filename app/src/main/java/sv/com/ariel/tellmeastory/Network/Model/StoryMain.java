package sv.com.ariel.tellmeastory.Network.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class StoryMain implements Parcelable{

	@SerializedName("data")
	private List<Story> data;

	@SerializedName("Error")
	private boolean error;

	protected StoryMain(Parcel in) {
		error = in.readByte() != 0;
	}

	public static final Creator<StoryMain> CREATOR = new Creator<StoryMain>() {
		@Override
		public StoryMain createFromParcel(Parcel in) {
			return new StoryMain(in);
		}

		@Override
		public StoryMain[] newArray(int size) {
			return new StoryMain[size];
		}
	};

	public void setData(List<Story> data){
		this.data = data;
	}

	public List<Story> getData(){
		return data;
	}

	public void setError(boolean error){
		this.error = error;
	}

	public boolean isError(){
		return error;
	}

	@Override
 	public String toString(){
		return 
			"StoryMain{" + 
			"data = '" + data + '\'' + 
			",error = '" + error + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeByte((byte) (error ? 1 : 0));
	}
}