package com.easemob.videocall.adapter;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import com.easemob.videocall.R;
import com.hyphenate.chat.EMConferenceStream;
import com.hyphenate.media.EMCallSurfaceView;

/**
 * author lijian
 * email: Allenlee@easemob.com
 * date: 03/15/2020
 */

public class ChooseTalkerItemAdapter extends EaseBaseRecyclerViewAdapter<EMConferenceStream> {
    public static int chooseIndex = -1;
    public ChooseTalkerItemAdapter(){

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public ViewHolder getViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.choose_talker_list, parent, false);
        return new AvatarViewHolder(view);
    }

    private class AvatarViewHolder extends ViewHolder<EMConferenceStream> {
        private EMCallSurfaceView surfaceView;
        private TextView userId_view;
        private RadioButton id_checkbox;

        public AvatarViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void initView(View itemView) {
            userId_view = (TextView)findViewById(R.id.chooseId_view);
            id_checkbox = (RadioButton)findViewById(R.id.id_checkbox);
            chooseIndex = -1;
        }

        @Override
        public void setData(EMConferenceStream item, int position){
            userId_view.setText(item.getUsername());
            if(position == chooseIndex){
                id_checkbox.setChecked(true);
            }else{
                id_checkbox.setChecked(false);
            }
        }
    }
}

