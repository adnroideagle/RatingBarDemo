package com.whinc.widgets;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.whinc.widget.ratingbar.RatingBar;

public class MainActivity extends FragmentActivity {
	private boolean mFlag = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		/* create ratingbar with xml layou */
		LinearLayout root = (LinearLayout) findViewById(R.id.root);
		final RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
		// ratingBar.setClickRating(false);
		ratingBar
				.setOnRatingChangeListener(new RatingBar.OnRatingChangeListener() {
					@Override
					public void onChange(RatingBar view, int preCount,
							int curCount) {
						Log.i("TAG", String.format(
								"previous count:%d, current count:%d",
								preCount, curCount));
					}
				});

		/* create ratingbar with java code */
		FrameLayout container = (FrameLayout) findViewById(R.id.ratingBar_container_layout);
		final RatingBar ratingBar2 = new RatingBar(this);
		ratingBar2.setMaxCount(7);
		ratingBar2.setCount(4);
		ratingBar2.setFillDrawableRes(R.drawable.empty);
		ratingBar2.setEmptyDrawableRes(R.drawable.fill);
		ratingBar2.setSpace(0);
		// ratingBar2.setTouchRating(false);
		ratingBar2
				.setOnRatingChangeListener(new RatingBar.OnRatingChangeListener() {
					@Override
					public void onChange(RatingBar view, int preCount,
							int curCount) {
						Log.i("TAG", String.format(
								"previous count:%d, current count:%d",
								preCount, curCount));
					}
				});
		container.addView(ratingBar2);

		findViewById(R.id.decrease_button).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						ratingBar.setCount(ratingBar.getCount() - 1);
					}
				});
		findViewById(R.id.increase_button).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						ratingBar.setCount(ratingBar.getCount() + 1);
					}
				});

		// increase max star
		findViewById(R.id.increase_star_button).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						ratingBar2.setMaxCount(ratingBar2.getMaxCount() + 1);
					}
				});
		// decrease max star
		findViewById(R.id.decrease_star_button).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						ratingBar2.setMaxCount(ratingBar2.getMaxCount() - 1);
					}
				});
		// inverse star drawable
		findViewById(R.id.inverse_star_drawable_button).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						mFlag = !mFlag;
						ratingBar2.setFillDrawableRes(mFlag ? R.drawable.empty
								: R.drawable.fill);
						ratingBar2.setEmptyDrawableRes(mFlag ? R.drawable.fill
								: R.drawable.empty);
					}
				});
		// increase star space
		findViewById(R.id.increase_star_space_button).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						ratingBar2.setSpace(ratingBar2.getSpace() + 5);
					}
				});
		// decrease star space
		findViewById(R.id.decrease_star_space_button).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						ratingBar2.setSpace(ratingBar2.getSpace() - 5);
					}
				});
	}

}