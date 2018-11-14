
package rxjava.vinsofts.com.rxjava.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Media {

    @SerializedName("transcodings")
    @Expose
    private List<Transcoding> transcodings = null;

    public List<Transcoding> getTranscodings() {
        return transcodings;
    }

    public void setTranscodings(List<Transcoding> transcodings) {
        this.transcodings = transcodings;
    }

}
