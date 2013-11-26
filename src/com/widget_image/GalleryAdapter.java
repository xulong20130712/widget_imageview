package com.widget_image;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class GalleryAdapter extends BaseAdapter {

	
	private Context context;
	private int[] images;
	private LayoutParams params;
	
	public GalleryAdapter(Context context, int[] images) {
		
		this.context= context;
		this.images= images;
	}
	@Override
	public int getCount() {

		return images.length;
	}

	@Override
	public Object getItem(int position) {

		return images[position];
	}

	@Override
	public long getItemId(int position) {

		return position;
	}
	
	public void setParams(int w, int h) {
		
		params= new LayoutParams(w, h);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ImageView image= new ImageView(context);
		image.setImageResource(images[position]);
//		image.setBackgroundResource(images[position]);
		image.setLayoutParams(params);
		image.setScaleType(ScaleType.CENTER);
		return image;
	}
}