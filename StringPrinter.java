import java.util.Scanner;

public class StringPrinter {
    private static String sharedString = "Hello, World!";

    public static void main(String[] args) {
        Thread readerThread = new Thread(new Reader());
        Thread printerThread = new Thread(new Printer());

        readerThread.start();
        printerThread.start();
    }

    static class Reader extends Thread {
        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a string:");
            sharedString = scanner.nextLine();
            scanner.close();
        }
    }

    static class Printer extends Thread {
        public void run() {
            while (true) {
                System.out.println(sharedString);
                try {
                    Thread.sleep(1000); // Sleep for 1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
