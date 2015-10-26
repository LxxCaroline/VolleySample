package com.think.linxuanxuan.volleysample;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;


public class NetworkPicListAdpater extends RecyclerView.Adapter<NetworkPicListAdpater.CustomViewHolder> {
    String[] urls = {"http://image.photophoto.cn/nm-6/018/030/0180300244.jpg",
            "http://pic.nipic.com/2007-11-09/2007119121849495_2.jpg",
            "http://pic1.ooopic.com/uploadfilepic/sheji/2009-08-09/OOOPIC_SHIJUNHONG_20090809ad6104071d324dda.jpg",
            "http://pic.nipic.com/2007-12-22/2007122215556437_2.jpg",
            "http://pic.nipic.com/2007-11-09/2007119123053767_2.jpg",
            "http://pic.nipic.com/2007-11-08/2007118192311804_2.jpg",
            "http://pica.nipic.com/2007-11-09/200711912453162_2.jpg",
            "http://pic1.ooopic.com/uploadfilepic/sheji/2009-08-12/OOOPIC_SHIJUNHONG_2009081248f16747c1659ceb.jpg",
            "http://img.taopic.com/uploads/allimg/120331/2722-12033109302882.jpg",
            "http://pica.nipic.com/2007-11-09/2007119124413448_2.jpg",
            "http://pica.nipic.com/2008-03-19/2008319183523380_2.jpg",
            "http://www.aiimg.com/uploads/userup/0906/15045I1D44.jpg",
            "https://lh3.googleusercontent.com/-rrFnVC8xQEg/URqufdrLBaI/AAAAAAAAAbs/s69WYy_fl1E/s160-c/Chess.jpg",
            "https://lh5.googleusercontent.com/-WVpRptWH8Yw/URqugh-QmDI/AAAAAAAAAbs/E-MgBgtlUWU/s160-c/Chihuly.jpg",
            "http://pic.nipic.com/2007-11-08/2007118192149610_2.jpg",
            "http://pic1.nipic.com/2008-11-03/200811393332267_2.jpg",
            "http://sc.jb51.net/uploads/allimg/140307/11-14030G41P3628.jpg",
            "http://res3.szy.com.cn/images/user/127631/1325571197728522699.jpg",
            "http://pica.nipic.com/2007-11-13/2007111317599808_2.jpg",
            "http://pica.nipic.com/2007-12-08/2007128103332757_2.jpg",
            "https://lh5.googleusercontent.com/-Oh8mMy2ieng/URqullDwehI/AAAAAAAAAbs/TbdeEfsaIZY/s160-c/Despair.jpg",
            "http://www.51ps.com/upfile/2007/11/200711234317140356694.jpg",
            "http://img3.3lian.com/2013/v10/50/d/81.jpg",
            "http://img.taopic.com/uploads/allimg/121016/235026-121016125949100.jpg",
            "http://www.wyzu.cn/data/uploadfile/200709/20070923154904376.jpg",
            "http://pic.nipic.com/2007-11-09/200711912230489_2.jpg",
            "https://lh6.googleusercontent.com/-9lzOk_OWZH0/URquoo4xYoI/AAAAAAAAAbs/AwgzHtNVCwU/s160-c/Frantic.jpg",
            "http://img.taopic.com/uploads/allimg/130501/240451-13050106450911.jpg",
            "http://pic4.nipic.com/20091113/2036281_160832616864_2.jpg",
            "http://img1.imgtn.bdimg.com/it/u=3966273716,1781878557&fm=21&gp=0.jpg",
            "http://pic8.nipic.com/20100723/5296193_105040043769_2.jpg",
            "http://tupian.qqjay.com/u/2012/0501/b2313668cfc20536cd44ae5bd55121b2.jpg",
            "http://pic.nipic.com/2007-11-08/200711819133664_2.jpg",
            "http://pica.nipic.com/2008-06-13/2008613144535941_2.jpg",
            "http://h.hiphotos.baidu.com/zhidao/pic/item/0eb30f2442a7d9331794db0ead4bd11373f0018a.jpg",
            "http://www.th7.cn/d/file/p/2011/07/05/fb785ce8803f0683160f4c538eb85150.jpg",
            "http://www.xxjxsj.cn/article/UploadPic/2009-4/2009410111190878.jpg",
            "http://img1.imgtn.bdimg.com/it/u=150452386,482007783&fm=21&gp=0.jpg",
            "http://pic6.nipic.com/20100402/4575556_111434628407_2.jpg",
            "http://pic23.nipic.com/20120812/4277683_204018483000_2.jpg",
            "https://lh5.googleusercontent.com/-GoUQVw1fnFw/URquv6xbC0I/AAAAAAAAAbs/zEUVTQQ43Zc/s160-c/Kauai.jpg",
            "http://img3.redocn.com/20100608/Redocn_2010060801241210.jpg",
            "http://pic.wenwen.soso.com/p/20090901/20090901120123-329341688.jpg",
            "http://pica.nipic.com/2008-01-05/200815191150944_2.jpg",
            "http://pic.nipic.com/2008-02-16/2008216164144275_2.jpg",
            "http://pic28.nipic.com/20130402/9252150_190139450381_2.jpg",
            "http://s1.houdao.71dm.com/11884/10/01/09/142_10270602_e30a5cbe9765091.jpg",
            "http://pic.nipic.com/2007-11-21/2007112119737517_2.jpg",
            "http://img4.imgtn.bdimg.com/it/u=3035594027,3294826749&fm=21&gp=0.jpg",
            "http://pics.shoes.net.cn/pic/item/2010/08/07/4500243284229.jpg",
            "http://pic1.nipic.com/20090326/1576353_134547062_2.jpg",
            "http://pic24.nipic.com/20121008/7618448_103904214177_2.jpg",
            "http://pica.nipic.com/2007-12-10/20071210185024937_2.jpg",
            "http://pic.nipic.com/2007-11-02/200711216410408_2.jpg",
            "https://lh6.googleusercontent.com/-flsqwMrIk2Q/URqu24PcmjI/AAAAAAAAAbs/5ocIH85XofM/s160-c/Marshall" +
                    "%252520Beach%252520Sunset.jpg",
            "https://lh4.googleusercontent.com/-Y4lgryEVTmU/URqu28kG3gI/AAAAAAAAAbs/OjXpekqtbJ4/s160-c/Mono" +
                    "%252520Lake%252520Blue.jpg",
            "https://lh4.googleusercontent.com/-AaHAJPmcGYA/URqu3PIldHI/AAAAAAAAAbs/lcTqk1SIcRs/s160-c/Monument" +
                    "%252520Valley%252520Overlook.jpg",
            "https://lh4.googleusercontent.com/-vKxfdQ83dQA/URqu31Yq_BI/AAAAAAAAAbs/OUoGk_2AyfM/s160-c/Moving" +
                    "%252520Rock.jpg",
            "https://lh5.googleusercontent.com/-CG62QiPpWXg/URqu4ia4vRI/AAAAAAAAAbs/0YOdqLAlcAc/s160-c/Napali" +
                    "%252520Coast.jpg",
            "https://lh6.googleusercontent.com/-wdGrP5PMmJQ/URqu5PZvn7I/AAAAAAAAAbs/m0abEcdPXe4/s160-c/One" +
                    "%252520Wheel.jpg",
            "https://lh6.googleusercontent.com/-6WS5DoCGuOA/URqu5qx1UgI/AAAAAAAAAbs/giMw2ixPvrY/s160-c/Open%252520Sky" +
                    ".jpg",
            "https://lh6.googleusercontent.com/-u8EHKj8G8GQ/URqu55sM6yI/AAAAAAAAAbs/lIXX_GlTdmI/s160-c/Orange" +
                    "%252520Sunset.jpg",
            "https://lh6.googleusercontent.com/-74Z5qj4bTDE/URqu6LSrJrI/AAAAAAAAAbs/XzmVkw90szQ/s160-c/Orchid.jpg",
            "https://lh6.googleusercontent.com/-lEQE4h6TePE/URqu6t_lSkI/AAAAAAAAAbs/zvGYKOea_qY/s160-c/Over" +
                    "%252520there.jpg",
            "https://lh5.googleusercontent.com/-cauH-53JH2M/URqu66v_USI/AAAAAAAAAbs/EucwwqclfKQ/s160-c/Plumes.jpg",
            "https://lh3.googleusercontent.com/-eDLT2jHDoy4/URqu7axzkAI/AAAAAAAAAbs/iVZE-xJ7lZs/s160-c/Rainbokeh.jpg",
            "https://lh5.googleusercontent.com/-j1NLqEFIyco/URqu8L1CGcI/AAAAAAAAAbs/aqZkgX66zlI/s160-c/Rainbow.jpg",
            "https://lh5.googleusercontent.com/-DRnqmK0t4VU/URqu8XYN9yI/AAAAAAAAAbs/LgvF_592WLU/s160-c/Rice" +
                    "%252520Fields.jpg",
            "https://lh3.googleusercontent.com/-hwh1v3EOGcQ/URqu8qOaKwI/AAAAAAAAAbs/IljRJRnbJGw/s160-c/Rockaway" +
                    "%252520Fire%252520Sky.jpg",
            "https://lh5.googleusercontent.com/-wjV6FQk7tlk/URqu9jCQ8sI/AAAAAAAAAbs/RyYUpdo-c9o/s160-c/Rockaway" +
                    "%252520Flow.jpg",
            "https://lh6.googleusercontent.com/-6cAXNfo7D20/URqu-BdzgPI/AAAAAAAAAbs/OmsYllzJqwo/s160-c/Rockaway" +
                    "%252520Sunset%252520Sky.jpg",
            "https://lh3.googleusercontent.com/-sl8fpGPS-RE/URqu_BOkfgI/AAAAAAAAAbs/Dg2Fv-JxOeg/s160-c/Russian" +
                    "%252520Ridge%252520Sunset.jpg",
            "https://lh6.googleusercontent.com/-gVtY36mMBIg/URqu_q91lkI/AAAAAAAAAbs/3CiFMBcy5MA/s160-c/Rust" +
                    "%252520Knot.jpg",
            "https://lh6.googleusercontent.com/-GHeImuHqJBE/URqu_FKfVLI/AAAAAAAAAbs/axuEJeqam7Q/s160-c/Sailing" +
                    "%252520Stones.jpg",
            "https://lh3.googleusercontent.com/-hBbYZjTOwGc/URqu_ycpIrI/AAAAAAAAAbs/nAdJUXnGJYE/s160-c/Seahorse.jpg",
            "https://lh3.googleusercontent.com/-Iwi6-i6IexY/URqvAYZHsVI/AAAAAAAAAbs/5ETWl4qXsFE/s160-c/Shinjuku" +
                    "%252520Street.jpg",
            "https://lh6.googleusercontent.com/-amhnySTM_MY/URqvAlb5KoI/AAAAAAAAAbs/pFCFgzlKsn0/s160-c/Sierra" +
                    "%252520Heavens.jpg",
            "https://lh5.googleusercontent.com/-dJgjepFrYSo/URqvBVJZrAI/AAAAAAAAAbs/v-F5QWpYO6s/s160-c/Sierra" +
                    "%252520Sunset.jpg",
            "https://lh4.googleusercontent.com/-Z4zGiC5nWdc/URqvBdEwivI/AAAAAAAAAbs/ZRZR1VJ84QA/s160-c/Sin" +
                    "%252520Lights.jpg",
            "https://lh4.googleusercontent.com/-_0cYiWW8ccY/URqvBz3iM4I/AAAAAAAAAbs/9N_Wq8MhLTY/s160-c/Starry" +
                    "%252520Lake.jpg",
            "https://lh3.googleusercontent.com/-A9LMoRyuQUA/URqvCYx_JoI/AAAAAAAAAbs/s7sde1Bz9cI/s160-c/Starry" +
                    "%252520Night.jpg",
            "https://lh3.googleusercontent.com/-KtLJ3k858eY/URqvC_2h_bI/AAAAAAAAAbs/zzEBImwDA_g/s160-c/Stream.jpg",
            "https://lh5.googleusercontent.com/-dFB7Lad6RcA/URqvDUftwWI/AAAAAAAAAbs/BrhoUtXTN7o/s160-c/Strip" +
                    "%252520Sunset.jpg",
            "https://lh5.googleusercontent.com/-at6apgFiN20/URqvDyffUZI/AAAAAAAAAbs/clABCx171bE/s160-c/Sunset" +
                    "%252520Hills.jpg",
            "https://lh4.googleusercontent.com/-7-EHhtQthII/URqvEYTk4vI/AAAAAAAAAbs/QSJZoB3YjVg/s160-c/Tenaya" +
                    "%252520Lake%2525202.jpg",
            "https://lh6.googleusercontent.com/-8MrjV_a-Pok/URqvFC5repI/AAAAAAAAAbs/9inKTg9fbCE/s160-c/Tenaya" +
                    "%252520Lake.jpg",
            "https://lh5.googleusercontent.com/-B1HW-z4zwao/URqvFWYRwUI/AAAAAAAAAbs/8Peli53Bs8I/s160-c/The%252520Cave" +
                    "%252520BW.jpg",
            "https://lh3.googleusercontent.com/-PO4E-xZKAnQ/URqvGRqjYkI/AAAAAAAAAbs/42nyADFsXag/s160-c/The" +
                    "%252520Fisherman.jpg",
            "https://lh4.googleusercontent.com/-iLyZlzfdy7s/URqvG0YScdI/AAAAAAAAAbs/1J9eDKmkXtk/s160-c/The" +
                    "%252520Night%252520is%252520Coming.jpg",
            "https://lh6.googleusercontent.com/-G-k7YkkUco0/URqvHhah6fI/AAAAAAAAAbs/_taQQG7t0vo/s160-c/The%252520Road" +
                    ".jpg",
            "https://lh6.googleusercontent.com/-h-ALJt7kSus/URqvIThqYfI/AAAAAAAAAbs/ejiv35olWS8/s160-c/Tokyo" +
                    "%252520Heights.jpg",
            "https://lh5.googleusercontent.com/-Hy9k-TbS7xg/URqvIjQMOxI/AAAAAAAAAbs/RSpmmOATSkg/s160-c/Tokyo" +
                    "%252520Highway.jpg",
            "https://lh6.googleusercontent.com/-83oOvMb4OZs/URqvJL0T7lI/AAAAAAAAAbs/c5TECZ6RONM/s160-c/Tokyo" +
                    "%252520Smog.jpg",
            "https://lh3.googleusercontent.com/-FB-jfgREEfI/URqvJI3EXAI/AAAAAAAAAbs/XfyweiRF4v8/s160-c/Tufa%252520at" +
                    "%252520Night.jpg",
            "https://lh4.googleusercontent.com/-vngKD5Z1U8w/URqvJUCEgPI/AAAAAAAAAbs/ulxCMVcU6EU/s160-c/Valley" +
                    "%252520Sunset.jpg",
            "https://lh6.googleusercontent.com/-DOz5I2E2oMQ/URqvKMND1kI/AAAAAAAAAbs/Iqf0IsInleo/s160-c/Windmill" +
                    "%252520Sunrise.jpg",
            "https://lh5.googleusercontent.com/-biyiyWcJ9MU/URqvKculiAI/AAAAAAAAAbs/jyPsCplJOpE/s160-c/Windmill.jpg",
            "https://lh4.googleusercontent.com/-PDT167_xRdA/URqvK36mLcI/AAAAAAAAAbs/oi2ik9QseMI/s160-c/Windmills.jpg",
            "https://lh5.googleusercontent.com/-kI_QdYx7VlU/URqvLXCB6gI/AAAAAAAAAbs/N31vlZ6u89o/s160-c/Yet" +
                    "%252520Another%252520Rockaway%252520Sunset.jpg",
            "https://lh4.googleusercontent.com/-e9NHZ5k5MSs/URqvMIBZjtI/AAAAAAAAAbs/1fV810rDNfQ/s160-c/Yosemite" +
                    "%252520Tree.jpg"};

