import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int spending = 0;
        int earnings = 0;
        Scanner sc = new Scanner(System.in);

        boolean x = true;
        while (x) {
            showOptions();
            String option = sc.nextLine();
            switch (option)
            {
                case"end":


                    x = false;
                    break;
                case"1":

                    earnings += Integer.parseInt(sc.nextLine());

                    break;
                case"2":

                    spending += Integer.parseInt(sc.nextLine());
                    break;
                case"3":

                    chooseTaxSystem(earnings, spending);
                    break;
                default:
                    System.out.println("неверная команда");
            }
        }
        System.out.println("Программа завершена");

    }

    private static void chooseTaxSystem(int earnings, int spendings) {
        int simpleTax = calcTax6p(earnings);
        int complexTax = calcTax15p(earnings, spendings);
        int minTax = Math.min(simpleTax, complexTax);
        int maxTax = Math.max(simpleTax,complexTax);
        String taxSystem = simpleTax < complexTax ? "УСН доходы" : "УСН доходы минус расходы";
        if (minTax == maxTax) {
            System.out.println("можете выбрать любую систему налообложения");
            System.out.printf("ваш налог составляет: %d рублей", +minTax);
        } else {
            System.out.printf("мы советуем вам  %s\n", taxSystem);
            System.out.printf("ваш налог составит %d рублей\n",  minTax);
            System.out.printf("налог на другой системе %d\n", maxTax);
            System.out.printf("экономия: %d рублей\n", (maxTax - minTax));

        }

    }
    private static int calcTax15p(int earnings,int spendidgs){
        int tax = 15 * (earnings - spendidgs ) / 100;
        return Math.max(tax, 0);
    }

    private static int calcTax6p(int earnings){
        return 6 * earnings / 100 ;
    }
    private static void showOptions(){
        System.out.println("1. Добавить новый доход\n" +
                "2. Добавить новый расход\n" +
                "3. Выбрать систему налогообложения");
    }








}