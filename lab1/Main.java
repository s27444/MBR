import java.util.*;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Person person = null;
        try {
            person = new Person("Jan", 20);
        } catch (InvalidAgeExceptation e) {
            System.out.println("Złapano wyjątek: " +e.getMessage());
        }

//        try {
//            Person person2 = new Person("Adam", -5);
//        } catch (InvalidAgeExceptation e) {
//            System.out.println("Złapano wyjątek: " +e.getMessage());
//        }

        try{
            person.setAge(-10);
        } catch (InvalidAgeExceptation e) {
            System.out.println("Złapano wyjątek: " +e.getMessage());
        }

        System.out.println("Imię: " + person.getName() + " wiek: " + person.getAge());

            System.out.println("Osoba: " + person);

            Person person2 = new Person("Magda", 35);
            Person person3 = new Person("Andrzej", 28);

            List<Person> immutablePersonList = List.of(person, person2, person3, person);

//            immutablePersonList.add(Person) -- Rzuca wyjątek ponieważ do listy niemutowalnej nie można dodawać obiektów

            System.out.println("Lista niemutowalna: " + immutablePersonList);

            List<Person> mutablePersonList = new ArrayList<>();
            mutablePersonList.add(person);
            mutablePersonList.add(person2);
            mutablePersonList.add(person3);

            System.out.println("Lista mutowalna: " + mutablePersonList);

            Set<Person> immutablePersonSet = Set.of(person, person2, person3);

            //immutablePersonSet.add(Person) -- Rzuca wyjątek ponieważ do listy niemutowalnej nie można dodawać obiektów

            System.out.println("Set niemutowalny: " + immutablePersonSet);

            Set<Person> mutablePersonSet = new HashSet<>();
            mutablePersonSet.add(person);
            mutablePersonSet.add(person2);
            mutablePersonSet.add(person3);
            mutablePersonSet.add(person);

            System.out.println("Set mutowalny: " + mutablePersonSet);

            //mapy

            Map<Integer, Person> immutablePersonMap = Map.of(1, person, 2, person2, 3, person3);

            System.out.println("Mapa niemutowalna: " + immutablePersonMap);

            Map<String, Person> mutablePersonMap = new HashMap<>();
            mutablePersonMap.put("A", person);
            mutablePersonMap.put("B", person2);
            mutablePersonMap.put("C", person3);
            mutablePersonMap.put("A", person3);

            System.out.println("Mapa mutowalna: " + mutablePersonMap);

            // Streamy

          List<Integer> ageList = immutablePersonList.stream()
                    .map(Person::getAge)
                    .collect(Collectors.toList());
           Integer ageSum = ageList.stream()
                    .reduce(0, (sum, value) -> sum + value);

           System.out.println("suma lat: " + ageSum);

           double averageAge = (double) ageSum / ageList.size();

           System.out.println("Średnia wieku: " + averageAge);

           Integer ageSum1 = immutablePersonList.stream()
                   .map(Person::getAge)
                   .reduce(0, Integer::sum);

           System.out.println("suma stream chain: " + ageSum1);

           List<String> nameList = immutablePersonList.stream()
                   .map(Person::getName)
                   .collect(Collectors.toList());

           System.out.println("Lista imion: " + nameList);

           List<Person> olderPerson = immutablePersonList.stream()
                   .filter(p -> p.getAge() > 25)
                   .collect(Collectors.toList());


            System.out.println("Lista osób powyżej 25 roku życia: " + olderPerson);

        List<Person> sortedPerson = immutablePersonList.stream()
                .sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.toList());


        System.out.println("Posortowana lista: " + sortedPerson);

        immutablePersonList.stream()
                .forEach(p -> {
                    System.out.println("Imię: " + p.getName() + ", Wiek: " + p.getAge());
                });

        Optional<Integer> minAge = immutablePersonList.stream()
                .map(Person::getAge)
                .min(Comparator.naturalOrder());

        Optional<Integer> maxAge = immutablePersonList.stream()
                .map(Person::getAge)
                .max(Comparator.naturalOrder());

        if (minAge.isPresent() && maxAge.isPresent()) {
            System.out.println("Najmniejszy wiek: " + minAge.get());
            System.out.println("Największy wiek: " + maxAge.get());
        }else {
            System.out.println("Brak danych dotyczących wieku.");
        }





        }
    }
