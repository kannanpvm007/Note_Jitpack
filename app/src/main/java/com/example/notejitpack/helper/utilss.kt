package com.example.notejitpack.helper

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Created by kannanpvm007 on 08-07-2023.
 */
fun formatDate(time:Long):String= SimpleDateFormat("EEE, d MMM hh:mm aa", Locale.getDefault()).format(Date(time))