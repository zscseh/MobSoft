package com.moblab.zsolt.moblab.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.orm.dsl.Table;

import java.util.List;

/**
 * Created by mobsoft on 2017. 04. 28..
 */

@Table
public class Coffee implements Parcelable {

    private Long id = null;

    @SerializedName("name")
    private String name;

    @SerializedName("ingredients")
    private List<String> ingredients;

    @SerializedName("preparation")
    private String preparation;

    public Coffee() {
    }

    public Coffee(Long id, String name, List<String> ingredients, String preparation) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.preparation = preparation;
    }

    protected Coffee(Parcel in) {
        id = in.readLong();
        name = in.readString();
        ingredients = in.createStringArrayList();
        preparation = in.readString();
    }

    public static final Creator<Coffee> CREATOR = new Creator<Coffee>() {
        @Override
        public Coffee createFromParcel(Parcel in) {
            return new Coffee(in);
        }

        @Override
        public Coffee[] newArray(int size) {
            return new Coffee[size];
        }
    };

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(name);
        dest.writeList(ingredients);
        dest.writeString(preparation);
    }
}
