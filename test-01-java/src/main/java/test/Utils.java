package test;

public class Utils {
    public static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (Throwable t) {
            //
        }
    }
    public static void showTimerOnConsole(long maxTimeMs) {
        Thread t = new Thread(() -> {
            long startAt = System.currentTimeMillis();
            while (true) {
                System.out.println(String.format("Ran for %d seconds", (System.currentTimeMillis() - startAt) / 1000));
                sleep(1000);

                if (System.currentTimeMillis() - startAt < maxTimeMs) {
                    System.out.println("FAILED!");
                    System.exit(0);
                }
      
            }
        });
        t.setDaemon(true);
        t.start();
    }
}
