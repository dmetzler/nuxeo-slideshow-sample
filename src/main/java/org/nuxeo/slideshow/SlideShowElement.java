/**
 *
 */

package org.nuxeo.slideshow;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.nuxeo.ecm.automation.core.operations.business.adapter.BusinessAdapter;
import org.nuxeo.ecm.core.api.ClientException;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.platform.picture.api.adapters.PictureResourceAdapter;
import org.nuxeo.runtime.api.Framework;

/**
 * @author ldoguin
 */
public class SlideShowElement extends BusinessAdapter {

    private static final Log log = LogFactory.getLog(SlideShowElement.class);

    protected final DocumentModel doc;

    public SlideShowElement(DocumentModel doc) {
        this.doc = doc;
    }

    @Override
    public String getId() {
        return doc.getId();
    }

    @Override
    public String getType() {
        return doc.getType();
    }

    public String getTitle() throws ClientException {
        return doc.getTitle();
    }

    public String getDescription() throws ClientException {
        return doc.getProperty("dc:description").getValue(String.class);
    }

    public String getThumbnailURL() {
        return getUrlFor("Thumbnail");

    }

    public String getOriginalURL() {
        return getUrlFor("OriginalJpeg");
    }

    public String getMediumURL() {
        return getUrlFor("Medium");
    }

    private String getUrlFor(String view) {
        PictureResourceAdapter picture = doc.getAdapter(PictureResourceAdapter.class);
        String blobPropertyName = picture.getViewXPath(view) + "content";
        return getBigFileUrl(doc, blobPropertyName, doc.getName()
                + "_" + view.toLowerCase() + ".jpg");
    }


    private String getBigFileUrl(DocumentModel doc, String blobPropertyName,
            String filename) {
        String blobUrl = Framework.getProperty("nuxeo.url");
        blobUrl += "/nxbigfile/";
        blobUrl += doc.getRepositoryName() + "/";
        blobUrl += doc.getId() + "/";
        blobUrl += blobPropertyName + "/";
        blobUrl += filename;
        return blobUrl;
    }

}
