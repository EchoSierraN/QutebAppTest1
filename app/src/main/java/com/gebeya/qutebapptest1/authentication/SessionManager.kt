package com.gebeya.qutebapptest1.authentication

import android.content.Context
import android.content.SharedPreferences
import com.gebeya.qutebapptest1.R

/**
 * Session manager to save and fetch data from SharedPreferences
 */
class SessionManager(context: Context) {
    private var prefs: SharedPreferences =
        context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = prefs.edit()

    companion object {
        const val USER_TOKEN = "user_token"
        const val REMEMBER_USER = "remember_me"
    }

    /**
     * Function to save auth token
     */
    fun saveAuthToken(token: String) {
        editor.putString(USER_TOKEN, token)
        editor.apply()
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