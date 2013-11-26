package com.widget_image;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		GridView gridView= (GridView) findViewById(R.id.gridView);
		final int[] images= new int[]{R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4, R.drawable.image5,R.drawable.image6,R.drawable.image7,R.drawable.image8};
		gridView.setAdapter(new GridAdapter(this, images));
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				Intent intent= new Intent(MainActivity.this, GalleryActivity.class);
				intent.putExtra(Keys._IMAGES, images);
				intent.putExtra(Keys._POSITION, position);
				startActivity(intent);
			}
		});
	}
}