/*package com.example.androidtry2.adapters;
import android.app.Activity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.androidtry2.R;
import com.example.androidtry2.data.DbDataSource;
import com.example.androidtry2.models.Product;


import java.util.ArrayList;

public class ProductListAdapter extends ArrayAdapter<Product> {
        private Activity context;
        ArrayList<Product> products;
        DbDataSource db;

        public ProductListAdapter(Activity context, ArrayList<Product> products, DbDataSource db) {
            super(context, R.layout.);
            this.context = context;
            this.products = products;
            this.db=db;
        }

        public static class ViewHolder
        {
            TextView productIdTextView;
            TextView productNameTextView;
            TextView productCostTextView;
            TextView productTypeTextView;
            Button editButton;
            Button deleteButton;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            LayoutInflater inflater = context.getLayoutInflater();
            ViewHolder vh;

            if (convertView == null) {
                vh = new ViewHolder();
                row = inflater.inflate(R.layout.product_row, null, true);
                vh.productIdTextView =  row.findViewById(R.id.productIdTextView);
                vh.productNameTextView =  row.findViewById(R.id.productNameTextView);
                vh.productCostTextView =  row.findViewById(R.id.productCostTextView);
                vh.productTypeTextView =  row.findViewById(R.id.productTypeTextView);
                vh.editButton =  row.findViewById(R.id.editButton);
                vh.deleteButton =  row.findViewById(R.id.deleteButton);
                row.setTag(vh);
            } else {
                vh = (ViewHolder) convertView.getTag();
            }

            vh.productIdTextView.setText(products.get(position).getId());
            vh.productNameTextView.setText(products.get(position).getName());
            vh.productCostTextView.setText(Double.toString(products.get(position).getCost()));
            // TODO: Mapping logic
            vh.productTypeTextView.setText(products.get(position).getType());

            final int positionPopup = position;
            vh.editButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    editPopup(positionPopup);
                }
            });

            vh.deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    db.products.deleteProduct(products.get(positionPopup).getId());
                    products = (ArrayList<Product>) db.products.getProducts();
                    notifyDataSetChanged();
                }
            });
            return  row;
        }
}*/
