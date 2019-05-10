package com.example.jean.retrofitexample.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class HistoryItem implements Parcelable {

	@SerializedName("id")
	private int id;

	@SerializedName("klub")
	private String klub;

	protected HistoryItem(Parcel in) {
		id = in.readInt();
		klub = in.readString();
	}

	public static final Creator<HistoryItem> CREATOR = new Creator<HistoryItem>() {
		@Override
		public HistoryItem createFromParcel(Parcel in) {
			return new HistoryItem(in);
		}

		@Override
		public HistoryItem[] newArray(int size) {
			return new HistoryItem[size];
		}
	};

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setKlub(String klub){
		this.klub = klub;
	}

	public String getKlub(){
		return klub;
	}

	@Override
 	public String toString(){
		return 
			"HistoryItem{" + 
			"id = '" + id + '\'' + 
			",klub = '" + klub + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeInt(id);
		parcel.writeString(klub);
	}
}