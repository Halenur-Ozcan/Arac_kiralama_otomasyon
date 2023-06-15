import java.util.ArrayList;         // gerekli import işlemleri yapılır

public class ArabaListesi {


    private String marka, model, vites, renk, yakitTuru, kasaTipi;      // gerekli değişkenler tanımlanır
    private int modelYili, kilometre, beygirGucu;
    private float motorHacmi, kiralamaBedeli;
    
    public ArrayList <ArabaListesi> aracListesi = new ArrayList <> ();      // array list tanımlanır

    
    public ArabaListesi(){
        
    }

    public ArabaListesi(String kasaTipi, String marka,String model, int modelYili, String vites, String yakitTuru, int kilometre, String renk, int beygirGucu, float motorHacmi, float kiralamaBedeli){
        this.kasaTipi = kasaTipi;
        this.marka = marka;
        this.model = model;
        this.modelYili = modelYili;
        this.vites = vites;
        this.yakitTuru = yakitTuru;
        this.kilometre = kilometre;
        this.renk = renk;
        this.beygirGucu = beygirGucu;
        this.motorHacmi = motorHacmi;
        this.kiralamaBedeli = kiralamaBedeli;
    }

    public void araclarListesi(){       // ArabaListesi sınıfndan nesneler oluşturulup içine gerekli veriler atanır

        ArabaListesi a1 = new ArabaListesi("Hatchback", "Hyundai", "i10", 2022, "Manuel", "Benzin", 5000, "Siyah", 67, 1.0f, 400.0f );
        ArabaListesi a2 = new ArabaListesi("Hatchback", "Hyundai","i20" ,2019, "Manuel", "Benzin", 50000, "Beyaz", 74, 1.4f, 500.0f);
        ArabaListesi a3 = new ArabaListesi("Hatchback", "Fiat", "Egea" ,2020, "Manuel", "Benzin", 30000, "Gri", 95, 1.4f, 500.0f);
        ArabaListesi a4 = new ArabaListesi("Hatchback", "Renault", "Clio" ,2022, "Manuel", "Benzin", 5000, "Siyah", 65, 1.0f, 500.0f);
        ArabaListesi a5 = new ArabaListesi("Hatchback", "Kia", "Picanto" ,2022, "Otomatik", "Benzin", 3000, "Beyaz", 67, 1.0f, 500.0f);
        ArabaListesi a6 = new ArabaListesi("Hatchback", "Kia", "Rio" ,2022, "Manuel", "Benzin", 5000, "Beyaz", 84, 1.2f, 500.0f);
        ArabaListesi a7 = new ArabaListesi("Hatchback", "Kia", "Ceed" ,2022, "Manuel", "Benzin", 6000, "Siyah", 100, 1.4f, 500.0f);
        ArabaListesi a8 = new ArabaListesi("Hatchback", "Ford", "Fiesta" ,2021, "Otomatik", "Benzin", 10000, "Beyaz", 100, 1.0f, 600.0f);
        ArabaListesi a9 = new ArabaListesi("Hatchback", "Ford", "Focus" ,2021, "Manuel", "Benzin", 10000, "Beyaz", 120, 1.5f, 600.0f);
        ArabaListesi a10 = new ArabaListesi("Hatchback", "Citroen", "C3" ,2022, "Manuel", "Benzin", 3000, "Siyah", 83, 1.2f, 500.0f);
        ArabaListesi a11 = new ArabaListesi("Hatchback", "Nissan", "Micra" ,2019, "Manuel", "Benzin", 50000, "Beyaz", 92, 1.0f, 500.0f);
        ArabaListesi a12 = new ArabaListesi("Hatchback", "Opel", "Corsa" ,2021, "Manuel", "Benzin", 10000, "Gri", 75, 1.2f, 500.0f);
        ArabaListesi a13 = new ArabaListesi("Hatchback", "Peugeot", "208" ,2020, "Manuel", "Benzin", 40000, "Siyah", 75, 1.2f, 500.0f);
        ArabaListesi a14 = new ArabaListesi("Hatchback", "Peugeot", "308" ,2021, "Otomatik", "Benzin", 25000, "Beyaz", 130, 1.2f, 650.0f);
        ArabaListesi a15 = new ArabaListesi("Hatchback", "Seat", "Ibiza" ,2022, "Manuel", "Benzin", 5000, "Beyaz", 80, 1.0f, 500.0f);
        ArabaListesi a16 = new ArabaListesi("Hatchback", "Seat", "Ibiza" ,2020, "Otomatik", "Benzin", 30000, "Siyah", 110, 1.0f, 600.0f);
        ArabaListesi a17 = new ArabaListesi("Hatchback", "Seat", "Leon" ,2019, "Otomatik", "Benzin", 50000, "Beyaz", 130, 1.5f, 700.0f);
        ArabaListesi a18 = new ArabaListesi("Hatchback", "Toyota", "Yaris" ,2020, "Manuel", "Benzin", 30000, "Gri", 72, 1.0f, 500.0f);
        ArabaListesi a19 = new ArabaListesi("Hatchback", "Toyota", "Yaris" ,2019, "Otomatik", "Benzin", 50000, "Siyah", 125, 1.5f, 600.0f);
        ArabaListesi a20 = new ArabaListesi("Hatchback", "Toyota", "Corolla" ,2019, "Otomatik", "Benzin", 50000, "Beyaz", 116, 1.2f, 700.0f);
        ArabaListesi a21 = new ArabaListesi("Hatchback", "Volkswagen", "Polo" ,2021, "Manuel", "Benzin", 30000, "Gri", 80, 1.0f, 500.0f);
        ArabaListesi a22 = new ArabaListesi("Hatchback", "Volkswagen", "Polo" ,2021, "Otomatik", "Benzin", 35000, "Siyah", 95, 1.0f, 650.0f);
        ArabaListesi a23 = new ArabaListesi("Hatchback", "Volkswagen", "Golf" ,2022, "Manuel", "Benzin", 7000, "Beyaz", 110, 1.0f, 600.0f);
        ArabaListesi a24 = new ArabaListesi("Hatchback", "Volkswagen", "Golf" ,2022, "Otomatik", "Benzin", 7000, "Beyaz", 110, 1.0f, 700.0f);
        ArabaListesi a25 = new ArabaListesi("Sedan", "Hyundai", "Accent" ,2019, "Manuel", "Dizel", 50000, "Beyaz", 130, 1.4f, 650.0f);
        ArabaListesi a26 = new ArabaListesi("Sedan", "Fiat", "Egea" ,2019, "Manuel", "Dizel", 55000, "Siyah", 120, 1.3f, 650.0f);
        ArabaListesi a27 = new ArabaListesi("Sedan", "Fiat", "Egea" ,2018, "Otomatik", "Benzin", 70000, "Beyaz", 130, 1.6f, 750.0f);
        ArabaListesi a28 = new ArabaListesi("Sedan", "Renault", "Megane" ,2021, "Manuel", "Dizel", 20000, "Beyaz", 140, 1.6f,700.0f);
        ArabaListesi a29 = new ArabaListesi("Sedan", "Renault", "Megane" ,2021, "Otomatik", "Benzin", 25000, "Siyah", 140, 1.6f, 800.0f);
        ArabaListesi a30 = new ArabaListesi("Sedan", "Ford", "Focus" ,2020, "Manuel", "Dizel", 35000, "Beyaz", 140, 1.5f, 700.0f);
        ArabaListesi a31 = new ArabaListesi("Sedan", "Ford", "Focus" ,2019, "Otomatik", "Benzin", 50000, "Gri", 140, 1.5f, 800.0f);
        ArabaListesi a32 = new ArabaListesi("Sedan", "Peugeot", "301" ,2022, "Manuel", "Benzin", 5000, "Siyah", 100, 1.2f, 650.0f);
        ArabaListesi a33 = new ArabaListesi("Sedan", "Peugeot", "301" ,2022, "Otomatik", "Dizel", 8000, "Beyaz", 150, 1.6f, 700.0f);
        ArabaListesi a34 = new ArabaListesi("Sedan", "Toyota", "Corolla" ,2020, "Manuel", "Dizel", 60000, "Gri", 140, 1.6f, 700.0f);
        ArabaListesi a35 = new ArabaListesi("Sedan", "Toyota", "Corolla" ,2020, "Otomatik", "Benzin", 60000, "Siyah", 150, 1.6f, 800.0f);
        ArabaListesi a36 = new ArabaListesi("Sedan", "Volkswagen", "Passat" ,2019, "Otomatik", "Dizel", 60000, "Beyaz", 160, 1.6f, 800.0f);
        

        // array liste bu nesneler eklenir

        aracListesi.add(a1);
        aracListesi.add(a2);
        aracListesi.add(a3);
        aracListesi.add(a4);
        aracListesi.add(a5);
        aracListesi.add(a6);
        aracListesi.add(a7);
        aracListesi.add(a8);
        aracListesi.add(a9);
        aracListesi.add(a10);
        aracListesi.add(a11);
        aracListesi.add(a12);
        aracListesi.add(a13);
        aracListesi.add(a14);
        aracListesi.add(a15);
        aracListesi.add(a16);
        aracListesi.add(a17);
        aracListesi.add(a18);
        aracListesi.add(a19);
        aracListesi.add(a20);
        aracListesi.add(a21);
        aracListesi.add(a22);
        aracListesi.add(a23);
        aracListesi.add(a24);
        aracListesi.add(a25);
        aracListesi.add(a26);
        aracListesi.add(a27);
        aracListesi.add(a28);
        aracListesi.add(a29);
        aracListesi.add(a30);
        aracListesi.add(a31);
        aracListesi.add(a32);
        aracListesi.add(a33);
        aracListesi.add(a34);
        aracListesi.add(a35);
        aracListesi.add(a36);

    }

