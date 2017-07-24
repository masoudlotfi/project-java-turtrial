/**
 * Created by masoudLofti on 7/10/17.
 */
public class Application implements Runnable, DownloadManagerInterface {

    public int loadingBar = 0;

    @Override
    public void run() {
        DownloadManager downloadManager = new DownloadManager("URL");
        downloadManager.setListener(this);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (loadingBar > 100) {
                        System.out.println("Compile Download file");
                        break;
                    }
                    try {
                        Thread.sleep((2 * 1000));
                        downloadManager.run();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    public void onProgress(int progress) {
        this.loadingBar = this.loadingBar + progress;
        if(this.loadingBar <= 100) {
            System.out.println(this.loadingBar);
        }
    }
}
