/**
 * Created by masoudLofti on 7/10/17.
 */
public class DownloadManager {
    private String url;

    private DownloadManagerInterface listener;

    public DownloadManager(String url) {
        this.url = url;
    }


    public void setListener(DownloadManagerInterface listener) {
        this.listener = listener;
    }

    public void run() {
        this.listener.onProgress(20);
    }
}
