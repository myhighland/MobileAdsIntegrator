package com.anjlab.ads.integrator;

import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.AdView;

import android.app.Activity;
import android.widget.LinearLayout;

public class AdMobProvider extends AbstractAdProvider implements AdListener {

	private String publisherId;
	private AdSize size;
	private AdView adView;
	
	public AdMobProvider(String publisherId){
		this(publisherId, AdSize.BANNER);
	}
	
	public AdMobProvider(String publisherId, AdSize size){
		this.publisherId = publisherId;
		this.size = size;
	}
	
	@Override
	public void tryLoadAd(Activity actv, LinearLayout layout) {
		adView = new AdView(actv, size, publisherId);
		adView.setAdListener(this);
		layout.addView(adView);
		AdRequest request = new AdRequest();
	    //request.setTesting(true);
	    adView.loadAd(request);	    
	}

	@Override
	public void onDismissScreen(Ad arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFailedToReceiveAd(Ad arg0, ErrorCode arg1) {
		stop();
		onLoadFailed();
	}

	@Override
	public void onLeaveApplication(Ad arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPresentScreen(Ad arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onReceiveAd(Ad arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void stop() {
		if (adView != null)
			adView.stopLoading();
	}

}