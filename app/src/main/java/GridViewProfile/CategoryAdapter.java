package GridViewProfile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.longtrang.vinid.R;

import java.util.List;

public class CategoryAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<Category> categoryList;

    public CategoryAdapter(Context context, int layout, List<Category> categoryList) {
        this.context = context;
        this.layout = layout;
        this.categoryList = categoryList;
    }

    @Override
    public int getCount() {
        return categoryList.size();
    }

    @Override
    public Object getItem(int position) {
        return categoryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    private class ViewHolder {
        ImageView imageViewCategory;
        TextView textViewCategoryName;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            viewHolder = new ViewHolder();
            viewHolder.imageViewCategory    = convertView.findViewById(R.id.img_category);
            viewHolder.textViewCategoryName = convertView.findViewById(R.id.tv_category_name);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.imageViewCategory.setImageResource(categoryList.get(position).categoryImage);
        viewHolder.textViewCategoryName.setText(categoryList.get(position).categoryName);
        return convertView;
    }
}
