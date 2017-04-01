# animChartView
    主要实现自定义图表绘制动画，实现如下效果：
预览gif有点卡。
博客链接：[Android自定义控件：动态绘制图表](http://blog.csdn.net/oqinyou/article/details/60758417)

![https://github.com/Horrarndoo/animChartView/blob/master/assets/last_view.gif?raw=true](https://github.com/Horrarndoo/animChartView/blob/master/assets/last_view.gif?raw=true)

## xml
        <com.zyw.horrarndoo.animtestprj.view.HistoryChartView
            android:id="@+id/mutiHistoryChartView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            custom:circle_radius="@dimen/history_circle_radius"
            custom:data_stroke_width="@dimen/history_data_stroke_width"
            custom:first_data_line_color="@color/saswell_indoor_temp"
            custom:line_color="@color/saswell_yellow"
            custom:line_stroke_width="@dimen/history_line_stroke_width"
            custom:margin_bottom="@dimen/history_margin_bottom"
            custom:margin_left="@dimen/history_margin_left"
            custom:margin_right="@dimen/history_margin_right"
            custom:margin_top="@dimen/history_margin_top"
            custom:rect_background_color="@color/saswell_power_time"
            custom:second_data_line_color="@color/saswell_setpoint_temp"
            custom:unit_color="@color/saswell_light_grey"
            custom:x_first_point_offset="@dimen/history_x_first_point_offset"
            custom:x_unit_text="@string/history_x_unit_day"
            custom:x_unit_text_size="@dimen/history_x_unit_text_size"
            custom:xlabel_text_size="@dimen/history_xlabel_text_size"
            custom:y1_unit_text="@string/history_y1_unit"
            custom:y2_unit_text="@string/history_y2_unit"
            custom:y_unit_text_size="@dimen/history_y_unit_text_size"
            custom:ylabel_text_size="@dimen/history_ylabel_text_size" />
        
