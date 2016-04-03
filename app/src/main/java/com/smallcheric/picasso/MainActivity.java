package com.smallcheric.picasso;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    public static String[] imageUrls = {
            "http://i.imgur.com/rFLNqWI.jpg",
            "http://i.imgur.com/C9pBVt7.jpg",
            "http://i.imgur.com/rT5vXE1.jpg",
            "http://i.imgur.com/aIy5R2k.jpg",
            "http://i.imgur.com/MoJs9pT.jpg",
            "http://i.imgur.com/S963yEM.jpg",
            "http://i.imgur.com/rLR2cyc.jpg",
            "http://i.imgur.com/SEPdUIx.jpg",
            "http://i.imgur.com/aC9OjaM.jpg",
            "http://i.imgur.com/76Jfv9b.jpg",
            "http://i.imgur.com/fUX7EIB.jpg",
            "http://i.imgur.com/syELajx.jpg",
            "http://i.imgur.com/COzBnru.jpg",
            "http://i.imgur.com/Z3QjilA.jpg",
    };
    private ListView lv;
    private GridView gridView;
    private Button switchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.lv);
        gridView = (GridView) findViewById(R.id.grid);
        switchButton = (Button) findViewById(R.id.bt);
        //切换 ListView 与 GridView 的显示模式
        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lv.getVisibility()== View.VISIBLE){
                    lv.setVisibility(View.INVISIBLE);
                    gridView.setVisibility(View.VISIBLE);
                }else {
                    lv.setVisibility(View.VISIBLE);
                    gridView.setVisibility(View.INVISIBLE);
                }
            }
        });

        lv.setAdapter(new ImageListAdapter(this,imageUrls));
        gridView.setAdapter(new ImageListAdapter(this,imageUrls));
    }

    /**
     * 适配器
     */
    public class ImageListAdapter extends ArrayAdapter{
        private Context context;

        private String[] imageUrls;

        public ImageListAdapter(Context context,String[] imageUrls){
            super(context,R.layout.item_picasso,imageUrls);

            this.context = context;
            this.imageUrls = imageUrls;

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView==null){
                convertView = View.inflate(context,R.layout.item_picasso,null);
            }

            //加载图片
            Picasso
                    .with(context)
                    .load(imageUrls[position])
                    .into((ImageView) convertView);

            return convertView;
        }
    }
}
