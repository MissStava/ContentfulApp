package blog.contentful.adapters;

import android.view.View;
import android.widget.TextView;

import blog.contentful.R;
import blog.contentful.vault.Business;
import butterknife.Bind;
import butterknife.ButterKnife;

public class BusinessListAdapter extends AbsListAdapter<Business, BusinessListAdapter.ViewHolder> {

    @Override
    protected void bindView(ViewHolder holder, Business business, View rootView) {
        holder.title.setText(business.getTitle());
        holder.division.setText(business.getDivision());
    }

    @Override
    protected ViewHolder createViewHolder(View rootView) {
        return new ViewHolder(rootView);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.list_item_business;
    }

    static class ViewHolder {
        @Bind(R.id.title)
        TextView title;

        @Bind(R.id.division)
        TextView division;

        ViewHolder(View rootView) {
            ButterKnife.bind(this, rootView);
        }
    }
}
