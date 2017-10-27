package blog.contentful.loaders;

import com.contentful.vault.Vault;

import java.util.List;

import blog.contentful.vault.Business;
import blog.contentful.vault.SampleProjectSpace;

public class BusinessListLoader extends AbsAsyncLoader<BusinessListLoader.Result> {

    public BusinessListLoader() {
        super();
    }

    @Override
    protected Result performLoad() {

        Vault vault = Vault.with(getContext(), SampleProjectSpace.class);
        List<Business> businesses = vault.fetch(Business.class).all();

        return new Result(businesses);
    }

    public static class Result {

        private final List<Business> businesses;

        public Result(List<Business> businesses) {
            this.businesses = businesses;
        }

        public List<Business> businesses() {
            return businesses;
        }
    }
}
