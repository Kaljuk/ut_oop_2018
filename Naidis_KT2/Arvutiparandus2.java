import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Arvutiparandus
 */
public class Arvutiparandus2 {

    public static void main(String[] args) {

        System.out.println("Dell;tavatöö;mnitoriga");
        String[] testTooted = {"Lenovo;tavatöö@2017-03-25T12:34:12", "Ordi;kiirtöö;monitoriga@2017-04-12T10:12:45"};
        try {
            loeArvuti(testTooted[0]);
            loeArvuti(testTooted[1]);
            
        } catch(FormaadiErind e) {
            System.out.println(e);
            System.exit(0);
        }

        sessioon();
    }

    private static Arvuti loeArvuti(String tooKirjeldus) throws FormaadiErind{
        LocalDateTime aeg = LocalDateTime.now();
        String[] andmedJaAeg = tooKirjeldus.split("@");
        String[] andmed = andmedJaAeg[0].split(";");
        for (String s : andmed) {
            System.out.println(s);
        }

        // If has time, parse it
        if (andmedJaAeg.length > 1) {
            aeg = LocalDateTime.parse(andmedJaAeg[1]);
        }

        // Check for errors
        
        // semikoolonitega eraldatud väljade arv on väiksem, kui kaks, või suurem, kui kolm
        if (andmed.length < 2 || andmed.length > 3) throw new FormaadiErind();

        Arrays.asList(andmed).stream().anyMatch(x -> { System.out.println("---"+x);return false; });
        
        // töö tüübi väljas olev väärtus ei ole "tavatöö" ega "kiirtöö"
        if ( !Arrays.asList(andmed).stream().anyMatch(x -> (x.equals("tavatöö") || x.equals("kiirtöö"))) ) { 
            throw new FormaadiErind("Töö tüübi väljas olev väärtus ei ole 'tavatöö' ega 'kiirtöö'"); 
        };
        // väljade arv on kolm, aga kolmanda välja väärtus ei ole "monitoriga"
        if (!andmed[andmed.length-1].equals("monitoriga") && andmed.length == 3) throw new FormaadiErind("Väljade arv on kolm, aga kolmanda välja väärtus ei ole 'monitoriga'");

        // Instantiate the data
        Arvuti arvuti = (andmed.length < 3)? new Arvuti() : new VäliseMonitorigaArvuti();
        arvuti.setRegistreerimisAeg(aeg);

        return arvuti;
    }

    private static void parandaArvuti(Scanner sc) {
        int minutid = scannerInt(sc, "Sisesta parandamiseks kulunud aeg (täisminutites): ");
        System.out.println(minutid);
        Arvuti arvuti = getArvuti(sc, "Arvuti info: ");

    }

    
    private static void sooritaTegevus(Scanner sc, String tegevus) {
        switch(tegevus) {
            // parandada (P) 
            case "p":
                parandaArvuti(sc);
            break;
            // uut tööd registreerida (R)
            case "r":
                //regitreeriTöö();
            break;
            //  või lõpetada (L)
            case "l":
                //lõpetaTöö();
            break;
        }
    }

    private static void sessioon() {
        String[] validOptions = {"p", "l", "r"};
        boolean endSession = false;
        double teenitudSumma = 0;
        String tegevus;
        Scanner sc = new Scanner(System.in, "utf8");
        while(!endSession) {
            tegevus = getOption(sc, validOptions);
            sooritaTegevus(sc, tegevus);
        }
    }

    private static Arvuti getArvuti(Scanner sc, String msg) {
        boolean validAnswer = false;
        Arvuti arvuti;
        while(!validAnswer) {
            System.out.print(msg);
            try {
                arvuti = loeArvuti(String.valueOf(sc.nextLine()));    
                return arvuti;
            } catch(FormaadiErind e) {
                // Go for another loop
                validAnswer = false;
                System.out.println(e);
            }
        }
        return null;
    }

    private static String getOption(Scanner sc) {
        return String.valueOf(sc.nextLine());
    }

    private static String getOption(Scanner sc, String[] validOptions) {
        boolean validAnswer = false;
        String option = "";
        
        System.out.print("\nKas soovid parandada (P), uut tööd registreerida (R) või lõpetada (L) ?");
        while(!validAnswer) {
            option = String.valueOf(sc.nextLine()).toLowerCase();
            final String o = option;
            if (Arrays.asList(validOptions).stream().anyMatch(validOption -> (validOption.equals(o)) )) {
                validAnswer = true;
            } else {
                // Go for another loop
                validAnswer = false;
                // Show errorMsg when input hasnt met requirements
                System.out.print("\nKas soovid parandada (P), õuut tööd registreerida (R) või lõpetada (L) ?");
            }
        }
        return option;
    }

    public static int scannerInt(Scanner sc, String msg) {
        boolean gotInt = false;
        int scannedInt = 0;
        System.out.print(msg);
        while (!gotInt) {
            try {
                scannedInt = Integer.valueOf(sc.nextLine());
                gotInt = true;
            } catch (NumberFormatException e) {
                gotInt     = false;
                System.out.print("\n"+msg);
            }
        }
        return scannedInt;
    }
}