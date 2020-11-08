package com.gebeya.qutebapptest1.authentication

import android.content.Context
import android.content.SharedPreferences
import com.gebeya.qutebapptest1.R
import java.util.*

/**
 * Session manager to save and fetch data from SharedPreferences
 */
class SessionManager(context: Context) {
    private var prefs: SharedPreferences =
        context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = prefs.edit()

    companion object {
        const val USER_TOKEN = "user_token"
        const val USER_NAME = "user_name"
        const val USER_ID = "user_id"
        const val USER_EMAIL = "user_email"
        const val USER_TOKEN_EXPIRATION= "user_token_expiration"
        const val REMEMBER_USER = "remember_me"

        /*FOR SAVING APP RELATED DATA*/
        const val SPENDING_DATA= "spending_data"

        /*Maybe put these definitions somewhere else? Somewhere more common
        * to all activities?*/
        lateinit var sessionManager: SessionManager
        lateinit var apiClient: ApiClient
    }

    /**
     * Function to save auth token
     */
    fun saveAuthToken(token: String) {
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    fun deleteAuthToken(){
        editor.remove(USER_TOKEN)
        editor.apply()
    }

    fun saveCurrentUserData(userName: String, userid: Int, userEmail: String, userTokenExpiration: String, userToken: String){
        editor.putString(USER_NAME, userName)
        editor.putInt(USER_ID, userid)
        editor.putString(USER_TOKEN_EXPIRATION, userTokenExpiration)
        editor.putString(USER_EMAIL, userEmail)
        editor.putString(USER_TOKEN, userToken)
    }

    /**
     * Save in SharedPreferences a boolean on whether or not the app
     * will remember user on restart
     */
    fun rememberUser(rememberMe: Boolean) {
        editor.putBoolean(REMEMBER_USER, rememberMe)
        editor.apply()
    }

    /**
     * Returns true if REMEMBER_USER in the shared preferences is true,
     * returns false if either that's false or there's no entry with
     * a key REMEMBER_USER
     */
    fun hasRememberedUser(): Boolean {
        return prefs.getBoolean(REMEMBER_USER, false)
    }

    /**
     * Function to fetch auth token
     */
    fun fetchAuthToken(): String? {
        return prefs.getString(USER_TOKEN, null)
    }
}