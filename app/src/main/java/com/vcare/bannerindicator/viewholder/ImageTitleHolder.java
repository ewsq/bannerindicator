package com.vcare.bannerindicator.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.vcare.bannerindicator.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ImageTitleHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public TextView title;

    public ImageTitleHolder(@NonNull View view) {
        super(view);
        imageView = view.findViewById(R.id.image);
        title = view.findViewById(R.id.bannerTitle);
    }
}
