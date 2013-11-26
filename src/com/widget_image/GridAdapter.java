package com.widget_image;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {

	
	private Context context;
	private int[] images;
	
	public GridAdapter(Context context, int[] images) {
		
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

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder;
		if(convertView== null) {
			
			holder= new ViewHolder();
			convertView= LayoutInflater.from(context).inflate(R.layout.grid, parent, false);
			holder.image= (ImageView) convertView.findViewById(R.id.gridImage);
			holder.text= (TextView) convertView.findViewById(R.id.gridText);
			convertView.setTag(holder);
		}else {
			
			holder= (ViewHolder) convertView.getTag();
		}
		holder.image.setImageResource(images[position]);
		holder.text.setText("Pictrue:"+ position);
		return convertView;
	}
	
	class ViewHolder {
		
		TextView text;
		ImageView image;
	}
}