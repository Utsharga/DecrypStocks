import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
/* 
 * Testing class through command line. Runs the application.
 */
public class Main {
    // args[0] = targetDate, args[1] = budget, args[2] = minGrowth, args[3] = stockname
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Target date (yyyy-mm-dd form): ");
        String targetDate = s.next();
        System.out.println("Budget: ");
        double budget = s.nextDouble();
        System.out.println("Minimum Growth (percentage): ");
        double minG = s.nextDouble();
        s.close();
        
        LocalDate target = LocalDate.parse(targetDate);
        ArrayMakerADT a = new ArrayMakerADT(target, budget, minG);
        for (int i = a.stocks.size() - 1; i >= 0; i--)
            System.out.println(a.stocks.get(i).name + " growth: " + a.stocks.get(i).getGrowth() + " price: " + a.stocks.get(i).getPrice());
        Graph g = new Graph(a.stocks);
        ArrayList<StockADT> x = g.getAdj(a.stocks.get(1));
        for (int i = 0; i < x.size(); i++)
            System.out.println(x.get(i).name);
    }
}