package blog.contentful.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.Loader;
import android.view.View;

import org.parceler.Parcels;

import java.util.List;

import blog.contentful.Intents;
import blog.contentful.adapters.AbsListAdapter;
import blog.contentful.adapters.BusinessListAdapter;
import blog.contentful.lib.LoaderId;
import blog.contentful.loaders.BusinessListLoader;
import blog.contentful.vault.Business;

public class BusinessListActivity extends AbsListActivity<Business, BusinessListLoader.Result> {

  @Override protected int getLoaderId() {
    return LoaderId.forClass(BusinessListActivity.class);
  }

  @Override protected AbsListAdapter<Business, ?> createAdapter() {
    return new BusinessListAdapter();
  }

  @Override public Loader<BusinessListLoader.Result> onCreateLoader(int id, Bundle args) {
    return new BusinessListLoader();
  }

  @Override protected List<Business> getResultList(BusinessListLoader.Result data) {
    return data.businesses();
  }

  @Override public void onLoadFinished(Loader<BusinessListLoader.Result> loader, BusinessListLoader.Result data) {
    super.onLoadFinished(loader, data);
  }

  @Override void onItemClick(View v, int position) {
    int headerViewsCount = listView.getHeaderViewsCount();
    if (headerViewsCount > 0 && position < headerViewsCount) {
      return;
    }

    Business business = adapter.getItem(position - headerViewsCount);
    startActivity(new Intent(this, BusinessActivity.class)
        .putExtra(Intents.EXTRA_BUSINESS, Parcels.wrap(business)));
  }

  @Override protected void initList() {
    super.initList();
  }
}
