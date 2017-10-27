package blog.contentful.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.parceler.Parcels;

import blog.contentful.Intents;
import blog.contentful.R;
import blog.contentful.lib.LoaderId;
import blog.contentful.loaders.BusinessLoader;
import blog.contentful.vault.Business;
import butterknife.Bind;
import butterknife.ButterKnife;

public class BusinessActivity extends AbsActivity {
  @Bind(R.id.web_view) WebView webView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_business);
    ButterKnife.bind(this);

    webView.setWebViewClient(new WebViewClient(){
      @Override public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (url.startsWith(getString(R.string.url_intercept_schema))) {
          startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
          return true;
        }
        return super.shouldOverrideUrlLoading(view, url);
      }
    });

    initLoader();
  }

  private void initLoader() {
    getSupportLoaderManager().initLoader(LoaderId.forClass(BusinessActivity.class),
        getIntent().getExtras(), new LoaderManager.LoaderCallbacks<String>() {
          @Override public Loader<String> onCreateLoader(int id, Bundle args) {
            return new BusinessLoader((Business) Parcels.unwrap(args.getParcelable(Intents.EXTRA_BUSINESS)));
          }

          @Override public void onLoadFinished(Loader<String> loader, String data) {
            webView.loadData(data, "text/html", "utf-8");
          }

          @Override public void onLoaderReset(Loader<String> loader) {

          }
        });
  }
}
