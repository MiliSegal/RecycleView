package com.example.myrs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class CustomeAdapter extends RecyclerView.Adapter<CustomeAdapter.MyViewHolder> {

    static ArrayList<DataModel> dataset;
    static ArrayList<DataModel> datasetFull; // Backup of the original dataset for filtering

    public CustomeAdapter(ArrayList<DataModel> dataSet) {

        this.dataset=dataSet;
        this.datasetFull = new ArrayList<>(dataSet); // Copy the dataset for filtering
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textname;
        TextView textversion;
        ImageView imageView;

        public MyViewHolder (View itemView){ //תוכן הקארד
            super(itemView);

            textname=itemView.findViewById(R.id.textView);
            textversion=itemView.findViewById(R.id.textView2);
            imageView=itemView.findViewById(R.id.imageView);

            // Add OnClickListener to itemView
            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Display a Toast with information about the clicked item
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        //Toast.makeText(view.getContext(), "Item clicked: " + dataset.get(position).getVersion(), Toast.LENGTH_SHORT).show();
                        //Snackbar.make(view, "Item clicked: " + dataset.get(position).getVersion(), Snackbar.LENGTH_INDEFINITE).show();
                    }
                }
            });*/
        }
    }

    @NonNull
    @Override
    public CustomeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //יוצר אצ הקארד

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardlayout, parent,false);
        MyViewHolder myVHolder=new MyViewHolder(view);

        return myVHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomeAdapter.MyViewHolder holder, int position) { //עוברים על תאי המערך ומשבצים על גבי הרשומות

        holder.textname.setText(dataset.get(position).getName());
        holder.textversion.setText(dataset.get(position).getVersion());
        holder.imageView.setImageResource(dataset.get(position).getImage());

        // Set OnClickListener for each item
        holder.itemView.setOnClickListener(new View.OnClickListener() { //לוחצת על הרשומה וקופצת הודעה עם מידע על הדמות
            @Override
            public void onClick(View v) {
                // Create and show the BottomSheetDialogFragment with dynamic message
                String mes=dataset.get(position).getSummery();
                //String message = dataset.get(position).getName() + dataset.get(position).getVersion();
                YourBottomSheetDialogFragment bottomSheetDialogFragment = YourBottomSheetDialogFragment.newInstance(mes);
                bottomSheetDialogFragment.show(((AppCompatActivity) v.getContext()).getSupportFragmentManager(), bottomSheetDialogFragment.getTag());
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                List<DataModel> filteredList = new ArrayList<>();

                if (constraint == null || constraint.length() == 0) {
                    filteredList.addAll(datasetFull);
                } else {
                    String filterPattern = constraint.toString().toLowerCase().trim();
                    for (DataModel item : datasetFull) {
                        if (item.getName().toLowerCase().contains(filterPattern)) {
                            filteredList.add(item);
                        }
                    }
                }

                FilterResults results = new FilterResults();
                results.values = filteredList;
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                dataset.clear();
                dataset.addAll((List<DataModel>) results.values);
                notifyDataSetChanged();
            }
        };
    }
}
