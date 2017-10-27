package blog.contentful.loaders;

import com.commonsware.cwac.anddown.AndDown;
import com.contentful.vault.Asset;

import blog.contentful.vault.Business;

import static org.apache.commons.lang3.StringUtils.defaultString;

public class BusinessLoader extends AbsAsyncLoader<String> {

    final String businessTitle;
    final String businessWebsite;
    final String businessDescription;
    final String businessLogo;
    final String businessDivision;

    public BusinessLoader(Business business) {
        businessTitle = defaultString(business.getTitle(), "");
        businessWebsite = defaultString(business.getWebsite(), "");
        businessDescription = defaultString(business.getDescription(), "");
        businessDivision = defaultString(business.getDivision(), "");

        Asset image = business.getLogo();
        businessLogo = image == null ? null : image.url();
    }

    @SuppressWarnings("StringBufferReplaceableByString")
    @Override
    protected String performLoad() {
        return new StringBuilder().append("<html>")
                .append("<head>")
                .append("<style type=\"text/css\">")
                .append("a:link, a:visited, a:active { color: #4A90E2; font-weight: normal; }")
                .append("h3.top { font-weight: normal; }")
                .append("h4.bottom { font-size: 14px; }")
                .append(".bottom .date { color: #b7c2cc; font-weight: normal; }")
                .append(".thumbnail { width: 200px; display: block; margin: 0 auto; }")
                .append("</style>")
                .append("</head>")
                .append("<body>")
                .append(getThumbnailHtml())
                .append("<h3 class=\"top\">")
                .append(businessTitle)
                .append("</h3>")
                .append("<h4 class=\"bottom\">")
                .append(businessWebsite)
                .append("</h4>")
                .append(new AndDown().markdownToHtml(businessDescription))
                .append("</body></html>")
                .toString();
    }

    private String getThumbnailHtml() {
        String result = "";

        if (businessLogo != null) {
            result = String.format("<img class=\"thumbnail\" src=\"%s\" />", businessLogo);
        }

        return result;
    }
}