    public String getKasaTipi() {
        return kasaTipi;
    }
    public void setKasaTipi(String kasaTipi) {
        this.kasaTipi = kasaTipi;
    }
    
    public String getMarka() {
        return marka;
    }
    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public int getModelYili() {
        return modelYili;
    }
    public void setModelYili(int modelYili) {
        this.modelYili = modelYili;
    }

    public String getVites() {
        return vites;
    }
    public void setVites(String vites) {
        this.vites = vites;
    }

    public String getYakitTuru() {
        return yakitTuru;
    }
    public void setYakitTuru(String yakitTuru) {
        this.yakitTuru = yakitTuru;
    }

    public int getKilometre() {
        return kilometre;
    }
    public void setKilometre(int kilometre) {
        this.kilometre = kilometre;
    }

    public String getRenk() {
        return renk;
    }
    public void setRenk(String renk) {
        this.renk = renk;
    }

    public int getBeygirGucu() {
        return beygirGucu;
    }
    public void setBeygirGucu(int beygirGucu) {
        this.beygirGucu = beygirGucu;
    }

    public float getMotorHacmi() {
        return motorHacmi;
    }
    public void setMotorHacmi(float motorHacmi) {
        this.motorHacmi = motorHacmi;
    }

    public float getKiralamaBedeli() {
        return kiralamaBedeli;
    }
    public void setKiralamaBedeli(float kiralamaBedeli) {
        this.kiralamaBedeli = kiralamaBedeli;
    }

}


