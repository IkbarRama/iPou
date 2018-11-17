package me.helloworlds.iPou.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

import me.helloworlds.iPou.AppController;
import me.helloworlds.iPou.Model.m_pembeli_home;
import me.helloworlds.iPou.Model.m_pembeli_transaksi;
import me.helloworlds.iPou.R;

public class PembeliTransaksiAdapter extends BaseAdapter {
    private Activity activity;
    private List<m_pembeli_transaksi> list;
    private LayoutInflater inflater;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public PembeliTransaksiAdapter(Activity activity, List<m_pembeli_transaksi> list) {
        this.activity = activity;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(activity, R.layout.list_transaksi_pembeli,null);
        m_pembeli_transaksi m = list.get(position);
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_transaksi_pembeli, null);
        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();

        NetworkImageView imgProduct = (NetworkImageView) view.findViewById(R.id.imgProduct);
        TextView txtJumlah = (TextView) view.findViewById(R.id.txtJumlah);
        TextView txtStatus = (TextView) view.findViewById(R.id.txtStatus);
        TextView txtBukti = (TextView) view.findViewById(R.id.txtBukti);

        txtJumlah.setText(m.getJumlah());
        txtStatus.setText(m.getStatus());
        txtBukti.setText(m.getBukti());
        imgProduct.setImageUrl(m.getImg(),imageLoader);
        view.setTag(m.getId());
        return view;
    }
}
