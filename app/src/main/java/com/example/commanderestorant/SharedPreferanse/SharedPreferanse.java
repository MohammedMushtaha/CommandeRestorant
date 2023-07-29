package com.example.commanderestorant.SharedPreferanse;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;


public class SharedPreferanse {

    private static SharedPreferences mSharedPref;
    private SharedPreferences.Editor editor;
    private Context context;
    private static SharedPreferanse instance;
    private static final String PREF_NAME = "DATA";
     public static String IS_FIRST_LAUNCH = "IS_FIRST_LAUNCH";

    public static String Language = "Language";

    public static String IDExpand = "IDExpand";
    public static String IDExpand2 = "IDExpand2";

    public static String TOKENProvider = "TOKENProvider";
//////User Data
    public static String ID = "ID";
    public static String position = "position";

    public static String FirstName = "FirstName";
    public static String LastName = "LastName";
    public static String isShowToolBar = "isShowToolBar";
    public static String Email = "Email";
    public static String EmailVerifiedAt = "EmailVerifiedAt";
    public static String PhoneVerifiedAt = "PhoneVerifiedAt";
    public static String Phone = "Phone";
    public static String Image = "Image";
    public static String googleId = "googleId";
    public static String CreatedAt = "CreatedAt";
    public static String UpdatedAt = "UpdatedAt";
    public static String AccessToken = "AccessToken";
    public static String ActivePlan = "active_plan";
//////
    public static String IdCurrentMenu = "IMAGEProvider";
    public static String IdDishesDetails = "IdDishesDetails";
    public static String ToolBarTitleCurrentMenu = "TitleCurrentMenu";
    public static String SelectRating = "SelectRating";
    public static String IdMustEnableLocation = "IdMustEnableLocation";
    public static String DaySelected = "DaySelected";
    public static String ISSelected = "ISSelected";
    public static String IsAddOrUpdateAddress = "IsAddOrUpdateAddress";
    public static String IDAddressToUpdate = "IDAddressToUpdate";

/////////Plane
    public static String IfCurrentOrPrevious = "IfCurrentOrPrevious";
    public static String IdPlane = "idPlane";
    public static String NumberOfDays = "NumberOfDays";
    public static String CurrentMenuId = "CurrentMenuId";
    public static String TranslatedTitle = "TranslatedTitle";
    public static String IdCreateOrderDone = "IdCreateOrderDone";

    public static String IdAddressConvertNumberOfDay = "IntegerConvertNumberOfDay";
    public static String getDeliveryPrice = "getDeliveryPrice";
    public static String getPlanPrice = "getPlanPrice";
    public static String IdCloseAllergy = "IdCloseAllergy";
    public static String LoginAsVisitorOrGoogle = "LoginAsVisitor";
    /////

    public static String ItemOfAddress = "ItemOfAddress";
    public static String ScenarioHomeAddress = "ScenarioHomeAddress";
    public static int Position =  1;
    public static String gist = "gist";
    public static String IdOfAddressSpinner = "IdOfAddressSpinner";
    public static String IdOfTimeSpinner = "IdOfTimeSpinner";
    public static double Longitude =  1;
    public static double latitude =  1;
    public static String TITLE_CATEGORIES = "TITLE_CATEGORIES";
    public static String ID_CATEGORIES = "ID_CATEGORIES";
    public static final String SP_USER = "user";
    public static final String SP_API_TOKEN = "fcm_token";


    public static void init(Context context) {
        if (mSharedPref == null)
            mSharedPref = context.getSharedPreferences(PREF_NAME, Activity.MODE_PRIVATE);
    }

    public static String read(String key, String defValue) {
        return mSharedPref.getString(key, defValue);
    }

    public static int readInt(String key, int defValue) {
        return mSharedPref.getInt(key, defValue);
    }

    public static void write(String key, String value) {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.putString(key, value);
        prefsEditor.apply();
    }

    public static void writeInt(String key, int value) {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.putInt(key, value);
        prefsEditor.apply();
    }

    private SharedPreferanse(Context context) {
        this.context = context;
        if (context != null) {
            mSharedPref = context.getSharedPreferences("app_sp", Context.MODE_PRIVATE);
            editor = mSharedPref.edit();
        }
    }

    public static  SharedPreferanse getInstance(Context context) {
        if (instance == null)
            return new  SharedPreferanse(context);

        return instance;
    }

    public static boolean read(String key, boolean defValue) {
        return mSharedPref.getBoolean(key, defValue);
    }

    public static void write(String key, boolean value) {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.putBoolean(key, value);
        prefsEditor.apply();
    }

    public static Integer read(String key, int defValue) {
        return mSharedPref.getInt(key, defValue);
    }

    public static void write(String key, Integer value) {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.putInt(key, value).apply();
    }

    public static void clear() {
        mSharedPref.edit().clear().apply();
        write( SharedPreferanse.IS_FIRST_LAUNCH, false);
    }
}





















