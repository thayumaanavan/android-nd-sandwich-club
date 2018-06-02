package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich= new Sandwich();

        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject nameArray= jsonObject.getJSONObject("name");

            sandwich.setMainName(nameArray.getString("mainName"));

            JSONArray alsoKnownAsArray = nameArray.getJSONArray("alsoKnownAs");
            List<String> alsoKnownAsList = new ArrayList<>();
            for (int i=0; i<alsoKnownAsArray.length();i++){
                alsoKnownAsList.add(alsoKnownAsArray.getString(i));
            }
            sandwich.setAlsoKnownAs(alsoKnownAsList);

            sandwich.setPlaceOfOrigin(jsonObject.getString("placeOfOrigin"));

            sandwich.setDescription(jsonObject.getString("description"));

            sandwich.setImage(jsonObject.getString("image"));

            List<String> ingredientsList = new ArrayList<>();
            JSONArray ingredientsArray = jsonObject.getJSONArray("ingredients");
            for(int i=0;i<ingredientsArray.length();i++){
                ingredientsList.add(ingredientsArray.getString(i));
            }
            sandwich.setIngredients(ingredientsList);

        } catch (JSONException e) {
            Log.i("exception",e.getMessage());
            return null;
        }

        return sandwich;
    }
}
