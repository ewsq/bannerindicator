package com.vcare.bannerindicator.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;


import com.vcare.bannerindicator.bean.DataBean;
import com.vcare.bannerindicator.viewholder.ImageHolder;
import com.vcare.bannerindicator.viewholder.TitleHolder;
import com.vcare.bannerindicator.viewholder.VideoHolder;
import com.youth.banner.adapter.BannerAdapter;
import com.vcare.bannerindicator.R;
import java.util.List;
import com.youth.banner.util.BannerUtils;

import java.util.List;

/**
 * 自定义布局,多个不同UI切换
 */
public class MultipleTypesAdapter extends BannerAdapter<DataBean, RecyclerView.ViewHolder> {
    private Context context;

    public MultipleTypesAdapter(Context context, List<DataBean> mDatas) {
        super(mDatas);
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 1:
                return new ImageHolder(BannerUtils.getView(parent, R.layout.banner_image));
            case 2:
                return new VideoHolder(BannerUtils.getView(parent, R.layout.banner_video));
            case 3:
                return new TitleHolder(BannerUtils.getView(parent, R.layout.banner_title));
        }
        return new ImageHolder(BannerUtils.getView(parent, R.layout.banner_image));
    }

    @Override
    public int getItemViewType(int position) {
        return getData(getRealPosition(position)).viewType;
    }

    @Override
    public void onBindView(RecyclerView.ViewHolder holder, DataBean data, int position, int size) {
        int viewType = holder.getItemViewType();
        switch (viewType) {
            case 1:
                ImageHolder imageHolder = (ImageHolder) holder;
                imageHolder.imageView.setImageResource(data.imageRes);
                break;
            case 2:
                VideoHolder videoHolder = (VideoHolder) holder;
/*                videoHolder.player.setUp(data.imageUrl, true, null);
                videoHolder.player.getBackButton().setVisibility(View.GONE);
                //增加封面
                ImageView imageView = new ImageView(context);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setImageResource(R.drawable.image4);
                videoHolder.player.setThumbImageView(imageView);*/
//                videoHolder.player.startPlayLogic();
                break;
            case 3:
                TitleHolder titleHolder = (TitleHolder) holder;
                titleHolder.title.setText(data.title);
                titleHolder.title.setBackgroundColor(Color.parseColor(DataBean.getRandColor()));
                break;
        }
    }


}