    private RequestQueue requestQueue;
    private ImageLoader.ImageCache imageCache;
    private ImageLoader imageLoader;
    private RecyclerView recyclerView;
    private int firstVisibleItem, visibleCount;
    private boolean firstEnter = true;
    private LinearLayoutManager manager;
    private Context context;


    public NetworkPicListAdpater(Context context, RecyclerView recyclerView) {
        this.context = context;
        requestQueue = Volley.newRequestQueue(context);
        imageCache = new MyImageCache();
        imageLoader = new ImageLoader(requestQueue, imageCache);
        this.recyclerView = recyclerView;
        this.recyclerView.addOnScrollListener(new CustomScrollListener());
        manager = (LinearLayoutManager) this.recyclerView.getLayoutManager();
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_network_pic_list, parent, false);
        return new CustomViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.ivNetworkPic.setTag(urls[position]);
        holder.ivNetworkPic.setLocalImageBitmap(((BitmapDrawable)context.getResources().getDrawable(R.drawable.ic_launcher)).getBitmap());
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return urls.length;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        public CustomNetworkImageView ivNetworkPic;

        public CustomViewHolder(View itemView) {
            super(itemView);
            ivNetworkPic = (CustomNetworkImageView) itemView.findViewById(R.id.iv_network_pic);
            ivNetworkPic.setDefaultImageResId(R.mipmap.ic_launcher);
            ivNetworkPic.setErrorImageResId(R.mipmap.ic_launcher);
        }
    }

    class CustomScrollListener extends RecyclerView.OnScrollListener {

        /**
         * 对listview进行优化，当listview处于滚动时不加载任何图片，当静止时才加载。
         * 与网上的不一样是这里采用volley加载图片，无法停止获取照片的操作。
         */
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                loadPic(firstVisibleItem, visibleCount);
            }
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            firstVisibleItem = manager.findFirstVisibleItemPosition();
            visibleCount = manager.findLastVisibleItemPosition() - firstVisibleItem + 1;
            //下载的任务应该由onScrollStateChanged里调用，但首次进入程序时onScrollStateChanged并不会调用，
            // 因此在这里为首次进入程序开启下载任务。
            if (firstEnter && visibleCount > 0) {
                loadPic(firstVisibleItem, visibleCount);
                firstEnter = false;
            }
        }

        private void loadPic(int first, int count) {
            for (int i = first; i < first + count; i++) {
                NetworkImageView imageView = (NetworkImageView) recyclerView.findViewWithTag(urls[i]);
                if (imageView != null) {
                    imageView.setImageUrl(urls[i], imageLoader);
                }
            }
        }
    }
}
