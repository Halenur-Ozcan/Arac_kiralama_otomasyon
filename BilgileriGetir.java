import java.lang.System;                // gerekli import işlemleri yapılır
import java.util.Scanner;
import java.util.ArrayList;
import java.util.stream.Collectors;






public class BilgileriGetir {

    Scanner sc = new Scanner(System.in);    
    
    private float deger;            // gerekli değişken tanımlanır

   
   
    public BilgileriGetir() {

    }


    
    
    public void aracBilgiSorgu() {                // ARAC BILGILERINI MAIN'E GONDEREN METOD

        ArabaListesi nesne = new ArabaListesi();

        nesne.araclarListesi();     // bu fonksiyon çalıştığında  ArabaListesi sınıfnda nesneler oluşur veri girişleri sağlanır

        // araç kasa tipi kullanıcıdan alınır
        System.out.println("Kiralamak istediginiz aracin kasa tipini (Hatchback - Sedan) giriniz: ");
        nesne.setKasaTipi(sc.nextLine());

        // kullanıcıdan veri alınırken büyük-küçük karakter yok sayılması için uygun işlem yapılır
        if(nesne.getKasaTipi().equalsIgnoreCase("Hatchback")){          // HATCHBACK
            
            // eğer kullanıcı hatchback girişi yaparsa hatchback içeren array list elemanları dışındakiler silinir
            // bir nevi filtreleme işlemi uygulanır
            nesne.aracListesi.removeIf(a -> !a.getKasaTipi().contains("Hatchback"));

            System.out.println("");
            
            System.out.println("Kiralamak istediginiz aracin vites turunu giriniz: (Otomatik - Manuel)");
            // vites türü alınır
            nesne.setVites(sc.nextLine());
            
            // büyük küçük harf duyarlılığı yok sayılır
            if (nesne.getVites().equalsIgnoreCase("Otomatik")){

                // otomatik olmayan araçlar araaylist'ten silinir
                nesne.aracListesi.removeIf(a -> !a.getVites().contains("Otomatik"));

                System.out.println("Kiralayabileceginiz ( Hatchback - Otomatik ) Arabalarin Marka Listesi: Kia-Ford-Peugeot-Seat-Toyota-Volkswagen");
                
                System.out.println("Kiralamak istediginiz aracin markasini giriniz: ");
                // marka alınır
                nesne.setMarka(sc.nextLine());

                // büyük küçük harf duyarlılığı yok sayılır
                if(nesne.getMarka().equalsIgnoreCase("Kia")){
                    
                    // kia marka olmayan araçlar araaylist'ten silinir
                    nesne.aracListesi.removeIf(a -> !a.getMarka().contains("Kia"));

                    System.out.println("Kiralayabileceginiz (Kia Marka-Hatchback-Otomatik) Arabalarin Model Listesi: "+nesne.aracListesi
                            .stream()
                            .map(v -> v.getModel())
                            .collect(Collectors.toList()));
                    
                    System.out.println("Kiralamak istediginiz aracin modelini giriniz: ");
                    // model alınır
                    nesne.setModel(sc.nextLine());
                
                    // büyük küçük harf duyarlılığı yok sayılır
                    if(nesne.getModel().equalsIgnoreCase("Picanto")){
                        

                        // filteleme sonunda uygun aracın ayrıntıları map kullanarak ekrana yazdırılır
                        System.out.println("Kiralayabileceginiz (Kia Marka-Picanto Model-Hatchback-Otomatik) Arabalarin Ayrintilari: "+nesne.aracListesi
                            .stream()
                            .map(v -> "\nMarka: "+v.getMarka()+ "\nModel: "+v.getModel()+ "\nModel Yılı: "+v.getModelYili()+ "\nVites Turu: "+v.getVites()+ "\nYakit Turu: "+v.getYakitTuru()+ "\nKilometre Degeri: "+v.getKilometre()+ "\nRenk: "+v.getRenk()+ "\nBeygir Degeri: "+v.getBeygirGucu()+ "\nMotor Hacmi: "+v.getMotorHacmi()+ "\nKiralama Bedeli(Gunluk): "+v.getKiralamaBedeli()+" TL\n")
                            .collect(Collectors.toList()));

                        // kiralama bedelini discount sınıfına göndermek için yeni array list oluşturulur
                        
                        ArrayList<Float> bedeller = new ArrayList<>(nesne.aracListesi
                            .stream()
                            .map(a -> a.getKiralamaBedeli())
                            .collect(Collectors.toList()));
                        
                        // map yardımıyla filteleme işlemi sonundaki aracın kiralama bedeli gönderilmek üzere
                        // başka bir değişkene atarnır
                        deger = bedeller.get(bedeller.size()-1); 

                    } else {        // doğru model girişi yapılmazsa işlem sonlandırılır
                        System.out.println("Hatali Giris Yaptiniz!");
                        System.out.println("Islem sonlandiriliyor");
                        System.exit(0);
                    }
                
                    // diğer marka modeller için aynı işlemler uygulanır

                } else if(nesne.getMarka().equalsIgnoreCase("Ford")){
                    
                    nesne.aracListesi.removeIf(a -> !a.getMarka().contains("Ford"));

                    System.out.println("Kiralayabileceginiz (Ford Marka-Hatchback-Otomatik) Arabalarin Model Listesi: "+nesne.aracListesi
                            .stream()
                            .map(v -> v.getModel())
                            .collect(Collectors.toList()));
                    
                    System.out.println("Kiralamak istediginiz aracin modelini giriniz: ");
                    nesne.setModel(sc.nextLine());
                    
                    
                    if(nesne.getModel().equalsIgnoreCase("Fiesta")){
                        
                        System.out.println("Kiralayabileceginiz (Ford Marka-Fiesta Model-Hatchback-Otomatik) Arabalarin Ayrintilari: "+nesne.aracListesi
                            .stream()
                            .map(v -> "\nMarka: "+v.getMarka()+ "\nModel: "+v.getModel()+ "\nModel Yılı: "+v.getModelYili()+ "\nVites Turu: "+v.getVites()+ "\nYakit Turu: "+v.getYakitTuru()+ "\nKilometre Degeri: "+v.getKilometre()+ "\nRenk: "+v.getRenk()+ "\nBeygir Degeri: "+v.getBeygirGucu()+ "\nMotor Hacmi: "+v.getMotorHacmi()+ "\nKiralama Bedeli(Gunluk): "+v.getKiralamaBedeli()+" TL\n")
                            .collect(Collectors.toList()));

                    
                        ArrayList<Float> bedeller = new ArrayList<>(nesne.aracListesi
                            .stream()
                            .map(a -> a.getKiralamaBedeli())
                            .collect(Collectors.toList()));
                        
                        deger = bedeller.get(bedeller.size()-1);
            
                    } else {
                        System.out.println("Hatali Giris Yaptiniz!");
                        System.out.println("Islem sonlandiriliyor");
                        System.exit(0);
                    }

                } else if(nesne.getMarka().equalsIgnoreCase("Peugeot")){
                    
                    nesne.aracListesi.removeIf(a -> !a.getMarka().contains("Peugeot"));

                    System.out.println("Kiralayabileceginiz (Peugeot Marka-Hatchback-Otomatik) Arabalarin Model Listesi: "+nesne.aracListesi
                            .stream()
                            .map(v -> v.getModel())
                            .collect(Collectors.toList()));
                    
                    System.out.println("Kiralamak istediginiz aracin modelini giriniz: ");
                    nesne.setModel(sc.nextLine());
                    
                    
                    if(nesne.getModel().equalsIgnoreCase("308")){
                        
                        System.out.println("Kiralayabileceginiz (Peugeot Marka-308 Model-Hatchback-Otomatik) Arabalarin Ayrintilari: "+nesne.aracListesi
                            .stream()
                            .map(v -> "\nMarka: "+v.getMarka()+ "\nModel: "+v.getModel()+ "\nModel Yılı: "+v.getModelYili()+ "\nVites Turu: "+v.getVites()+ "\nYakit Turu: "+v.getYakitTuru()+ "\nKilometre Degeri: "+v.getKilometre()+ "\nRenk: "+v.getRenk()+ "\nBeygir Degeri: "+v.getBeygirGucu()+ "\nMotor Hacmi: "+v.getMotorHacmi()+ "\nKiralama Bedeli(Gunluk): "+v.getKiralamaBedeli()+" TL\n")
                            .collect(Collectors.toList()));

                    
                        ArrayList<Float> bedeller = new ArrayList<>(nesne.aracListesi
                            .stream()
                            .map(a -> a.getKiralamaBedeli())
                            .collect(Collectors.toList()));
                        
                        deger = bedeller.get(bedeller.size()-1);
    
                    } else {
                        System.out.println("Hatali Giris Yaptiniz!");
                        System.out.println("Islem sonlandiriliyor");
                        System.exit(0);
                    }
                
                } else if(nesne.getMarka().equalsIgnoreCase("Seat")){
                    
                    nesne.aracListesi.removeIf(a -> !a.getMarka().contains("Seat"));

                    System.out.println("Kiralayabileceginiz (Seat Marka-Hatchback-Otomatik) Arabalarin Model Listesi: "+nesne.aracListesi
                            .stream()
                            .map(v -> v.getModel())
                            .collect(Collectors.toList()));
                    
                    System.out.println("Kiralamak istediginiz aracin modelini giriniz: ");
                    nesne.setModel(sc.nextLine());
                    
                    
                    if(nesne.getModel().equalsIgnoreCase("Ibiza")){
                        
                        nesne.aracListesi.removeIf(a -> !a.getModel().contains("Ibiza"));
                        System.out.println("Kiralayabileceginiz (Seat Marka-Ibiza Model-Hatchback-Otomatik) Arabalarin Ayrintilari: "+nesne.aracListesi
                            .stream()
                            .map(v -> "\nMarka: "+v.getMarka()+ "\nModel: "+v.getModel()+ "\nModel Yılı: "+v.getModelYili()+ "\nVites Turu: "+v.getVites()+ "\nYakit Turu: "+v.getYakitTuru()+ "\nKilometre Degeri: "+v.getKilometre()+ "\nRenk: "+v.getRenk()+ "\nBeygir Degeri: "+v.getBeygirGucu()+ "\nMotor Hacmi: "+v.getMotorHacmi()+ "\nKiralama Bedeli(Gunluk): "+v.getKiralamaBedeli()+" TL\n")
                            .collect(Collectors.toList()));

                    
                        ArrayList<Float> bedeller = new ArrayList<>(nesne.aracListesi
                            .stream()
                            .map(a -> a.getKiralamaBedeli())
                            .collect(Collectors.toList()));
                        
                        deger = bedeller.get(bedeller.size()-1);
                    
                    } else if (nesne.getModel().equalsIgnoreCase("Leon")) {
                        
                        nesne.aracListesi.removeIf(a -> !a.getModel().contains("Leon"));
                        System.out.println("Kiralayabileceginiz (Seat Marka-Leon Model-Hatchback-Otomatik) Arabalarin Ayrintilari: "+nesne.aracListesi
                            .stream()
                            .map(v -> "\nMarka: "+v.getMarka()+ "\nModel: "+v.getModel()+ "\nModel Yılı: "+v.getModelYili()+ "\nVites Turu: "+v.getVites()+ "\nYakit Turu: "+v.getYakitTuru()+ "\nKilometre Degeri: "+v.getKilometre()+ "\nRenk: "+v.getRenk()+ "\nBeygir Degeri: "+v.getBeygirGucu()+ "\nMotor Hacmi: "+v.getMotorHacmi()+ "\nKiralama Bedeli(Gunluk): "+v.getKiralamaBedeli()+" TL\n")
                            .collect(Collectors.toList()));

                    
                        ArrayList<Float> bedeller = new ArrayList<>(nesne.aracListesi
                            .stream()
                            .map(a -> a.getKiralamaBedeli())
                            .collect(Collectors.toList()));
                        
                        deger = bedeller.get(bedeller.size()-1);
                    
                    } else {
                        System.out.println("Hatali Giris Yaptiniz!");
                        System.out.println("Islem sonlandiriliyor");
                        System.exit(0);
                    }
                
                } else if(nesne.getMarka().equalsIgnoreCase("Toyota")){
                    
                    nesne.aracListesi.removeIf(a -> !a.getMarka().contains("Toyota"));

                    System.out.println("Kiralayabileceginiz (Toyota Marka-Hatchback-Otomatik) Arabalarin Model Listesi: "+nesne.aracListesi
                            .stream()
                            .map(v -> v.getModel())
                            .collect(Collectors.toList()));
                    
                    System.out.println("Kiralamak istediginiz aracin modelini giriniz: ");
                    nesne.setModel(sc.nextLine());
                    
                    
                    if(nesne.getModel().equalsIgnoreCase("Yaris")){
                        
                        nesne.aracListesi.removeIf(a -> !a.getModel().contains("Yaris"));

                        System.out.println("Kiralayabileceginiz (Toyota Marka-Yaris Model-Hatchback-Otomatik) Arabalarin Ayrintilari: "+nesne.aracListesi
                            .stream()
                            .map(v -> "\nMarka: "+v.getMarka()+ "\nModel: "+v.getModel()+ "\nModel Yılı: "+v.getModelYili()+ "\nVites Turu: "+v.getVites()+ "\nYakit Turu: "+v.getYakitTuru()+ "\nKilometre Degeri: "+v.getKilometre()+ "\nRenk: "+v.getRenk()+ "\nBeygir Degeri: "+v.getBeygirGucu()+ "\nMotor Hacmi: "+v.getMotorHacmi()+ "\nKiralama Bedeli(Gunluk): "+v.getKiralamaBedeli()+" TL\n")
                            .collect(Collectors.toList()));

                    
                        ArrayList<Float> bedeller = new ArrayList<>(nesne.aracListesi
                            .stream()
                            .map(a -> a.getKiralamaBedeli())
                            .collect(Collectors.toList()));
                        
                        deger = bedeller.get(bedeller.size()-1);
                    
                    } else if (nesne.getModel().equalsIgnoreCase("Corolla")) {
                        
                        nesne.aracListesi.removeIf(a -> !a.getModel().contains("Corolla"));

                        System.out.println("Kiralayabileceginiz (Toyota Marka-Corolla Model-Hatchback-Otomatik) Arabalarin Ayrintilari: "+nesne.aracListesi
                            .stream()
                            .map(v -> "\nMarka: "+v.getMarka()+ "\nModel: "+v.getModel()+ "\nModel Yılı: "+v.getModelYili()+ "\nVites Turu: "+v.getVites()+ "\nYakit Turu: "+v.getYakitTuru()+ "\nKilometre Degeri: "+v.getKilometre()+ "\nRenk: "+v.getRenk()+ "\nBeygir Degeri: "+v.getBeygirGucu()+ "\nMotor Hacmi: "+v.getMotorHacmi()+ "\nKiralama Bedeli(Gunluk): "+v.getKiralamaBedeli()+" TL\n")
                            .collect(Collectors.toList()));

                    
                        ArrayList<Float> bedeller = new ArrayList<>(nesne.aracListesi
                            .stream()
                            .map(a -> a.getKiralamaBedeli())
                            .collect(Collectors.toList()));
                        
                        deger = bedeller.get(bedeller.size()-1);
                    
                    } else {
                        System.out.println("Hatali Giris Yaptiniz!");
                        System.out.println("Islem sonlandiriliyor");
                        System.exit(0);
                    } 
                
                } else if (nesne.getMarka().equalsIgnoreCase("Volkswagen")){
                    
                    nesne.aracListesi.removeIf(a -> !a.getMarka().contains("Volkswagen"));

                    System.out.println("Kiralayabileceginiz (Volkswagen Marka-Hatchback-Otomatik) Arabalarin Model Listesi: "+nesne.aracListesi
                            .stream()
                            .map(v -> v.getModel())
                            .collect(Collectors.toList()));
                    
                    System.out.println("Kiralamak istediginiz aracin modelini giriniz: ");
                    nesne.setModel(sc.nextLine());
                    
                    
                    if(nesne.getModel().equalsIgnoreCase("Polo")){
                        
                        nesne.aracListesi.removeIf(a -> !a.getModel().contains("Polo"));

                        System.out.println("Kiralayabileceginiz (Volkswagen Marka-Polo Model-Hatchback-Otomatik) Arabalarin Ayrintilari: "+nesne.aracListesi
                            .stream()
                            .map(v -> "\nMarka: "+v.getMarka()+ "\nModel: "+v.getModel()+ "\nModel Yılı: "+v.getModelYili()+ "\nVites Turu: "+v.getVites()+ "\nYakit Turu: "+v.getYakitTuru()+ "\nKilometre Degeri: "+v.getKilometre()+ "\nRenk: "+v.getRenk()+ "\nBeygir Degeri: "+v.getBeygirGucu()+ "\nMotor Hacmi: "+v.getMotorHacmi()+ "\nKiralama Bedeli(Gunluk): "+v.getKiralamaBedeli()+" TL\n")
                            .collect(Collectors.toList()));

                    
                        ArrayList<Float> bedeller = new ArrayList<>(nesne.aracListesi
                            .stream()
                            .map(a -> a.getKiralamaBedeli())
                            .collect(Collectors.toList()));
                        
                        deger = bedeller.get(bedeller.size()-1);
                    
                    
                    } else if (nesne.getModel().equalsIgnoreCase("Golf")) {
                        
                        nesne.aracListesi.removeIf(a -> !a.getModel().contains("Golf"));

                        System.out.println("Kiralayabileceginiz (Volkswagen Marka-Golf Model-Hatchback-Otomatik) Arabalarin Ayrintilari: "+nesne.aracListesi
                            .stream()
                            .map(v -> "\nMarka: "+v.getMarka()+ "\nModel: "+v.getModel()+ "\nModel Yılı: "+v.getModelYili()+ "\nVites Turu: "+v.getVites()+ "\nYakit Turu: "+v.getYakitTuru()+ "\nKilometre Degeri: "+v.getKilometre()+ "\nRenk: "+v.getRenk()+ "\nBeygir Degeri: "+v.getBeygirGucu()+ "\nMotor Hacmi: "+v.getMotorHacmi()+ "\nKiralama Bedeli(Gunluk): "+v.getKiralamaBedeli()+" TL\n")
                            .collect(Collectors.toList()));

                    
                        ArrayList<Float> bedeller = new ArrayList<>(nesne.aracListesi
                            .stream()
                            .map(a -> a.getKiralamaBedeli())
                            .collect(Collectors.toList()));
                        
                        deger = bedeller.get(bedeller.size()-1);

                    } else {
                        System.out.println("Hatali Giris Yaptiniz!");
                        System.out.println("Islem sonlandiriliyor");
                        System.exit(0);
                    }
                
                } else {
                    
                    System.out.println("Hatali Giris Yaptiniz!");
                    System.out.println("Islem sonlandiriliyor");
                    System.exit(0);
                    
                }


            } else if(nesne.getVites().equalsIgnoreCase("Manuel")){     //MANUEL SEÇİMİ
                
                // manuel vites dışındaki araçlar listeden silinir
                nesne.aracListesi.removeIf(a -> !a.getVites().contains("Manuel"));
            
                System.out.println("Kiralayabileceginiz ( Hatchback - Manuel ) Arabalarin Marka Listesi: Hyundai-Fiat-Renault-Kia-Ford-Citroen-Nissan-Opel-Seat-Toyota-Volkswagen");
                
                System.out.println("Kiralamak istediginiz aracin markasini giriniz: ");
                nesne.setMarka(sc.nextLine());

                if(nesne.getMarka().equalsIgnoreCase("Hyundai")){
                    
                    nesne.aracListesi.removeIf(a -> !a.getMarka().contains("Hyundai"));

                    System.out.println("Kiralayabileceginiz (Hyundai Marka-Hatchback-Manuel) Arabalarin Model Listesi: "+nesne.aracListesi
                            .stream()
                            .map(v -> v.getModel())
                            .collect(Collectors.toList()));
                    
                    System.out.println("Kiralamak istediginiz aracin modelini giriniz: ");
                    nesne.setModel(sc.nextLine());

                    if(nesne.getModel().equalsIgnoreCase("i10")){
                        
                        nesne.aracListesi.removeIf(a -> !a.getModel().contains("i10"));

                        System.out.println("Kiralayabileceginiz (Hyundai Marka-i10 Model-Hatchback-Manuel) Arabalarin Ayrintilari: "+nesne.aracListesi
                            .stream()
                            .map(v -> "\nMarka: "+v.getMarka()+ "\nModel: "+v.getModel()+ "\nModel Yılı: "+v.getModelYili()+ "\nVites Turu: "+v.getVites()+ "\nYakit Turu: "+v.getYakitTuru()+ "\nKilometre Degeri: "+v.getKilometre()+ "\nRenk: "+v.getRenk()+ "\nBeygir Degeri: "+v.getBeygirGucu()+ "\nMotor Hacmi: "+v.getMotorHacmi()+ "\nKiralama Bedeli(Gunluk): "+v.getKiralamaBedeli()+" TL\n")
                            .collect(Collectors.toList()));

                    
                        ArrayList<Float> bedeller = new ArrayList<>(nesne.aracListesi
                            .stream()
                            .map(a -> a.getKiralamaBedeli())
                            .collect(Collectors.toList()));
                        
                        deger = bedeller.get(bedeller.size()-1);

                    
                    } else if(nesne.getModel().equalsIgnoreCase("i20")){
                        
                        nesne.aracListesi.removeIf(a -> !a.getModel().contains("i20"));

                        System.out.println("Kiralayabileceginiz (Hyundai Marka-i20 Model-Hatchback-Manuel) Arabalarin Ayrintilari: "+nesne.aracListesi
                            .stream()
                            .map(v -> "\nMarka: "+v.getMarka()+ "\nModel: "+v.getModel()+ "\nModel Yılı: "+v.getModelYili()+ "\nVites Turu: "+v.getVites()+ "\nYakit Turu: "+v.getYakitTuru()+ "\nKilometre Degeri: "+v.getKilometre()+ "\nRenk: "+v.getRenk()+ "\nBeygir Degeri: "+v.getBeygirGucu()+ "\nMotor Hacmi: "+v.getMotorHacmi()+ "\nKiralama Bedeli(Gunluk): "+v.getKiralamaBedeli()+" TL\n")
                            .collect(Collectors.toList()));

                    
                        ArrayList<Float> bedeller = new ArrayList<>(nesne.aracListesi
                            .stream()
                            .map(a -> a.getKiralamaBedeli())
                            .collect(Collectors.toList()));
                        
                        deger = bedeller.get(bedeller.size()-1);
                    
                    } else {
                        System.out.println("Hatali Giris Yaptiniz!");
                        System.out.println("Islem sonlandiriliyor");
                        System.exit(0);
                    }
                
                } else if(nesne.getMarka().equalsIgnoreCase("Fiat")){
                    
                    nesne.aracListesi.removeIf(a -> !a.getMarka().contains("Fiat"));

                    System.out.println("Kiralayabileceginiz (Fiat Marka-Hatchback-Manuel) Arabalarin Model Listesi: "+nesne.aracListesi
                            .stream()
                            .map(v -> v.getModel())
                            .collect(Collectors.toList()));
                    
                    System.out.println("Kiralamak istediginiz aracin modelini giriniz: ");
                    nesne.setModel(sc.nextLine());

                    if(nesne.getModel().equalsIgnoreCase("Egea")){
                        
                        System.out.println("Kiralayabileceginiz (Fiat Marka-Egea Model-Hatchback-Manuel) Arabalarin Ayrintilari: "+nesne.aracListesi
                            .stream()
                            .map(v -> "\nMarka: "+v.getMarka()+ "\nModel: "+v.getModel()+ "\nModel Yılı: "+v.getModelYili()+ "\nVites Turu: "+v.getVites()+ "\nYakit Turu: "+v.getYakitTuru()+ "\nKilometre Degeri: "+v.getKilometre()+ "\nRenk: "+v.getRenk()+ "\nBeygir Degeri: "+v.getBeygirGucu()+ "\nMotor Hacmi: "+v.getMotorHacmi()+ "\nKiralama Bedeli(Gunluk): "+v.getKiralamaBedeli()+" TL\n")
                            .collect(Collectors.toList()));

                    
                        ArrayList<Float> bedeller = new ArrayList<>(nesne.aracListesi
                            .stream()
                            .map(a -> a.getKiralamaBedeli())
                            .collect(Collectors.toList()));
                        
                        deger = bedeller.get(bedeller.size()-1);

                    } else {
                        System.out.println("Hatali Giris Yaptiniz!");
                        System.out.println("Islem sonlandiriliyor");
                        System.exit(0);
                    }

                } else if(nesne.getMarka().equalsIgnoreCase("Renault")){
                    
                    nesne.aracListesi.removeIf(a -> !a.getMarka().contains("Renault"));

                    System.out.println("Kiralayabileceginiz (Renault Marka-Hatchback-Manuel) Arabalarin Model Listesi: "+nesne.aracListesi
                            .stream()
                            .map(v -> v.getModel())
                            .collect(Collectors.toList()));
                    
                    System.out.println("Kiralamak istediginiz aracin modelini giriniz: ");
                    nesne.setModel(sc.nextLine());

                    if(nesne.getModel().equalsIgnoreCase("Clio")){
                        
                        System.out.println("Kiralayabileceginiz (Renault Marka-Clio Model-Hatchback-Manuel) Arabalarin Ayrintilari: "+nesne.aracListesi
                            .stream()
                            .map(v -> "\nMarka: "+v.getMarka()+ "\nModel: "+v.getModel()+ "\nModel Yılı: "+v.getModelYili()+ "\nVites Turu: "+v.getVites()+ "\nYakit Turu: "+v.getYakitTuru()+ "\nKilometre Degeri: "+v.getKilometre()+ "\nRenk: "+v.getRenk()+ "\nBeygir Degeri: "+v.getBeygirGucu()+ "\nMotor Hacmi: "+v.getMotorHacmi()+ "\nKiralama Bedeli(Gunluk): "+v.getKiralamaBedeli()+" TL\n")
                            .collect(Collectors.toList()));

                    
                        ArrayList<Float> bedeller = new ArrayList<>(nesne.aracListesi
                            .stream()
                            .map(a -> a.getKiralamaBedeli())
                            .collect(Collectors.toList()));
                        
                        deger = bedeller.get(bedeller.size()-1);

                    
                    } else {
                        System.out.println("Hatali Giris Yaptiniz!");
                        System.out.println("Islem sonlandiriliyor");
                        System.exit(0);
                    }
            
                } else if(nesne.getMarka().equalsIgnoreCase("Kia")){
                    
                    nesne.aracListesi.removeIf(a -> !a.getMarka().contains("Kia"));

                    System.out.println("Kiralayabileceginiz (Kia Marka-Hatchback-Manuel) Arabalarin Model Listesi: "+nesne.aracListesi
                            .stream()
                            .map(v -> v.getModel())
                            .collect(Collectors.toList()));
                    
                    System.out.println("Kiralamak istediginiz aracin modelini giriniz: ");
                    nesne.setModel(sc.nextLine());

                    if(nesne.getModel().equalsIgnoreCase("Rio")){
                        
                        nesne.aracListesi.removeIf(a -> !a.getModel().contains("Rio"));

                        System.out.println("Kiralayabileceginiz (Kia Marka-Rio Model-Hatchback-Manuel) Arabalarin Ayrintilari: "+nesne.aracListesi
                            .stream()
                            .map(v -> "\nMarka: "+v.getMarka()+ "\nModel: "+v.getModel()+ "\nModel Yılı: "+v.getModelYili()+ "\nVites Turu: "+v.getVites()+ "\nYakit Turu: "+v.getYakitTuru()+ "\nKilometre Degeri: "+v.getKilometre()+ "\nRenk: "+v.getRenk()+ "\nBeygir Degeri: "+v.getBeygirGucu()+ "\nMotor Hacmi: "+v.getMotorHacmi()+ "\nKiralama Bedeli(Gunluk): "+v.getKiralamaBedeli()+" TL\n")
                            .collect(Collectors.toList()));

                    
                        ArrayList<Float> bedeller = new ArrayList<>(nesne.aracListesi
                            .stream()
                            .map(a -> a.getKiralamaBedeli())
                            .collect(Collectors.toList()));
                        
                        deger = bedeller.get(bedeller.size()-1);

                    
                    } else if(nesne.getModel().equalsIgnoreCase("Ceed")){
                        
                        nesne.aracListesi.removeIf(a -> !a.getModel().contains("Ceed"));

                        System.out.println("Kiralayabileceginiz (Kia Marka-Ceed Model-Hatchback-Manuel) Arabalarin Ayrintilari: "+nesne.aracListesi
                            .stream()
                            .map(v -> "\nMarka: "+v.getMarka()+ "\nModel: "+v.getModel()+ "\nModel Yılı: "+v.getModelYili()+ "\nVites Turu: "+v.getVites()+ "\nYakit Turu: "+v.getYakitTuru()+ "\nKilometre Degeri: "+v.getKilometre()+ "\nRenk: "+v.getRenk()+ "\nBeygir Degeri: "+v.getBeygirGucu()+ "\nMotor Hacmi: "+v.getMotorHacmi()+ "\nKiralama Bedeli(Gunluk): "+v.getKiralamaBedeli()+" TL\n")
                            .collect(Collectors.toList()));

                    
                        ArrayList<Float> bedeller = new ArrayList<>(nesne.aracListesi
                            .stream()
                            .map(a -> a.getKiralamaBedeli())
                            .collect(Collectors.toList()));
                        
                        deger = bedeller.get(bedeller.size()-1);
                    
                    } else {
                        System.out.println("Hatali Giris Yaptiniz!");
                        System.out.println("Islem sonlandiriliyor");
                        System.exit(0);
                    }
            
                } else if(nesne.getMarka().equalsIgnoreCase("Ford")){
                    
                    nesne.aracListesi.removeIf(a -> !a.getMarka().contains("Ford"));

                    System.out.println("Kiralayabileceginiz (Ford Marka-Hatchback-Manuel) Arabalarin Model Listesi: "+nesne.aracListesi
                            .stream()
                            .map(v -> v.getModel())
                            .collect(Collectors.toList()));
                    
                    System.out.println("Kiralamak istediginiz aracin modelini giriniz: ");
                    nesne.setModel(sc.nextLine());

                    if(nesne.getModel().equalsIgnoreCase("Focus")){
                        
                        System.out.println("Kiralayabileceginiz (Ford Marka-Focus Model-Hatchback-Manuel) Arabalarin Ayrintilari: "+nesne.aracListesi
                            .stream()
                            .map(v -> "\nMarka: "+v.getMarka()+ "\nModel: "+v.getModel()+ "\nModel Yılı: "+v.getModelYili()+ "\nVites Turu: "+v.getVites()+ "\nYakit Turu: "+v.getYakitTuru()+ "\nKilometre Degeri: "+v.getKilometre()+ "\nRenk: "+v.getRenk()+ "\nBeygir Degeri: "+v.getBeygirGucu()+ "\nMotor Hacmi: "+v.getMotorHacmi()+ "\nKiralama Bedeli(Gunluk): "+v.getKiralamaBedeli()+" TL\n")
                            .collect(Collectors.toList()));

                    
                        ArrayList<Float> bedeller = new ArrayList<>(nesne.aracListesi
                            .stream()
                            .map(a -> a.getKiralamaBedeli())
                            .collect(Collectors.toList()));
                        
                        deger = bedeller.get(bedeller.size()-1);

                    
                    } else {
                        System.out.println("Hatali Giris Yaptiniz!");
                        System.out.println("Islem sonlandiriliyor");
                        System.exit(0);
                    }
                
                } else if(nesne.getMarka().equalsIgnoreCase("Citroen")){
                    
                    nesne.aracListesi.removeIf(a -> !a.getMarka().contains("Citroen"));

                    System.out.println("Kiralayabileceginiz (Citroen Marka-Hatchback-Manuel) Arabalarin Model Listesi: "+nesne.aracListesi
                            .stream()
                            .map(v -> v.getModel())
                            .collect(Collectors.toList()));
                    
                    System.out.println("Kiralamak istediginiz aracin modelini giriniz: ");
                    nesne.setModel(sc.nextLine());

                    if(nesne.getModel().equalsIgnoreCase("C3")){
                        
                        System.out.println("Kiralayabileceginiz (Citroen Marka-C3 Model-Hatchback-Manuel) Arabalarin Ayrintilari: "+nesne.aracListesi
                            .stream()
                            .map(v -> "\nMarka: "+v.getMarka()+ "\nModel: "+v.getModel()+ "\nModel Yılı: "+v.getModelYili()+ "\nVites Turu: "+v.getVites()+ "\nYakit Turu: "+v.getYakitTuru()+ "\nKilometre Degeri: "+v.getKilometre()+ "\nRenk: "+v.getRenk()+ "\nBeygir Degeri: "+v.getBeygirGucu()+ "\nMotor Hacmi: "+v.getMotorHacmi()+ "\nKiralama Bedeli(Gunluk): "+v.getKiralamaBedeli()+" TL\n")
                            .collect(Collectors.toList()));

                    
                        ArrayList<Float> bedeller = new ArrayList<>(nesne.aracListesi
                            .stream()
                            .map(a -> a.getKiralamaBedeli())
                            .collect(Collectors.toList()));
                        
                        deger = bedeller.get(bedeller.size()-1);

                    
                    } else {
                        System.out.println("Hatali Giris Yaptiniz!");
                        System.out.println("Islem sonlandiriliyor");
                        System.exit(0);     //MODELLERİN ALTINA ELSE ICINDE BUNLLRI GİR
                    }
                
                } else if(nesne.getMarka().equalsIgnoreCase("Nissan")){
                    
                    nesne.aracListesi.removeIf(a -> !a.getMarka().contains("Nissan"));

                    System.out.println("Kiralayabileceginiz (Nissan Marka-Hatchback-Manuel) Arabalarin Model Listesi: "+nesne.aracListesi
                            .stream()
                            .map(v -> v.getModel())
                            .collect(Collectors.toList()));
                    
                    System.out.println("Kiralamak istediginiz aracin modelini giriniz: ");
                    nesne.setModel(sc.nextLine());

                    if(nesne.getModel().equalsIgnoreCase("Micra")){
                        
                        System.out.println("Kiralayabileceginiz (Nissan Marka-Micra Model-Hatchback-Manuel) Arabalarin Ayrintilari: "+nesne.aracListesi
                            .stream()
                            .map(v -> "\nMarka: "+v.getMarka()+ "\nModel: "+v.getModel()+ "\nModel Yılı: "+v.getModelYili()+ "\nVites Turu: "+v.getVites()+ "\nYakit Turu: "+v.getYakitTuru()+ "\nKilometre Degeri: "+v.getKilometre()+ "\nRenk: "+v.getRenk()+ "\nBeygir Degeri: "+v.getBeygirGucu()+ "\nMotor Hacmi: "+v.getMotorHacmi()+ "\nKiralama Bedeli(Gunluk): "+v.getKiralamaBedeli()+" TL\n")
                            .collect(Collectors.toList()));

                    
                        ArrayList<Float> bedeller = new ArrayList<>(nesne.aracListesi
                            .stream()
                            .map(a -> a.getKiralamaBedeli())
                            .collect(Collectors.toList()));
                        
                        deger = bedeller.get(bedeller.size()-1);

                    } else {
                        System.out.println("Hatali Giris Yaptiniz!");
                        System.out.println("Islem sonlandiriliyor");
                        System.exit(0); 
                    }

                } else if(nesne.getMarka().equalsIgnoreCase("Opel")){
                    
                    nesne.aracListesi.removeIf(a -> !a.getMarka().contains("Opel"));

                    System.out.println("Kiralayabileceginiz (Opel Marka-Hatchback-Manuel) Arabalarin Model Listesi: "+nesne.aracListesi
                            .stream()
                            .map(v -> v.getModel())
                            .collect(Collectors.toList()));
                    
                    System.out.println("Kiralamak istediginiz aracin modelini giriniz: ");
                    nesne.setModel(sc.nextLine());

                    if(nesne.getModel().equalsIgnoreCase("Corsa")){
                        
                        System.out.println("Kiralayabileceginiz (Opel Marka-Corsa Model-Hatchback-Manuel) Arabalarin Ayrintilari: "+nesne.aracListesi
                            .stream()
                            .map(v -> "\nMarka: "+v.getMarka()+ "\nModel: "+v.getModel()+ "\nModel Yılı: "+v.getModelYili()+ "\nVites Turu: "+v.getVites()+ "\nYakit Turu: "+v.getYakitTuru()+ "\nKilometre Degeri: "+v.getKilometre()+ "\nRenk: "+v.getRenk()+ "\nBeygir Degeri: "+v.getBeygirGucu()+ "\nMotor Hacmi: "+v.getMotorHacmi()+ "\nKiralama Bedeli(Gunluk): "+v.getKiralamaBedeli()+" TL\n")
                            .collect(Collectors.toList()));

                    
                        ArrayList<Float> bedeller = new ArrayList<>(nesne.aracListesi
                            .stream()
                            .map(a -> a.getKiralamaBedeli())
                            .collect(Collectors.toList()));
                        
                        deger = bedeller.get(bedeller.size()-1);

                    } else{
                        System.out.println("Hatali Giris Yaptiniz!");
                        System.out.println("Islem sonlandiriliyor");
                        System.exit(0); 
                    }
                
                } else if(nesne.getMarka().equalsIgnoreCase("Seat")){
                    
                    nesne.aracListesi.removeIf(a -> !a.getMarka().contains("Seat"));

                    System.out.println("Kiralayabileceginiz (Seat Marka-Hatchback-Manuel) Arabalarin Model Listesi: "+nesne.aracListesi
                            .stream()
                            .map(v -> v.getModel())
                            .collect(Collectors.toList()));
                    
                    System.out.println("Kiralamak istediginiz aracin modelini giriniz: ");
                    nesne.setModel(sc.nextLine());

                    if(nesne.getModel().equalsIgnoreCase("Ibiza")){
                        
                        System.out.println("Kiralayabileceginiz (Seat Marka-Ibiza Model-Hatchback-Manuel) Arabalarin Ayrintilari: "+nesne.aracListesi
                            .stream()
                            .map(v -> "\nMarka: "+v.getMarka()+ "\nModel: "+v.getModel()+ "\nModel Yılı: "+v.getModelYili()+ "\nVites Turu: "+v.getVites()+ "\nYakit Turu: "+v.getYakitTuru()+ "\nKilometre Degeri: "+v.getKilometre()+ "\nRenk: "+v.getRenk()+ "\nBeygir Degeri: "+v.getBeygirGucu()+ "\nMotor Hacmi: "+v.getMotorHacmi()+ "\nKiralama Bedeli(Gunluk): "+v.getKiralamaBedeli()+" TL\n")
                            .collect(Collectors.toList()));

                    
                        ArrayList<Float> bedeller = new ArrayList<>(nesne.aracListesi
                            .stream()
                            .map(a -> a.getKiralamaBedeli())
                            .collect(Collectors.toList()));
                        
                        deger = bedeller.get(bedeller.size()-1);

                    } else{
                        System.out.println("Hatali Giris Yaptiniz!");
                        System.out.println("Islem sonlandiriliyor");
                        System.exit(0); 
                    }
                
                } else if(nesne.getMarka().equalsIgnoreCase("Toyota")){
                    
                    nesne.aracListesi.removeIf(a -> !a.getMarka().contains("Toyota"));

                    System.out.println("Kiralayabileceginiz (Toyota Marka-Hatchback-Manuel) Arabalarin Model Listesi: "+nesne.aracListesi
                            .stream()
                            .map(v -> v.getModel())
                            .collect(Collectors.toList()));
                    
                    System.out.println("Kiralamak istediginiz aracin modelini giriniz: ");
                    nesne.setModel(sc.nextLine());

                    if(nesne.getModel().equalsIgnoreCase("Yaris")){
                        
                        System.out.println("Kiralayabileceginiz (Toyota Marka-Yaris Model-Hatchback-Manuel) Arabalarin Ayrintilari: "+nesne.aracListesi
                            .stream()
                            .map(v -> "\nMarka: "+v.getMarka()+ "\nModel: "+v.getModel()+ "\nModel Yılı: "+v.getModelYili()+ "\nVites Turu: "+v.getVites()+ "\nYakit Turu: "+v.getYakitTuru()+ "\nKilometre Degeri: "+v.getKilometre()+ "\nRenk: "+v.getRenk()+ "\nBeygir Degeri: "+v.getBeygirGucu()+ "\nMotor Hacmi: "+v.getMotorHacmi()+ "\nKiralama Bedeli(Gunluk): "+v.getKiralamaBedeli()+" TL\n")
                            .collect(Collectors.toList()));

                    
                        ArrayList<Float> bedeller = new ArrayList<>(nesne.aracListesi
                            .stream()
                            .map(a -> a.getKiralamaBedeli())
                            .collect(Collectors.toList()));
                        
                        deger = bedeller.get(bedeller.size()-1);

                    } else{
                        System.out.println("Hatali Giris Yaptiniz!");
                        System.out.println("Islem sonlandiriliyor");
                        System.exit(0); 
                    }
                
                } else if(nesne.getMarka().equalsIgnoreCase("Volkswagen")){
                    
                    nesne.aracListesi.removeIf(a -> !a.getMarka().contains("Volkswagen"));

                    System.out.println("Kiralayabileceginiz (Volkswagen Marka-Hatchback-Manuel) Arabalarin Model Listesi: "+nesne.aracListesi
                            .stream()
                            .map(v -> v.getModel())
                            .collect(Collectors.toList()));
                    
                    System.out.println("Kiralamak istediginiz aracin modelini giriniz: ");
                    nesne.setModel(sc.nextLine());

                    if(nesne.getModel().equalsIgnoreCase("Polo")){
                        
                        nesne.aracListesi.removeIf(a -> !a.getModel().contains("Polo"));

                        System.out.println("Kiralayabileceginiz (Volkswagen Marka-Polo Model-Hatchback-Manuel) Arabalarin Ayrintilari: "+nesne.aracListesi
                            .stream()
                            .map(v -> "\nMarka: "+v.getMarka()+ "\nModel: "+v.getModel()+ "\nModel Yılı: "+v.getModelYili()+ "\nVites Turu: "+v.getVites()+ "\nYakit Turu: "+v.getYakitTuru()+ "\nKilometre Degeri: "+v.getKilometre()+ "\nRenk: "+v.getRenk()+ "\nBeygir Degeri: "+v.getBeygirGucu()+ "\nMotor Hacmi: "+v.getMotorHacmi()+ "\nKiralama Bedeli(Gunluk): "+v.getKiralamaBedeli()+" TL\n")
                            .collect(Collectors.toList()));

                    
                        ArrayList<Float> bedeller = new ArrayList<>(nesne.aracListesi
                            .stream()
                            .map(a -> a.getKiralamaBedeli())
                            .collect(Collectors.toList()));
                        
                        deger = bedeller.get(bedeller.size()-1);

                    
                    } else if(nesne.getModel().equalsIgnoreCase("Golf")){
                        
                        nesne.aracListesi.removeIf(a -> !a.getModel().contains("Golf"));

                        System.out.println("Kiralayabileceginiz (Volkswagen Marka-Golf Model-Hatchback-Manuel) Arabalarin Ayrintilari: "+nesne.aracListesi
                            .stream()
                            .map(v -> "\nMarka: "+v.getMarka()+ "\nModel: "+v.getModel()+ "\nModel Yılı: "+v.getModelYili()+ "\nVites Turu: "+v.getVites()+ "\nYakit Turu: "+v.getYakitTuru()+ "\nKilometre Degeri: "+v.getKilometre()+ "\nRenk: "+v.getRenk()+ "\nBeygir Degeri: "+v.getBeygirGucu()+ "\nMotor Hacmi: "+v.getMotorHacmi()+ "\nKiralama Bedeli(Gunluk): "+v.getKiralamaBedeli()+" TL\n")
                            .collect(Collectors.toList()));

                    
                        ArrayList<Float> bedeller = new ArrayList<>(nesne.aracListesi
                            .stream()
                            .map(a -> a.getKiralamaBedeli())
                            .collect(Collectors.toList()));
                        
                        deger = bedeller.get(bedeller.size()-1);

                    } else {
                        System.out.println("Hatali Giris Yaptiniz!");
                        System.out.println("Islem sonlandiriliyor");
                        System.exit(0); 
                    }

                }

            } else{
                
                // otomatik ya da manuel seçimi doğru yapılmazsa işlem sonlandırılır

                System.out.println("Hatali Giris Yaptiniz!");
                System.out.println("Islem sonlandiriliyor");
                System.exit(0); 
            }
        
        } else if(nesne.getKasaTipi().equalsIgnoreCase("Sedan")){      //SEDAN SEÇİMİ
            

            // sedan kasa tipi dışındaki araçlar listeden silinir
            nesne.aracListesi.removeIf(a -> !a.getKasaTipi().contains("Sedan"));
            
            System.out.println("");
            
            System.out.println("Kiralamak istediginiz aracin vites turunu giriniz: (Otomatik - Manuel)");
            nesne.setVites(sc.nextLine());

            if (nesne.getVites().equalsIgnoreCase("Otomatik")){             //SEDAN OTOMATİK
                
                // otomatik dışındaki araçlar silinir
                nesne.aracListesi.removeIf(a -> !a.getVites().contains("Otomatik"));

                System.out.println("Kiralayabileceginiz ( Sedan - Otomatik ) Arabalarin Marka Listesi: Fiat-Renault-Ford-Peugeot-Toyota-Volkswagen");
                
                System.out.println("Kiralamak istediginiz aracin markasini giriniz: ");
                nesne.setMarka(sc.nextLine());

                if(nesne.getMarka().equalsIgnoreCase("Fiat")){
                    
                    nesne.aracListesi.removeIf(a -> !a.getMarka().contains("Fiat"));

                    System.out.println("Kiralayabileceginiz (Fiat Marka-Sedan-Otomatik) Arabalarin Model Listesi: "+nesne.aracListesi
                            .stream()
                            .map(v -> v.getModel())
                            .collect(Collectors.toList()));
                    
                    System.out.println("Kiralamak istediginiz aracin modelini giriniz: ");
                    nesne.setModel(sc.nextLine());
                
                    if(nesne.getModel().equalsIgnoreCase("Egea")){
                        
                        System.out.println("Kiralayabileceginiz (Fiat Marka-Egea Model-Sedan-Otomatik) Arabalarin Ayrintilari: "+nesne.aracListesi
                            .stream()
                            .map(v -> "\nMarka: "+v.getMarka()+ "\nModel: "+v.getModel()+ "\nModel Yılı: "+v.getModelYili()+ "\nVites Turu: "+v.getVites()+ "\nYakit Turu: "+v.getYakitTuru()+ "\nKilometre Degeri: "+v.getKilometre()+ "\nRenk: "+v.getRenk()+ "\nBeygir Degeri: "+v.getBeygirGucu()+ "\nMotor Hacmi: "+v.getMotorHacmi()+ "\nKiralama Bedeli(Gunluk): "+v.getKiralamaBedeli()+" TL\n")
                            .collect(Collectors.toList()));

                    
                        ArrayList<Float> bedeller = new ArrayList<>(nesne.aracListesi
                            .stream()
                            .map(a -> a.getKiralamaBedeli())
                            .collect(Collectors.toList()));
                        
                        deger = bedeller.get(bedeller.size()-1); 

                    
                    } else {
                        System.out.println("Hatali Giris Yaptiniz!");
                        System.out.println("Islem sonlandiriliyor");
                        System.exit(0); 
                    }

                } else if(nesne.getMarka().equalsIgnoreCase("Renault")){
                    
                    nesne.aracListesi.removeIf(a -> !a.getMarka().contains("Renault"));

                    System.out.println("Kiralayabileceginiz (Renault Marka-Sedan-Otomatik) Arabalarin Model Listesi: "+nesne.aracListesi
                            .stream()
                            .map(v -> v.getModel())
                            .collect(Collectors.toList()));
                    
                    System.out.println("Kiralamak istediginiz aracin modelini giriniz: ");
                    nesne.setModel(sc.nextLine());
                
                    if(nesne.getModel().equalsIgnoreCase("Megane")){
                        
                        System.out.println("Kiralayabileceginiz (Renault Marka-Megane Model-Sedan-Otomatik) Arabalarin Ayrintilari: "+nesne.aracListesi
                            .stream()
                            .map(v -> "\nMarka: "+v.getMarka()+ "\nModel: "+v.getModel()+ "\nModel Yılı: "+v.getModelYili()+ "\nVites Turu: "+v.getVites()+ "\nYakit Turu: "+v.getYakitTuru()+ "\nKilometre Degeri: "+v.getKilometre()+ "\nRenk: "+v.getRenk()+ "\nBeygir Degeri: "+v.getBeygirGucu()+ "\nMotor Hacmi: "+v.getMotorHacmi()+ "\nKiralama Bedeli(Gunluk): "+v.getKiralamaBedeli()+" TL\n")
                            .collect(Collectors.toList()));

                    
                        ArrayList<Float> bedeller = new ArrayList<>(nesne.aracListesi
                            .stream()
                            .map(a -> a.getKiralamaBedeli())
                            .collect(Collectors.toList()));
                        
                        deger = bedeller.get(bedeller.size()-1); 

                    } else {
                        System.out.println("Hatali Giris Yaptiniz!");
                        System.out.println("Islem sonlandiriliyor");
                        System.exit(0); 
                    }
                
                } else if(nesne.getMarka().equalsIgnoreCase("Ford")){
                    
                    nesne.aracListesi.removeIf(a -> !a.getMarka().contains("Ford"));

                    System.out.println("Kiralayabileceginiz (Ford Marka-Sedan-Otomatik) Arabalarin Model Listesi: "+nesne.aracListesi
                            .stream()
                            .map(v -> v.getModel())
                            .collect(Collectors.toList()));
                    
                    System.out.println("Kiralamak istediginiz aracin modelini giriniz: ");
                    nesne.setModel(sc.nextLine());
                
                    if(nesne.getModel().equalsIgnoreCase("Focus")){
                        
                        System.out.println("Kiralayabileceginiz (Ford Marka-Focus Model-Sedan-Otomatik) Arabalarin Ayrintilari: "+nesne.aracListesi
                            .stream()
                            .map(v -> "\nMarka: "+v.getMarka()+ "\nModel: "+v.getModel()+ "\nModel Yılı: "+v.getModelYili()+ "\nVites Turu: "+v.getVites()+ "\nYakit Turu: "+v.getYakitTuru()+ "\nKilometre Degeri: "+v.getKilometre()+ "\nRenk: "+v.getRenk()+ "\nBeygir Degeri: "+v.getBeygirGucu()+ "\nMotor Hacmi: "+v.getMotorHacmi()+ "\nKiralama Bedeli(Gunluk): "+v.getKiralamaBedeli()+" TL\n")
                            .collect(Collectors.toList()));

                    
                        ArrayList<Float> bedeller = new ArrayList<>(nesne.aracListesi
                            .stream()
                            .map(a -> a.getKiralamaBedeli())
                            .collect(Collectors.toList()));
                        
                        deger = bedeller.get(bedeller.size()-1); 

                    
                    } else {
                        System.out.println("Hatali Giris Yaptiniz!");
                        System.out.println("Islem sonlandiriliyor");
                        System.exit(0); 
                    }
                
                } else if(nesne.getMarka().equalsIgnoreCase("Peugeot")){
                    
                    nesne.aracListesi.removeIf(a -> !a.getMarka().contains("Peugeot"));

                    System.out.println("Kiralayabileceginiz (Peugeot Marka-Sedan-Otomatik) Arabalarin Model Listesi: "+nesne.aracListesi
                            .stream()
                            .map(v -> v.getModel())
                            .collect(Collectors.toList()));
                    
                    System.out.println("Kiralamak istediginiz aracin modelini giriniz: ");
                    nesne.setModel(sc.nextLine());
                
                    if(nesne.getModel().equalsIgnoreCase("301")){
                        
                        System.out.println("Kiralayabileceginiz (Peugeot Marka-301 Model-Sedan-Otomatik) Arabalarin Ayrintilari: "+nesne.aracListesi
                            .stream()
                            .map(v -> "\nMarka: "+v.getMarka()+ "\nModel: "+v.getModel()+ "\nModel Yılı: "+v.getModelYili()+ "\nVites Turu: "+v.getVites()+ "\nYakit Turu: "+v.getYakitTuru()+ "\nKilometre Degeri: "+v.getKilometre()+ "\nRenk: "+v.getRenk()+ "\nBeygir Degeri: "+v.getBeygirGucu()+ "\nMotor Hacmi: "+v.getMotorHacmi()+ "\nKiralama Bedeli(Gunluk): "+v.getKiralamaBedeli()+" TL\n")
                            .collect(Collectors.toList()));

                    
                        ArrayList<Float> bedeller = new ArrayList<>(nesne.aracListesi
                            .stream()
                            .map(a -> a.getKiralamaBedeli())
                            .collect(Collectors.toList()));
                        
                        deger = bedeller.get(bedeller.size()-1); 

                    } else{
                        System.out.println("Hatali Giris Yaptiniz!");
                        System.out.println("Islem sonlandiriliyor");
                        System.exit(0); 
                    }

                } else if(nesne.getMarka().equalsIgnoreCase("Toyota")){
                    
                    nesne.aracListesi.removeIf(a -> !a.getMarka().contains("Toyota"));

                    System.out.println("Kiralayabileceginiz (Toyota Marka-Sedan-Otomatik) Arabalarin Model Listesi: "+nesne.aracListesi
                            .stream()
                            .map(v -> v.getModel())
                            .collect(Collectors.toList()));
                    
                    System.out.println("Kiralamak istediginiz aracin modelini giriniz: ");
                    nesne.setModel(sc.nextLine());
                
                    if(nesne.getModel().equalsIgnoreCase("Corolla")){
                        
                        System.out.println("Kiralayabileceginiz (Toyota Marka-Corolla Model-Sedan-Otomatik) Arabalarin Ayrintilari: "+nesne.aracListesi
                            .stream()
                            .map(v -> "\nMarka: "+v.getMarka()+ "\nModel: "+v.getModel()+ "\nModel Yılı: "+v.getModelYili()+ "\nVites Turu: "+v.getVites()+ "\nYakit Turu: "+v.getYakitTuru()+ "\nKilometre Degeri: "+v.getKilometre()+ "\nRenk: "+v.getRenk()+ "\nBeygir Degeri: "+v.getBeygirGucu()+ "\nMotor Hacmi: "+v.getMotorHacmi()+ "\nKiralama Bedeli(Gunluk): "+v.getKiralamaBedeli()+" TL\n")
                            .collect(Collectors.toList()));

                    
                        ArrayList<Float> bedeller = new ArrayList<>(nesne.aracListesi
                            .stream()
                            .map(a -> a.getKiralamaBedeli())
                            .collect(Collectors.toList()));
                        
                        deger = bedeller.get(bedeller.size()-1); 

                    
                    } else{
                        System.out.println("Hatali Giris Yaptiniz!");
                        System.out.println("Islem sonlandiriliyor");
                        System.exit(0); 
                    }
                
                } else if(nesne.getMarka().equalsIgnoreCase("Volkswagen")){
                    
                    nesne.aracListesi.removeIf(a -> !a.getMarka().contains("Volkswagen"));

                    System.out.println("Kiralayabileceginiz (Volkswagen Marka-Sedan-Otomatik) Arabalarin Model Listesi: "+nesne.aracListesi
                            .stream()
                            .map(v -> v.getModel())
                            .collect(Collectors.toList()));
                    
                    System.out.println("Kiralamak istediginiz aracin modelini giriniz: ");
                    nesne.setModel(sc.nextLine());
                
                    if(nesne.getModel().equalsIgnoreCase("Passat")){
                        
                        System.out.println("Kiralayabileceginiz (Volkswagen Marka-Passat Model-Sedan-Otomatik) Arabalarin Ayrintilari: "+nesne.aracListesi
                            .stream()
                            .map(v -> "\nMarka: "+v.getMarka()+ "\nModel: "+v.getModel()+ "\nModel Yılı: "+v.getModelYili()+ "\nVites Turu: "+v.getVites()+ "\nYakit Turu: "+v.getYakitTuru()+ "\nKilometre Degeri: "+v.getKilometre()+ "\nRenk: "+v.getRenk()+ "\nBeygir Degeri: "+v.getBeygirGucu()+ "\nMotor Hacmi: "+v.getMotorHacmi()+ "\nKiralama Bedeli(Gunluk): "+v.getKiralamaBedeli()+" TL\n")
                            .collect(Collectors.toList()));

                    
                        ArrayList<Float> bedeller = new ArrayList<>(nesne.aracListesi
                            .stream()
                            .map(a -> a.getKiralamaBedeli())
                            .collect(Collectors.toList()));
                        
                        deger = bedeller.get(bedeller.size()-1); 

                    
                    } else{
                        System.out.println("Hatali Giris Yaptiniz!");
                        System.out.println("Islem sonlandiriliyor");
                        System.exit(0); 
                    }

                }     

            } else if(nesne.getVites().equalsIgnoreCase("Manuel")){         // SEDAN MANUEL
                
                // manuel dışındaki araçlar silinir
                nesne.aracListesi.removeIf(a -> !a.getVites().contains("Manuel"));
                
                System.out.println("Kiralayabileceginiz ( Sedan - Manuel ) Arabalarin Marka Listesi: Hyundai-Fiat-Renault-Ford-Peugeot-Toyota");
                
                System.out.println("Kiralamak istediginiz aracin markasini giriniz: ");
                nesne.setMarka(sc.nextLine());

                if(nesne.getMarka().equalsIgnoreCase("Hyundai")){
                    
                    nesne.aracListesi.removeIf(a -> !a.getMarka().contains("Hyundai"));

                    System.out.println("Kiralayabileceginiz (Hyundai Marka-Sedan-Manuel) Arabalarin Model Listesi: "+nesne.aracListesi
                            .stream()
                            .map(v -> v.getModel())
                            .collect(Collectors.toList()));
                    
                    System.out.println("Kiralamak istediginiz aracin modelini giriniz: ");
                    nesne.setModel(sc.nextLine());
                
                    if(nesne.getModel().equalsIgnoreCase("Accent")){
                        
                        System.out.println("Kiralayabileceginiz (Hyundai Marka-Accent Model-Sedan-Manuel) Arabalarin Ayrintilari: "+nesne.aracListesi
                            .stream()
                            .map(v -> "\nMarka: "+v.getMarka()+ "\nModel: "+v.getModel()+ "\nModel Yılı: "+v.getModelYili()+ "\nVites Turu: "+v.getVites()+ "\nYakit Turu: "+v.getYakitTuru()+ "\nKilometre Degeri: "+v.getKilometre()+ "\nRenk: "+v.getRenk()+ "\nBeygir Degeri: "+v.getBeygirGucu()+ "\nMotor Hacmi: "+v.getMotorHacmi()+ "\nKiralama Bedeli(Gunluk): "+v.getKiralamaBedeli()+" TL\n")
                            .collect(Collectors.toList()));

                    
                        ArrayList<Float> bedeller = new ArrayList<>(nesne.aracListesi
                            .stream()
                            .map(a -> a.getKiralamaBedeli())
                            .collect(Collectors.toList()));
                        
                        deger = bedeller.get(bedeller.size()-1); 

                    } else{
                        System.out.println("Hatali Giris Yaptiniz!");
                        System.out.println("Islem sonlandiriliyor");
                        System.exit(0); 
                    }
            
                } else if(nesne.getMarka().equalsIgnoreCase("Fiat")){
                    
                    nesne.aracListesi.removeIf(a -> !a.getMarka().contains("Fiat"));

                    System.out.println("Kiralayabileceginiz (Fiat Marka-Sedan-Manuel) Arabalarin Model Listesi: "+nesne.aracListesi
                            .stream()
                            .map(v -> v.getModel())
                            .collect(Collectors.toList()));
                    
                    System.out.println("Kiralamak istediginiz aracin modelini giriniz: ");
                    nesne.setModel(sc.nextLine());
                
                    if(nesne.getModel().equalsIgnoreCase("Egea")){
                        
                        System.out.println("Kiralayabileceginiz (Fiat Marka-Egea Model-Sedan-Manuel) Arabalarin Ayrintilari: "+nesne.aracListesi
                            .stream()
                            .map(v -> "\nMarka: "+v.getMarka()+ "\nModel: "+v.getModel()+ "\nModel Yılı: "+v.getModelYili()+ "\nVites Turu: "+v.getVites()+ "\nYakit Turu: "+v.getYakitTuru()+ "\nKilometre Degeri: "+v.getKilometre()+ "\nRenk: "+v.getRenk()+ "\nBeygir Degeri: "+v.getBeygirGucu()+ "\nMotor Hacmi: "+v.getMotorHacmi()+ "\nKiralama Bedeli(Gunluk): "+v.getKiralamaBedeli()+" TL\n")
                            .collect(Collectors.toList()));

                    
                        ArrayList<Float> bedeller = new ArrayList<>(nesne.aracListesi
                            .stream()
                            .map(a -> a.getKiralamaBedeli())
                            .collect(Collectors.toList()));
                        
                        deger = bedeller.get(bedeller.size()-1); 

                    } else{
                        System.out.println("Hatali Giris Yaptiniz!");
                        System.out.println("Islem sonlandiriliyor");
                        System.exit(0); 
                    }
                
                } else if(nesne.getMarka().equalsIgnoreCase("Renault")){
                    
                    nesne.aracListesi.removeIf(a -> !a.getMarka().contains("Renault"));

                    System.out.println("Kiralayabileceginiz (Renault Marka-Sedan-Manuel) Arabalarin Model Listesi: "+nesne.aracListesi
                            .stream()
                            .map(v -> v.getModel())
                            .collect(Collectors.toList()));
                    
                    System.out.println("Kiralamak istediginiz aracin modelini giriniz: ");
                    nesne.setModel(sc.nextLine());
                
                    if(nesne.getModel().equalsIgnoreCase("Megane")){
                        
                        System.out.println("Kiralayabileceginiz (Renault Marka-Megane Model-Sedan-Manuel) Arabalarin Ayrintilari: "+nesne.aracListesi
                            .stream()
                            .map(v -> "\nMarka: "+v.getMarka()+ "\nModel: "+v.getModel()+ "\nModel Yılı: "+v.getModelYili()+ "\nVites Turu: "+v.getVites()+ "\nYakit Turu: "+v.getYakitTuru()+ "\nKilometre Degeri: "+v.getKilometre()+ "\nRenk: "+v.getRenk()+ "\nBeygir Degeri: "+v.getBeygirGucu()+ "\nMotor Hacmi: "+v.getMotorHacmi()+ "\nKiralama Bedeli(Gunluk): "+v.getKiralamaBedeli()+" TL\n")
                            .collect(Collectors.toList()));

                    
                        ArrayList<Float> bedeller = new ArrayList<>(nesne.aracListesi
                            .stream()
                            .map(a -> a.getKiralamaBedeli())
                            .collect(Collectors.toList()));
                        
                        deger = bedeller.get(bedeller.size()-1); 

                    } else{
                        System.out.println("Hatali Giris Yaptiniz!");
                        System.out.println("Islem sonlandiriliyor");
                        System.exit(0); 
                    }
            
                } else if(nesne.getMarka().equalsIgnoreCase("Ford")){
                    
                    nesne.aracListesi.removeIf(a -> !a.getMarka().contains("Ford"));

                    System.out.println("Kiralayabileceginiz (Ford Marka-Sedan-Manuel) Arabalarin Model Listesi: "+nesne.aracListesi
                            .stream()
                            .map(v -> v.getModel())
                            .collect(Collectors.toList()));
                    
                    System.out.println("Kiralamak istediginiz aracin modelini giriniz: ");
                    nesne.setModel(sc.nextLine());
                
                    if(nesne.getModel().equalsIgnoreCase("Focus")){
                        
                        System.out.println("Kiralayabileceginiz (Ford Marka-Focus Model-Sedan-Manuel) Arabalarin Ayrintilari: "+nesne.aracListesi
                            .stream()
                            .map(v -> "\nMarka: "+v.getMarka()+ "\nModel: "+v.getModel()+ "\nModel Yılı: "+v.getModelYili()+ "\nVites Turu: "+v.getVites()+ "\nYakit Turu: "+v.getYakitTuru()+ "\nKilometre Degeri: "+v.getKilometre()+ "\nRenk: "+v.getRenk()+ "\nBeygir Degeri: "+v.getBeygirGucu()+ "\nMotor Hacmi: "+v.getMotorHacmi()+ "\nKiralama Bedeli(Gunluk): "+v.getKiralamaBedeli()+" TL\n")
                            .collect(Collectors.toList()));

                    
                        ArrayList<Float> bedeller = new ArrayList<>(nesne.aracListesi
                            .stream()
                            .map(a -> a.getKiralamaBedeli())
                            .collect(Collectors.toList()));
                        
                        deger = bedeller.get(bedeller.size()-1); 

                    
                    } else{
                        System.out.println("Hatali Giris Yaptiniz!");
                        System.out.println("Islem sonlandiriliyor");
                        System.exit(0); 
                    }

                } else if(nesne.getMarka().equalsIgnoreCase("Peugeot")){
                    
                    nesne.aracListesi.removeIf(a -> !a.getMarka().contains("Peugeot"));

                    System.out.println("Kiralayabileceginiz (Peugeot Marka-Sedan-Manuel) Arabalarin Model Listesi: "+nesne.aracListesi
                            .stream()
                            .map(v -> v.getModel())
                            .collect(Collectors.toList()));
                    
                    System.out.println("Kiralamak istediginiz aracin modelini giriniz: ");
                    nesne.setModel(sc.nextLine());
                
                    if(nesne.getModel().equalsIgnoreCase("301")){
                        
                        System.out.println("Kiralayabileceginiz (Peugeot Marka-301 Model-Sedan-Manuel) Arabalarin Ayrintilari: "+nesne.aracListesi
                            .stream()
                            .map(v -> "\nMarka: "+v.getMarka()+ "\nModel: "+v.getModel()+ "\nModel Yılı: "+v.getModelYili()+ "\nVites Turu: "+v.getVites()+ "\nYakit Turu: "+v.getYakitTuru()+ "\nKilometre Degeri: "+v.getKilometre()+ "\nRenk: "+v.getRenk()+ "\nBeygir Degeri: "+v.getBeygirGucu()+ "\nMotor Hacmi: "+v.getMotorHacmi()+ "\nKiralama Bedeli(Gunluk): "+v.getKiralamaBedeli()+" TL\n")
                            .collect(Collectors.toList()));

                    
                        ArrayList<Float> bedeller = new ArrayList<>(nesne.aracListesi
                            .stream()
                            .map(a -> a.getKiralamaBedeli())
                            .collect(Collectors.toList()));
                        
                        deger = bedeller.get(bedeller.size()-1); 

                    } else{
                        System.out.println("Hatali Giris Yaptiniz!");
                        System.out.println("Islem sonlandiriliyor");
                        System.exit(0); 
                    }
                 
                } else if(nesne.getMarka().equalsIgnoreCase("Toyota")){
                    
                    nesne.aracListesi.removeIf(a -> !a.getMarka().contains("Toyota"));

                    System.out.println("Kiralayabileceginiz (Toyota Marka-Sedan-Manuel) Arabalarin Model Listesi: "+nesne.aracListesi
                            .stream()
                            .map(v -> v.getModel())
                            .collect(Collectors.toList()));
                    
                    System.out.println("Kiralamak istediginiz aracin modelini giriniz: ");
                    nesne.setModel(sc.nextLine());
                
                    if(nesne.getModel().equalsIgnoreCase("Corolla")){
                        
                        System.out.println("Kiralayabileceginiz (Toyota Marka-Corolla Model-Sedan-Manuel) Arabalarin Ayrintilari: "+nesne.aracListesi
                            .stream()
                            .map(v -> "\nMarka: "+v.getMarka()+ "\nModel: "+v.getModel()+ "\nModel Yılı: "+v.getModelYili()+ "\nVites Turu: "+v.getVites()+ "\nYakit Turu: "+v.getYakitTuru()+ "\nKilometre Degeri: "+v.getKilometre()+ "\nRenk: "+v.getRenk()+ "\nBeygir Degeri: "+v.getBeygirGucu()+ "\nMotor Hacmi: "+v.getMotorHacmi()+ "\nKiralama Bedeli(Gunluk): "+v.getKiralamaBedeli()+" TL\n")
                            .collect(Collectors.toList()));

                    
                        ArrayList<Float> bedeller = new ArrayList<>(nesne.aracListesi
                            .stream()
                            .map(a -> a.getKiralamaBedeli())
                            .collect(Collectors.toList()));
                        
                        deger = bedeller.get(bedeller.size()-1); 

                    
                    } else{

                        // model seçimi yapılırken uygun giriş yapılmadıysa program sonlanır
                        System.out.println("Hatali Giris Yaptiniz!");
                        System.out.println("Islem sonlandiriliyor");
                        System.exit(0); 
                    }
                 
                } else {

                    // marka seçimi yapılırken uygun giriş yapılmadıysa program sonlanır
                    System.out.println("Hatali Giris Yaptiniz!");
                    System.out.println("Islem sonlandiriliyor");
                    System.exit(0);
                }
                    
            } else {

                // otomatik manuel vites seçimi yapılırken uygun giriş yapılmadıysa program sonlanır
                System.out.println("Hatali Giris Yaptiniz!");
                System.out.println("Islem sonlandiriliyor");
                System.exit(0);
            }
        
        } else {

            // kasa tipi seçimi yapılırken uygun giriş yapılmadıysa program sonlanır
            System.out.println("Hatali Giris Yaptiniz!");
            System.out.println("Islem sonlandiriliyor");
            System.exit(0); 
        }

    }

    public float gonderFiyat(){
         return deger;            // filteleme işlemi sonundaki aracın fiyatı alındıktan sonra deger değişkenine atanır
                                  // bu değişken içindeki değer fonksiyon yardımıyla discounta göderilir
                                  // bu sayede indirim işlemleri yapılır 
    }

}
