public class Main {
    public static void main(String[] args) throws InterruptedException {
        Application app = null;
        DataBasesEnum dbEnum = DataBasesEnum.MONGO;
        switch (dbEnum) {
            case MONGO:
                app = new Application(new MongoDB());
            case REDIS:
                //app = redis
                app = new Application(new SqlServer());
            case SQL_SERVER:
                app = new Application(new SqlServer());
        }
        app.run();
    }
}
