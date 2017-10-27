package blog.contentful.vault;

import com.contentful.vault.Asset;
import com.contentful.vault.ContentType;
import com.contentful.vault.Field;
import com.contentful.vault.Resource;

import org.parceler.Parcel;

import java.util.List;

import blog.contentful.lib.Const;

@ContentType(Const.CONTENT_TYPE_BUSINESS)
@Parcel
public class Business extends Resource {

    @Field
    String title;

    @Field
    String website;

    @Field
    String description;

    @Field
    Asset logo;

    @Field
    String division;

    @Field
    List<String> callOuts;

    public String getTitle() {
        return title;
    }

    public String getWebsite() {
        return website;
    }

    public String getDescription() {
        return description;
    }

    public Asset getLogo() {
        return logo;
    }

    public String getDivision() {
        return division;
    }

    public List<String> getCallOuts() {
        return callOuts;
    }
}
