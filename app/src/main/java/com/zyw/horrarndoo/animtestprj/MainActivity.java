package com.zyw.horrarndoo.animtestprj;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.zyw.horrarndoo.animtestprj.view.HistoryChartView;
import com.zyw.horrarndoo.animtestprj.view.HistoryChartView.OnViewLayoutListener;
import com.zyw.horrarndoo.animtestprj.view.HistoryModeView;

public class MainActivity extends Activity implements OnViewLayoutListener {
    private final static int DAY_MODE = 0;
    private final static int WEEK_MODE = 1;
    private final static int MONTH_MODE = 2;
    private final static int YEAR_MODE = 3;

    private HistoryModeView hmvDay;
    private HistoryModeView hmvWeek;
    private HistoryModeView hmvMonth;
    private HistoryModeView hmvYear;
    private HistoryModeView[] hmvArray;

    private HistoryChartView mHistoryChartView;

    private int mode = DAY_MODE;

    private int checkColor;
    private int unCheckColor;

    // ==================================================================================
    // Test Data
    private String mStrDayRoomData = "22,23,23,23,23,23,23,23,24,23,25,26,26,26,27,26,26,26,26,27,26,23,25,24";
    private String mStrDaySettingData = "26,26,26,26,26,26,26,26,26,16,16,16,16,16,25,25,25,26,26,24,24,24,25,26";
    private String mStrDayPowerTimeData = "80,90,91,93,100,100,100,100,50,70,89,60,100,60,70,80,80,90,95,100,100,100,100,100";

    private String mStrWeekRoomData = "26,25,23,24,28,30,22";
    private String mStrWeekSettingData = "26,26,26,26,26,26,26";
    private String mStrWeekPowerTimeData = "60,70,80,80,90,95,100";

    private String mStrMonthRoomData = "22,23,23,23,23,23,23,22,23,23,23,23,23,23,22,23,23,23,23,23,23,22,23,23,23,23,23,23,24,26";
    private String mStrMonthSettingData = "27,26,26,25,24,25,26,27,26,26,26,27,25,27,26,26,26,26,26,26,26,24,26,26,26,26,23,22,24,25";
    private String mStrMonthPowerTimeData = "90,80,80,90,88,92,93,80,80,90,23,100,99,97,90,80,90,80,70,80,90,91,100,90,90,70,70,80,90,80";

    private String mStrYearRoomData = "22,23,23,23,23,23,23,23,23,23,23,23";
    private String mStrYearSettingData = "26,26,26,26,26,26,26,23,23,23,23,23";
    private String mStrYearPowerTimeData = "80,90,91,93,100,100,50,91,93,100,100,50";

    // ===================================================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    public void initView() {
        mHistoryChartView = (HistoryChartView) findViewById(R.id.mutiHistoryChartView);

        hmvDay = (HistoryModeView) findViewById(R.id.hmv_day);
        hmvWeek = (HistoryModeView) findViewById(R.id.hmv_week);
        hmvMonth = (HistoryModeView) findViewById(R.id.hmv_month);
        hmvYear = (HistoryModeView) findViewById(R.id.hmv_year);
        hmvArray = new HistoryModeView[]{hmvDay, hmvWeek, hmvMonth, hmvYear};
        hmvDay.setOnClickListener(onClickListener);
        hmvWeek.setOnClickListener(onClickListener);
        hmvMonth.setOnClickListener(onClickListener);
        hmvYear.setOnClickListener(onClickListener);
        mHistoryChartView.setOnViewLayoutListener(this);
    }

    public void initData() {
        checkColor = this.getResources().getColor(R.color.saswell_yellow);
        unCheckColor = this.getResources().getColor(R.color.saswell_light_grey);
    }

    /**
     * 点击事件实例
     */
    private OnClickListener onClickListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.hmv_day:
                    mode = DAY_MODE;
                    break;

                case R.id.hmv_week:
                    mode = WEEK_MODE;
                    break;

                case R.id.hmv_month:
                    mode = MONTH_MODE;
                    break;

                case R.id.hmv_year:
                    mode = YEAR_MODE;
                    break;

                default:
                    break;
            }
            updateView();
        }
    };

    /**
     * 更新界面
     */
    protected void updateView() {
        for (int i = 0; i < hmvArray.length; i++) {
            if (i == mode) {
                hmvArray[i].setHistoryViewSelected(true);
                hmvArray[i].setTextColor(checkColor);
            } else {
                hmvArray[i].setHistoryViewSelected(false);
                hmvArray[i].setTextColor(unCheckColor);
            }
        }
        mHistoryChartView.setData(getAllHistoryViewData(), mode);
    }

    /**
     * 获取要绘制的历史数据全状态
     *
     * @return 全状态数据
     */
    private String getAllHistoryViewData() {
        String allHistoryData = "";

        switch (mode) {
            case DAY_MODE:
                allHistoryData = mStrDayRoomData + "-" + mStrDaySettingData + "-"
                        + mStrDayPowerTimeData;
                break;
            case WEEK_MODE:
                allHistoryData = mStrWeekRoomData + "-" + mStrWeekSettingData + "-"
                        + mStrWeekPowerTimeData;
                break;
            case MONTH_MODE:
                allHistoryData = mStrMonthRoomData + "-" + mStrMonthSettingData
                        + "-" + mStrMonthPowerTimeData;
                break;
            case YEAR_MODE:
                allHistoryData = mStrYearRoomData + "-" + mStrYearSettingData + "-"
                        + mStrYearPowerTimeData;
                break;
            default:
                break;
        }
        return allHistoryData;
    }

    @Override
    public void onLayoutSuccess() {
        //布局onlayout成功后，更新View数据
        updateView();
    }
}
