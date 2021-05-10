package GridViewServices;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.longtrang.vinid.R;

import java.util.List;

public class ServicesAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<Services> servicesList;

    public ServicesAdapter(Context context, int layout, List<Services> servicesList) {
        this.context = context;
        this.layout = layout;
        this.servicesList = servicesList;
    }

    @Override
    public int getCount() {
        return servicesList.size();
    }

    @Override
    public Object getItem(int position) {
        return servicesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    private class ViewHolder {
        TextView textViewServicesName;
        ImageView imageViewServices;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            viewHolder = new ViewHolder();
            viewHolder.textViewServicesName     = convertView.findViewById(R.id.tv_services_name);
            viewHolder.imageViewServices   = convertView.findViewById(R.id.img_services);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textViewServicesName.setText(servicesList.get(position).servicesName);
        viewHolder.imageViewServices.setImageResource(servicesList.get(position).servicesImage);
        return convertView;
    }
}
