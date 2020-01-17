package com.google.www.util;

import com.google.gson.Gson;
import com.google.www.models.User;
import net.serenitybdd.core.Serenity;

import java.util.Date;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Clase para crear el json con valores traidos desde el feature como un dataTable.
 *
 */
public class Utilities {


    public static String getRequestToCreateAnEmployee(Map<String,String> datatable){
        User users = new User();
        Map<String,String> user= new HashMap<>();
        Gson gson= new Gson();
        Date date = new Date();
        String email = date.toString().substring(3).replace(" ","")
                .replace(":","").replace("COT","")+datatable.get("email");
        user.put("first_name",datatable.get("first_name"));
        user.put("last_name",datatable.get("last_name"));
        user.put("gender",datatable.get("gender"));
        user.put("email",email);
        user.put("status",datatable.get("status"));
        users.setEmail(email);
        users.setGender(datatable.get("gender"));
        users.setLastName(datatable.get("last_name"));
        users.setName(datatable.get("first_name"));
        users.setStatus(datatable.get("status"));
        Serenity.setSessionVariable("userModel").to(users);
        return gson.toJson(user);

    }
}
