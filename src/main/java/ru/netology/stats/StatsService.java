package ru.netology.stats;

public class StatsService {

    public int shouldFindAll(int[] sales) { //сумма всех продаж
        int allSales = 0;
        for (int i = 0; i < sales.length; i++) {
            allSales = (int) (allSales + sales[i]);
        }
        return allSales;
    }

    public int shouldFindAverage(int[] sales) { //средняя сумма продаж в месяц
        int allSales = shouldFindAll(sales);
        int average = allSales / 12;

        return average;
    }

    public int maxSales(int[] sales) { // номер месяца, в котором был пик продаж
        int maxMonth = 0; // номер месяца с максимальными продажами среди просмотренных ранее

        for (int i = 0; i < sales.length; i++) {
            if (sales[i] >= sales[maxMonth]) { // значит, в рассматриваемом i-м месяце продаж меньше
                maxMonth = i; // запомним его как максимальный
            }
        }
        return maxMonth + 1; // месяца нумеруются с 1, а индексы массива с 0, нужно сдвинуть ответ на 1
    }

    public int minSales(int[] sales) { // номер месяца, в котором был минимум продаж
        int minMonth = 0; // номер месяца с минимальными продажами среди просмотренных ранее

        for (int i = 0; i < sales.length; i++) {
            if (sales[i] <= sales[minMonth]) { // значит, в рассматриваемом i-м месяце продаж меньше
                minMonth = i; // запомним его как минимальный
            }
        }
        return minMonth + 1; // месяца нумеруются с 1, а индексы массива с 0, нужно сдвинуть ответ на 1
    }

    public int lessAverage(int[] sales) { // количество месяцев, в которых продажи были ниже среднего
        int average = shouldFindAverage(sales);
        int less = 0;
        for (int i : sales) {
            if (i < average) {
                less = less + 1;
            }
        }
        return less;
    }

        public int higherAverage(int[] sales) { // количество месяцев, в которых продажи были выше среднего
        int average = shouldFindAverage(sales);
        int higher = 0;
        for (int i : sales) {
            if (i > average) {
                higher = higher + 1;
            }
        }
        return higher;
    }
}