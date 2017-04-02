package ohtu.ohtuvarasto;

public class Main {

    public static void main(String[] args) {

        double[] maarat = {100.0 ,20.2, 50.7, 3.14, -100.0, 1000.0, -666.0, -32.9};

        Varasto mehua = new Varasto(maarat[0]);
        Varasto olutta = new Varasto(maarat[0],maarat[1]);

        System.out.println("Luonnin jälkeen:");
        System.out.println("Mehuvarasto: " + mehua);
        System.out.println("Olutvarasto: " + olutta);

        System.out.println("Olutgetterit:");
        System.out.println("getSaldo()     = " + olutta.getSaldo());
        System.out.println("getTilavuus    = " + olutta.getTilavuus());
        System.out.println("paljonkoMahtuu = " + olutta.paljonkoMahtuu());

        System.out.println("Mehusetterit:");
        System.out.println("Lisätään 50.7");
        mehua.lisaaVarastoon(maarat[2]);
        System.out.println("Mehuvarasto: " + mehua);
        System.out.println("Otetaan 3.14");
        mehua.otaVarastosta(maarat[3]);
        System.out.println("Mehuvarasto: " + mehua);

        System.out.println("Virhetilanteita:");
        System.out.println("new Varasto(-100.0);");
        Varasto huono = new Varasto(maarat[4]);
        System.out.println(huono);

        System.out.println("new Varasto(100.0, -50.7)");
        huono = new Varasto(maarat[0], maarat[2]);
        System.out.println(huono);

        System.out.println("Olutvarasto: " + olutta);
        System.out.println("olutta.lisaaVarastoon(1000.0)");
        olutta.lisaaVarastoon(maarat[5]);
        System.out.println("Olutvarasto: " + olutta);

        System.out.println("Mehuvarasto: " + mehua);
        System.out.println("mehua.lisaaVarastoon(-666.0)");
        mehua.lisaaVarastoon(maarat[6]);
        System.out.println("Mehuvarasto: " + mehua);

        System.out.println("Olutvarasto: " + olutta);
        System.out.println("olutta.otaVarastosta(1000.0)");
        double saatiin = olutta.otaVarastosta(maarat[5]);
        System.out.println("saatiin " + saatiin);
        System.out.println("Olutvarasto: " + olutta);

        System.out.println("Mehuvarasto: " + mehua);
        System.out.println("mehua.otaVarastosta(-32.9)");
        saatiin = mehua.otaVarastosta(maarat[7]);
        System.out.println("saatiin " + saatiin);
        System.out.println("Mehuvarasto: " + mehua);
    }
}
