package com.zyw.horrarndoo.animtestprj.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zyw.horrarndoo.animtestprj.R;

/**
 * 历史数据查询界面模式自定义View
 * @author zyw
 * @creation 2016-03-06
 */
public class HistoryModeView extends LinearLayout {
	private LinearLayout ll_click_view;
	private TextView tv_mode;
	private float mSelectTextSize;
	private float mUnSelectTextSize;

	public HistoryModeView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		
		ll_click_view = (LinearLayout) View.inflate(context, R.layout.sub_history_click_view, this);
		tv_mode = (TextView) findViewById(R.id.tv_click_view);
		
		TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.HistoryModeView);
			
		setText(ta.getString(R.styleable.HistoryModeView_android_text));
		setSelectTextSize(ta.getDimension(R.styleable.HistoryModeView_select_text_size, 16));
		setUnSelectTextSize(ta.getDimension(R.styleable.HistoryModeView_un_select_text_size, 12));
		setViewTextSize();
	}

	public HistoryModeView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
		//init(context);
	}

	public HistoryModeView(Context context) {
		this(context, null);
		//init(context);
	}

	/**
	 * 设置控件选中状态
	 * @param isSelected
	 */
	public void setHistoryViewSelected(boolean isSelected){
		ll_click_view.setSelected(isSelected);
		setViewTextSize();
	}
	
	/**
	 * 设置控件文字
	 * @param str
	 */
	public void setText(String str){
		tv_mode.setText(str);
	}

	/**
	 * 设置控件文字颜色
	 * @param color
	 */
	public void setTextColor(int color){
		tv_mode.setTextColor(color);
	}
	
	/**
	 * 设置根据view的选中状态更新text字号
	 */
	public void setViewTextSize() {
		if(ll_click_view.isSelected()){
			tv_mode.getPaint().setTextSize(mSelectTextSize);
		}else{
			tv_mode.getPaint().setTextSize(mUnSelectTextSize);
		}
	}

	/**
	 * 设置view选中的字体大小
	 * @param selectSize
	 */
	public void setSelectTextSize(float selectSize){
		mSelectTextSize = selectSize;
	}

	/**
	 * 设置view没有选中的字体大小
	 * @param unSelectSize
	 */
	public void setUnSelectTextSize(float unSelectSize){
		mUnSelectTextSize = unSelectSize;
	}
}
