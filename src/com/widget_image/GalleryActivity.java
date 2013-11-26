package com.widget_image;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Gallery;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;

public class GalleryActivity extends Activity{

	
	private int position= 0;
	private int[] images;
	private boolean flag= false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); 
		setContentView(R.layout.gallery);
		Intent intent= getIntent();
		position= intent.getIntExtra(Keys._POSITION, 0);
		images= intent.getIntArrayExtra(Keys._IMAGES);
		final Gallery gallery= (Gallery) findViewById(R.id.myGallery);
		final GalleryAdapter adapter= new GalleryAdapter(this, images);
		adapter.setParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
		gallery.setAdapter(adapter);
		gallery.setSelection(position);
		
		final ImageSwitcher imageSwitcher= (ImageSwitcher) findViewById(R.id.imageSwitcher);
		imageSwitcher.setFactory(new ViewFactory() {
			
			@Override
			public View makeView() {

				ImageView image= new ImageView(GalleryActivity.this);
				image.setLayoutParams(new ImageSwitcher.LayoutParams(ImageSwitcher.LayoutParams.MATCH_PARENT, ImageSwitcher.LayoutParams.MATCH_PARENT));
				image.setBackgroundColor(0xFF000000);
				return image;
			}
		});
		imageSwitcher.setImageResource(images[position]);
		imageSwitcher.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				imageSwitcher.setVisibility(flag? View.VISIBLE: View.GONE);
				gallery.getLayoutParams().height= LayoutParams.MATCH_PARENT;
				adapter.setParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
				adapter.notifyDataSetChanged();
				flag= !flag;
			}
		});
		gallery.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				imageSwitcher.setVisibility(flag? View.VISIBLE: View.GONE);
				gallery.getLayoutParams().height= (flag? 100: LayoutParams.MATCH_PARENT);
				adapter.setParams((flag? LayoutParams.WRAP_CONTENT: LayoutParams.MATCH_PARENT), LayoutParams.MATCH_PARENT);
				adapter.notifyDataSetChanged();
				flag= !flag;
			}
		});
		gallery.setOnItemSelectedListener(new OnItemSelectedListener() {

			//当滑动gallery时就能触发该事件的发生不必点击
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {

				imageSwitcher.setImageResource(images[position]);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

				
			}
		});
	}
}