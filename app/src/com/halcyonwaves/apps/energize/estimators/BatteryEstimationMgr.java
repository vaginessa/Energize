package com.halcyonwaves.apps.energize.estimators;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

public class BatteryEstimationMgr {

	final static String TAG = "BatteryEstimationMgr";

	static int getRemainingTimeInMinutes( Context context ) {
		final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences( context );
		final String estimationMethod = prefs.getString( "batstatistics.usedestimator", "" );

		//
		if( 0 == "LastChangeEstimate".compareToIgnoreCase( estimationMethod ) ) {
			return SimpleEstimationAlgorithm.getEstimationInMinutes( context );
		}

		// it seems that no time estimator could be initialized
		Log.e( BatteryEstimationMgr.TAG, "Unknown battery time estimator found in preferences: " + estimationMethod );
		return -1;
	}
}
