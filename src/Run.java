import java.util.Scanner;
import java.util.logging.StreamHandler;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Run {
    public static void main(String[] args) {
        String [][] csv=new String [30] [11];
        //id - int
        // meno, priezvisko,email,mesto,stat,telefon, heslo - String
        // datumNarodenia,poslednePrihlasenie - DATE
        // pohlavie - M|F
        //id,meno,priezvisko,email,mesto,stat,telefon,datumNarodenie,heslo,pohlavie,datumPrihlasenia
        csv[0] = new String[]{"1", "Ján", "Novák", "jan.novak@example.com", "Bratislava", "Slovensko", "123456789", "1990-05-15", "password", "M", ""};
        csv[1] = new String[]{"2", "Peter", "Horváth", "peter.horvath@example.com", "Košice", "Slovensko", "987654321", "1985-08-22", "secret", "M", ""};
        csv[2] = new String[]{"3", "Martin", "Kováč", "martin.kovac@example.com", "Prešov", "Slovensko", "555111222", "1988-03-10", "123456", "M", ""};
        csv[3] = new String[]{"4", "Miroslav", "Varga", "miroslav.varga@example.com", "Žilina", "Slovensko", "999888777", "1992-06-25", "p@ssw0rd", "M", ""};
        csv[4] = new String[]{"5", "Michal", "Molnár", "michal.molnar@example.com", "Nitra", "Slovensko", "777333999", "1995-01-05", "qwerty", "M", ""};
        csv[5] = new String[]{"6", "Pavol", "Szabó", "pavol.szabo@example.com", "Banská Bystrica", "Slovensko", "444555666", "1983-11-30", "abcdef", "M", ""};
        csv[6] = new String[]{"7", "Marek", "Baláž", "marek.balaz@example.com", "Trnava", "Slovensko", "222333444", "1998-09-12", "pass123", "M", ""};
        csv[7] = new String[]{"8", "Lukáš", "Hruška", "lukas.hruska@example.com", "Trenčín", "Slovensko", "666444222", "1987-04-18", "securepwd", "M", ""};
        csv[8] = new String[]{"9", "Tomáš", "Krajčí", "tomas.krajci@example.com", "Martin", "Slovensko", "888999000", "1993-07-30", "letmein", "M", ""};
        csv[9] = new String[]{"10", "Adam", "Tóth", "adam.toth@example.com", "Poprad", "Slovensko", "333222111", "1989-02-07", "welcome", "M", ""};
        csv[10] = new String[]{"11", "Eva", "Nováková", "eva.novakova@example.com", "Bratislava", "Slovensko", "111222333", "1991-05-20", "test123", "F", ""};
        csv[11] = new String[]{"12", "Anna", "Horváthová", "anna.horvathova@example.com", "Košice", "Slovensko", "777888999", "1984-10-18", "abc123", "F", ""};
        csv[12] = new String[]{"13", "Martina", "Kováčová", "martina.kovacova@example.com", "Prešov", "Slovensko", "555111222", "1996-03-25", "letmeout", "F", ""};
        csv[13] = new String[]{"14", "Veronika", "Vargová", "veronika.vargova@example.com", "Žilina", "Slovensko", "999000111", "1990-09-03", "password123", "F", ""};
        csv[14] = new String[]{"15", "Barbora", "Molnárová", "barbora.molnarova@example.com", "Nitra", "Slovensko", "444555666", "1988-12-28", "secretword", "F", ""};
        csv[15] = new String[]{"16", "Simona", "Szabóová", "simona.szaboova@example.com", "Banská Bystrica", "Slovensko", "777888999", "1994-07-07", "12345678", "F", ""};
        csv[16] = new String[]{"17", "Michaela", "Balážová", "michaela.balazova@example.com", "Trnava", "Slovensko", "333444555", "1986-04-19", "abcdefg", "F", ""};
        csv[17] = new String[]{"18", "Natalia", "Hrušková", "natalia.hruskova@example.com", "Trenčín", "Slovensko", "555666777", "1992-01-25", "passpass", "F", ""};
        csv[18] = new String[]{"19", "Lucia", "Krajčíová", "lucia.krajciova@example.com", "Martin", "Slovensko", "888999000", "1989-11-11", "letmein123", "F", ""};
        csv[19] = new String[]{"20", "Zuzana", "Tóthová", "zuzana.tothova@example.com", "Poprad", "Slovensko", "111222333", "1995-08-07", "testpass", "F", ""};
        csv[20] = new String[]{"21", "Filip", "Novák", "filip.novak@example.com", "Bratislava", "Slovensko", "999888777", "1987-06-09", "abc123xyz", "M", ""};
        csv[21] = new String[]{"22", "Lenka", "Horváthová", "lenka.horvathova@example.com", "Košice", "Slovensko", "444555666", "1993-03-17", "letmein456", "F", ""};
        csv[22] = new String[]{"23", "Dominik", "Kováč", "dominik.kovac@example.com", "Prešov", "Slovensko", "777888999", "1990-12-01", "password456", "M", ""};
        csv[23] = new String[]{"24", "Xavier", "Brown", "xavier.brown@example.com", "CityX", "CountryX", "222333444", "1984-09-18", "xyz789", "M", ""};
        csv[24] = new String[]{"25", "Yvonne", "Miller", "yvonne.miller@example.com", "CityY", "CountryY", "666777888", "1996-05-24", "hello123", "F", ""};
        csv[25] = new String[]{"26", "Zach", "Taylor", "zach.taylor@example.com", "CityZ", "CountryZ", "333444555", "1988-02-13", "987654321", "M", ""};
        csv[26] = new String[]{"27", "Alice", "Jones", "alice.jones@example.com", "CityA", "CountryX", "555666777", "1991-10-05", "test1234", "F", ""};
        csv[27] = new String[]{"28", "Ben", "Johnson", "ben.johnson@example.com", "CityB", "CountryY", "888999000", "1986-07-21", "abcdef123", "M", ""};
        csv[28] = new String[]{"29", "Caroline", "Brown", "caroline.brown@example.com", "CityC", "CountryZ", "999000111", "1994-04-14", "letmeout123", "F", ""};
        csv[29] = new String[]{"30", "David", "Lee", "david.lee@example.com", "CityD", "CountryX", "111222333", "1989-12-09", "password789", "M", ""};


        //vytvorenie objektu typu userservice, ktory bude riesit nacitanie uzivatelov a ich prihlasovanie
        UserService userService=new UserService();
        //zavolanie metody pre nacitanie
        userService.parseArray(csv);
        //userService.parseCSV("ffsdafdasfasd");
        //scanner bude citat vstup z konzoly
        String pokracovat="";
        do {
            Scanner citac = new Scanner(System.in);
            System.out.println("Email: ");
            String email = citac.next();
            System.out.println("Heslo: ");
            String heslo = citac.next();
            User prihlaseny = userService.login(email, heslo);
            if (prihlaseny != null) {
                System.out.println(prihlaseny.getMeno());
                System.out.println(prihlaseny.prezentujSa());
            }
            System.out.println("Chces pokracovat? ano/nie");
            pokracovat = citac.next();
        }while (!pokracovat.equalsIgnoreCase("nie"));
        //tu implementovat prihlasaenie.
        // ak sa podari prihlasit uzivatela,tak ho odprezentovat
        // inak vypisat hlasku nespravne prihlasovacie udaje

        //upravte scanner tak aby sa po kazdom prihlaseni opytal ci mame pokracovat a ak napiseme ano, tak vypise
        // znova text aby sme zadali meno, ak napiseme nie, tak skonci.
    }
}