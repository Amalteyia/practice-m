package org.example;
import java.util.List;

public class Main {
    /* Обжарщик кофе заключил контракты с различными поставщиками и хранит информацию о поставщиках в следующем виде
Название сорта кофе;страна происхождения;ферма;тип обработки;высота произрастания
Необходимо найти следующую информацию:
    для каждого типа обработки найти все сорта, которые им обрабатываются;
    страны, в которых кофе растет на высоте более 1500 м;
    для каждой фермы вывести количество выращиваемых сортов;*/

    public static void main(String[] args) {

        System.out.println("Results:");
        List<Producer> producers = CoffeeGenerator.generateProducerList(100);

        System.out.println("Sorts by farm:");
        System.out.println(CoffeeService.getCoffeeCountByFarm(producers) + "\n");

        System.out.println("Countries with altitude > 1500 meters:");
        System.out.println(CoffeeService.getCountriesWithHighAltitude(producers) + "\n");

        System.out.println("Sorts by processing type:");
        System.out.println(CoffeeService.getSortsByProcessingType(producers));
    }
}
