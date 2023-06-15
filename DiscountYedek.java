
import java.lang.System;        // gerekli import işlemleri yapılır
import java.util.Scanner;

// günlük, aylık ve yıllık kiralamada uygulanacak indirimler 
// odeme indirimleri 

public class DiscountYedek { // superclass

    // gerekli değişken tanımlamaları yapılır
    
    public double indirimliFiyatSon;

	BilgileriGetir b1 = new BilgileriGetir();       // ilgili sınıftan fonksiyon çalıştırmak için nesne oluşturulur

     
    public DiscountYedek (double sure,int indirimYuzdesi,double fiyat) {
    	 
    }
     
    public DiscountYedek() {
    	 
    }
     
     
    Scanner sc = new Scanner(System.in);
     
    public void indirim() {             // Bu metot'da kiralama planları(aylık-günlük-yıllık) seçiliyor,kategorilere özel ek indirimler 
                                        // uygulanarak fiyat hesaplanıyor
    	double indirimliFiyat=0;
    	double fiyat;
    	int secim;
    	int odeme;
    	double kazanc;


//		arabalar arraylist'e ekleniyor		
		ArabaListesi a1 = new ArabaListesi();
		a1.araclarListesi();
        
//		filtreleme islemi icin fonksiyon calisiyor
		BilgileriGetir b1 = new BilgileriGetir();
		b1.aracBilgiSorgu();

//		gonder fiyat fonk.'dan secilen aracin fiyati donuyor
		fiyat = b1.gonderFiyat();   // fiyat değişkeni alt taraftaki kod bloklarında ayrı ayrı giriş yapılan 
                                    // süre değerleriyle çarpılır - hesaplamalar yapılır

        System.out.println("Kullanmak istediginiz plani seciniz:  1- Gunluk    2- Aylik    3- Yillik");
        int plan = sc.nextInt();    // kullanıcıdan plan alınır


        if(plan == 1){  // GUNLUK PLAN SECILDIYSE
            
            System.out.println("Araç kiralamak istediğiniz toplam süreyi gün bazında giriniz:");
    	    double sure=sc.nextDouble();
    	 
			
    	    if(sure >= 1 && sure < 6) {     // sure 1 gün ile 6 gün arasında ise bu bloktaki veriler çalışacaktır
    		    
                indirimliFiyat=(fiyat*sure);        // hesaplamalardan sonra yeni değer indirimliFiyat'a aktarılır
    		    System.out.println("Ek bir indirim uygulanmayacaktır!");
    		    System.out.println("<<<<----->>>>");
    		    System.out.println("Toplam tutar = " +indirimliFiyat+" TL");        // yeni değer ekrana yazdırılır
                System.out.println("");
    		    System.out.println("Yapmak istediğiniz ödeme seçeneğini giriniz: \n");
    		    System.out.println("1-HEMEN ÖDE *(Online öde,avantajlı fiyatla yola çık.)\n2-YERİNDE ÖDE *(Aracı teslim alırken ödeyene kadar istediğin değişiklikleri yap)");
    		    secim=sc.nextInt();
    		 
    		    if(secim==1) {      // kullanıcı 1 numaralı ödeme tipini seçtiğinde bu blok işleyecektir
    			    
					odeme=5;    // hemen öde seçildiğinde yüzde 5 indirim olacaktır

    			    indirimliFiyatSon = (indirimliFiyat)-(indirimliFiyat*odeme)/100;
    			    System.out.println("Ödeyeceğiniz tutar : "+indirimliFiyatSon+" TL");   // hemen öde seçeneğiyle oluşan tutardan sonraki
                                                                                            // değer ekrana yazdırılır
    			    System.out.println("<-------->");
    			    kazanc=(indirimliFiyat*odeme)/100;      // ayrıca yüzde 5' lik değerin karşılığı ekrana yazdırılır

                    // kullanıcıya, bu ödeme seçeneğinden elde ettiği kar bildirilecektir
    			    System.out.println("Online ödeme kazancınız = " +kazanc+" TL");
    			 	 
    		    }
    		    else if (secim == 2){       // kullanıcı 2 numaralı ödeme tipini seçtiğinde bu blok işleyecektir
    			    
                    System.out.println("Ek bir indirim uygulanmayacaktır!");
    			    System.out.println(" Toplam tutar = " +indirimliFiyat+" TL");
    			    indirimliFiyatSon = indirimliFiyat;

    		    } else {

                    while (secim != 1 && secim != 2){
                                
                        // kullanıcı kriterlere uymayan bir tercih yaptığında geribildirim almakta
                        System.out.println("Hatali giris yaptiniz!. Tekrar deneyin!");
                        System.out.println("");

                        // kullanıcıya verilen geribildirimin ardından ,uygun girişte bulunana kadar kullanıcıdan veri istenmekte
                        System.out.println("Yapmak istediğiniz ödeme seçeneğini giriniz: \n");
                        System.out.println("1-HEMEN ÖDE *(Online öde,avantajlı fiyatla yola çık.)\n2-YERİNDE ÖDE *(Aracı teslim alırken ödeyene kadar istediğin değişiklikleri yap)");
                        secim=sc.nextInt();
                        
                        if(secim==1) {      // kullanıcı 1 numaralı ödeme tipini seçtiğinde bu blok işleyecektir
                    
                            odeme=5;
                            indirimliFiyatSon = (indirimliFiyat)-(indirimliFiyat*odeme)/100;
                            System.out.println("Ödeyeceğiniz tutar : "+indirimliFiyatSon+" TL");
                            System.out.println("<-------->");
                            kazanc=(indirimliFiyat*odeme)/100;

                            // kullanıcıya, bu ödeme seçeneğinden elde ettiği kar bildirilecektir
                            System.out.println("Online ödeme kazancınız = " +kazanc+" TL");
                              
                        }
                        else if (secim == 2){       // kullanıcı 2 numaralı ödeme tipini seçtiğinde bu blok işleyecektir
                            
                            System.out.println("Ek bir indirim uygulanmayacaktır!");
                            System.out.println(" Toplam tutar = " +indirimliFiyat+" TL");
                            indirimliFiyatSon = indirimliFiyat;
    
                        }
                    }
                }
    	    
            }
    	 
    	    else if (sure>=6&&sure<15) {    // sure 6 gün ile 15 gün arasında ise bu bloktaki veriler çalışacaktır
    		    
                int indirimYuzdesi=10;      // bu zaman aralığı için belirlenen indirim oranı

    		    indirimliFiyat=((fiyat*sure)-(fiyat*sure*indirimYuzdesi)/100);
    		    indirimliFiyatSon = indirimliFiyat;
    		    System.out.println("Toplam tutar = " +indirimliFiyat+" TL");
    		    System.out.println("");
    		    System.out.println("Yapmak istediğiniz ödeme seçeneğini giriniz: \n");
    		    System.out.println("1-HEMEN ÖDE *(Online öde,avantajlı fiyatla yola çık.)\n2-YERİNDE ÖDE *(Aracı teslim alırken ödeyene kadar istediğin değişiklikleri yap)");
    		    secim=sc.nextInt();
    		        
                if(secim==1) {      // kullanıcı 1 numaralı ödeme tipini seçtiğinde bu blok işleyecektir
    			    
                    odeme=5;
    			    indirimliFiyatSon = (indirimliFiyat)-(indirimliFiyat*odeme)/100;
    			    System.out.println("Ödeyeceğiniz tutar = "+indirimliFiyatSon+" TL");
    			    System.out.println("<-------->");
    			    kazanc=(indirimliFiyat*odeme)/100;

                    // kullanıcıya, bu ödeme seçeneğinden elde ettiği kar bildirilecektir
    			    System.out.println("Online ödeme kazancınız = " +kazanc+" TL");
    			  
    		    }
    		    else if(secim == 2){        // kullanıcı 2 numaralı ödeme tipini seçtiğinde bu blok işleyecektir
    			
                    System.out.println("Ek bir indirim uygulanmayacaktır!");
    			    System.out.println("Toplam tutar = " +indirimliFiyat+" TL");
    			    indirimliFiyatSon = indirimliFiyat;
    		    
                } else {

                    while (secim != 1 && secim != 2){   // kullanıcı kriterlere uymayan bir tercih yaptığında geribildirim almakta
                                
                        System.out.println("Hatali giris yaptiniz!. Tekrar deneyin!");
                        System.out.println("");

                        // kullanıcıya verilen geribildirimin ardından ,uygun girişte bulunana kadar kullanıcıdan veri istenmekte
                        System.out.println("Yapmak istediğiniz ödeme seçeneğini giriniz: \n");
                        System.out.println("1-HEMEN ÖDE *(Online öde,avantajlı fiyatla yola çık.)\n2-YERİNDE ÖDE *(Aracı teslim alırken ödeyene kadar istediğin değişiklikleri yap)");
                        secim=sc.nextInt();
                        
                        if(secim==1) {  // kullanıcı 1 numaralı ödeme tipini seçtiğinde bu blok işleyecektir
                    
                            odeme=5;
                            indirimliFiyatSon = (indirimliFiyat)-(indirimliFiyat*odeme)/100;
                            System.out.println("Ödeyeceğiniz tutar : "+indirimliFiyatSon+" TL");
                            System.out.println("<-------->");
                            kazanc=(indirimliFiyat*odeme)/100;

                            // kullanıcıya, bu ödeme seçeneğinden elde ettiği kar bildirilecektir
                            System.out.println("Online ödeme kazancınız = " +kazanc+" TL");
                              
                        }
                        else if (secim == 2){

                            // kullanıcı 2 numaralı ödeme tipini seçtiğinde bu blok işleyecektir
                            
                            System.out.println("Ek bir indirim uygulanmayacaktır!");
                            System.out.println(" Toplam tutar = " +indirimliFiyat+" TL");
                            indirimliFiyatSon = indirimliFiyat;
    
                        }
                    }
                }
    		 
    	    }
            else if(sure>=15&&sure<30)      // sure 15 gün ile 30 gün arasında ise bu bloktaki veriler çalışacaktır
            {           
    		 	int indirimYuzdesi=15;      // bu zaman aralığı için belirlenen indirim oranı

    		    indirimliFiyat=((fiyat*sure)-(fiyat*sure*indirimYuzdesi)/100);
    		    System.out.println("Toplam tutar = "+indirimliFiyat+" TL");
    		    System.out.println("<-------->");
    		    System.out.println("Yapmak istediğiniz ödeme seçeneğini giriniz: \n");
    		    System.out.println("1-HEMEN ÖDE *(Online öde,avantajlı fiyatla yola çık.)\n2-YERİNDE ÖDE *(Aracı teslim alırken ödeyene kadar istediğin değişiklikleri yap)");
    		    secim=sc.nextInt();
    		    
                if(secim==1) {      // kullanıcı 1 numaralı ödeme tipini seçtiğinde bu blok işleyecektir
    			    
					odeme=5;
    			    indirimliFiyatSon = (indirimliFiyat)-(indirimliFiyat*odeme)/100;
    			    System.out.println("Ödeyeceğiniz tutar = "+indirimliFiyatSon+" TL");
    			    System.out.println("<-------->");
    			    kazanc=(indirimliFiyat*odeme)/100;

                    // kullanıcıya, bu ödeme seçeneğinden elde ettiği kar bildirilecektir
    			    System.out.println("Online ödeme kazancınız = " +kazanc+" TL");
    			 
    		    }
    		    else if(secim ==2){     // kullanıcı 2 numaralı ödeme tipini seçtiğinde bu blok işleyecektir
    			    
					System.out.println("Ek bir indirim uygulanmayacaktır!");
                    System.out.println("");
    			    System.out.println("Toplam tutar = " +indirimliFiyat+" TL");
    			    indirimliFiyatSon = indirimliFiyat;

    		    } else {
                   
					while (secim != 1 && secim != 2){   // kullanıcı kriterlere uymayan bir tercih yaptığında geribildirim almakta
                                
                                System.out.println("Hatali giris yaptiniz!. Tekrar deneyin!");
                                System.out.println("");
                                System.out.println("Yapmak istediğiniz ödeme seçeneğini giriniz: \n");
                                System.out.println("1-HEMEN ÖDE *(Online öde,avantajlı fiyatla yola çık.)\n2-YERİNDE ÖDE *(Aracı teslim alırken ödeyene kadar istediğin değişiklikleri yap)");
                                secim=sc.nextInt();
                                
                                if(secim==1) {
                            
                                    odeme=5;
                                    indirimliFiyatSon = (indirimliFiyat)-(indirimliFiyat*odeme)/100;
                                    System.out.println("Ödeyeceğiniz tutar : "+indirimliFiyatSon+" TL");
                                    System.out.println("<-------->");
                                    kazanc=(indirimliFiyat*odeme)/100;
                                    System.out.println("Online ödeme kazancınız = " +kazanc+" TL");
                                      
                                }
                                else if (secim == 2){
                                    
                                    System.out.println("Ek bir indirim uygulanmayacaktır!");
                                    System.out.println(" Toplam tutar = " +indirimliFiyat+" TL");
                                    indirimliFiyatSon = indirimliFiyat;
            
                                }
                            }
                
				}
    		 
    		 
    	    } else if (sure >= 30){
				
                while(sure>=30) {   // seçilen plana uygun olmayan bir süre girildiğinde kullanıcıya geribildirim verilecektir
					 
                    System.out.println("Girdiğiniz süre günlük plana uygun değildir! Tercihinize uygun olan kiralama planına yönlendiriliyosunuz...");
                      System.out.println("*******\n\n");

                      // kullanıcıya , girdiği sürenin uyumlu olduğu plan önerilecektir
                      System.out.println("Lutfen aylik plan seciniz!!");
                      System.out.println("Araç kiralamak istediğiniz toplam süreyi ay bazında giriniz:");
                      sure=sc.nextDouble();


                    if(sure == 1) {     //sure 1 ise bu bloktaki veriler işleyecektir
                        
                        int indirimYuzdesi=15;      // bu zaman aralığı için belirlenen indirim oranı

                        indirimliFiyat=((fiyat*sure*30)-(fiyat*sure*30*indirimYuzdesi)/100);
                        indirimliFiyatSon = indirimliFiyat;
                        System.out.println("Toplam tutar = " +indirimliFiyat+" TL");
                        System.out.println("");
                        System.out.println("Yapmak istediğiniz ödeme seçeneğini giriniz: \n");
                        System.out.println("1-HEMEN ÖDE *(Online öde,avantajlı fiyatla yola çık.)\n2-YERİNDE ÖDE *(Aracı teslim alırken ödeyene kadar istediğin değişiklikleri yap)");
                        secim=sc.nextInt();

                        if(secim == 1) {        // kullanıcı 1 numaralı ödeme tipini seçtiğinde bu blok işleyecektir
                            odeme=5;
                            indirimliFiyatSon = (indirimliFiyat)-(indirimliFiyat*odeme)/100;
                            System.out.println("Ödeyeceğiniz tutar = "+indirimliFiyatSon+" TL");
                            System.out.println("<-------->");
                            kazanc=(indirimliFiyat*odeme)/100;

                            // kullanıcıya, bu ödeme seçeneğinden elde ettiği kar bildirilecektir
                            System.out.println("Online ödeme kazancınız = " +kazanc+" TL");
                        
                        } else if (secim == 2){     // kullanıcı 2 numaralı ödeme tipini seçtiğinde bu blok işleyecektir
                            System.out.println("Ek bir indirim uygulanmayacaktır!");
                            System.out.println(" Toplam tutar = " +indirimliFiyat+" TL");
                            indirimliFiyatSon = indirimliFiyat;
                        
                        } else {
                            
                            while (secim != 1 && secim != 2){

                                // kriterlere uygun bir seçim yapılmadığında kullanıcıya geri bildirim verilecektir
                                System.out.println("Hatali giris yaptiniz!. Tekrar deneyin!");
                                System.out.println("");

                                // kullanıcıya verilen geribildirimin ardından ,uygun girişte bulunana kadar kullanıcıdan veri istenmekte
                                System.out.println("Yapmak istediğiniz ödeme seçeneğini giriniz: \n");
                                System.out.println("1-HEMEN ÖDE *(Online öde,avantajlı fiyatla yola çık.)\n2-YERİNDE ÖDE *(Aracı teslim alırken ödeyene kadar istediğin değişiklikleri yap)");
                                secim=sc.nextInt();
                                
                                if(secim==1) {
                            
                                    odeme=5;
                                    indirimliFiyatSon = (indirimliFiyat)-(indirimliFiyat*odeme)/100;
                                    System.out.println("Ödeyeceğiniz tutar : "+indirimliFiyatSon+" TL");
                                    System.out.println("<-------->");
                                    kazanc=(indirimliFiyat*odeme)/100;
                                    System.out.println("Online ödeme kazancınız = " +kazanc+" TL");
                                      
                                }
                                else if (secim == 2){
                                    
                                    System.out.println("Ek bir indirim uygulanmayacaktır!");
                                    System.out.println(" Toplam tutar = " +indirimliFiyat+" TL");
                                    indirimliFiyatSon = indirimliFiyat;
            
                                }
                            }					
                        }
                    
                    } else if(sure == 2 || sure == 3){      // sure 2 veya 3 ay  ise bu bloktaki veriler çalışacaktır
                        
                        int indirimYuzdesi=20;
                        indirimliFiyat=((fiyat*sure*30)-(fiyat*sure*30*indirimYuzdesi)/100);
                        indirimliFiyatSon = indirimliFiyat;
                        System.out.println("Toplam tutar = " +indirimliFiyat+" TL");
                        System.out.println("");
                        System.out.println("Yapmak istediğiniz ödeme seçeneğini giriniz: \n");
                        System.out.println("1-HEMEN ÖDE *(Online öde,avantajlı fiyatla yola çık.)\n2-YERİNDE ÖDE *(Aracı teslim alırken ödeyene kadar istediğin değişiklikleri yap)");
                        secim=sc.nextInt();

                        if(secim == 1){ 
                            
                            odeme=5;
                            indirimliFiyatSon = (indirimliFiyat)-(indirimliFiyat*odeme)/100;
                            System.out.println("Ödeyeceğiniz tutar = "+indirimliFiyatSon+" TL");
                            System.out.println("<-------->");
                            kazanc=(indirimliFiyat*odeme)/100;
                            System.out.println("Online ödeme kazancınız = " +kazanc+" TL");
                        
                        } else if (secim == 2){
                            System.out.println("Ek bir indirim uygulanmayacaktır!");
                            System.out.println(" Toplam tutar = " +indirimliFiyat+" TL");
                            indirimliFiyatSon = indirimliFiyat;
                        
                        } else {
                            
                            while (secim != 1 && secim != 2){
                                
                                System.out.println("Hatali giris yaptiniz!. Tekrar deneyin!");
                                System.out.println("");
                                System.out.println("Yapmak istediğiniz ödeme seçeneğini giriniz: \n");
                                System.out.println("1-HEMEN ÖDE *(Online öde,avantajlı fiyatla yola çık.)\n2-YERİNDE ÖDE *(Aracı teslim alırken ödeyene kadar istediğin değişiklikleri yap)");
                                secim=sc.nextInt();
                                if(secim==1) {
                            
                                    odeme=5;
                                    indirimliFiyatSon = (indirimliFiyat)-(indirimliFiyat*odeme)/100;
                                    System.out.println("Ödeyeceğiniz tutar : "+indirimliFiyatSon+" TL");
                                    System.out.println("<-------->");
                                    kazanc=(indirimliFiyat*odeme)/100;
                                    System.out.println("Online ödeme kazancınız = " +kazanc+" TL");
                                      
                                }
                                else if (secim == 2){
                                    
                                    System.out.println("Ek bir indirim uygulanmayacaktır!");
                                    System.out.println(" Toplam tutar = " +indirimliFiyat+" TL");
                                    indirimliFiyatSon = indirimliFiyat;
            
                                }
                            }					
                        }
                        
                    } else if(sure > 3 && sure <= 11){      // sure 3 ile 11 ay arasında girildiğinde bu bloktaki veriler işleyecektir
                        
                        int indirimYuzdesi=30;
                        indirimliFiyat=((fiyat*sure*30)-(fiyat*sure*30*indirimYuzdesi)/100);
                        indirimliFiyatSon = indirimliFiyat;
                        System.out.println("Toplam tutar = " +indirimliFiyat+" TL");
                        System.out.println("");
                        System.out.println("Yapmak istediğiniz ödeme seçeneğini giriniz: \n");
                        System.out.println("1-HEMEN ÖDE *(Online öde,avantajlı fiyatla yola çık.)\n2-YERİNDE ÖDE *(Aracı teslim alırken ödeyene kadar istediğin değişiklikleri yap)");
                        secim=sc.nextInt();

                        if(secim == 1){ 
                            
                            odeme=5;
                            indirimliFiyatSon = (indirimliFiyat)-(indirimliFiyat*odeme)/100;
                            System.out.println("Ödeyeceğiniz tutar = "+indirimliFiyatSon+" TL");
                            System.out.println("<-------->");
                            kazanc=(indirimliFiyat*odeme)/100;
                            System.out.println("Online ödeme kazancınız = " +kazanc+" TL");
                        
                        } else if (secim == 2){
                            System.out.println("Ek bir indirim uygulanmayacaktır!");
                            System.out.println(" Toplam tutar = " +indirimliFiyat+" TL");
                            indirimliFiyatSon = indirimliFiyat;
                        
                        } else {
                            
                            while (secim != 1 && secim != 2){
                                
                                System.out.println("Hatali giris yaptiniz!. Tekrar deneyin!");
                                System.out.println("");
                                System.out.println("Yapmak istediğiniz ödeme seçeneğini giriniz: \n");
                                System.out.println("1-HEMEN ÖDE *(Online öde,avantajlı fiyatla yola çık.)\n2-YERİNDE ÖDE *(Aracı teslim alırken ödeyene kadar istediğin değişiklikleri yap)");
                                secim=sc.nextInt();
                                
                                if(secim==1) {
                            
                                    odeme=5;
                                    indirimliFiyatSon = (indirimliFiyat)-(indirimliFiyat*odeme)/100;
                                    System.out.println("Ödeyeceğiniz tutar : "+indirimliFiyatSon+" TL");
                                    System.out.println("<-------->");
                                    kazanc=(indirimliFiyat*odeme)/100;
                                    System.out.println("Online ödeme kazancınız = " +kazanc+" TL");
                                      
                                }
                                else if (secim == 2){
                                    
                                    System.out.println("Ek bir indirim uygulanmayacaktır!");
                                    System.out.println(" Toplam tutar = " +indirimliFiyat+" TL");
                                    indirimliFiyatSon = indirimliFiyat;
            
                                }
                            }
                        }

                    } else {        // seçilen plana uygun olmayan bir süre girildiğinde kullanıcıya geribildirim verilecektir
                        
                        System.out.println("Hatali giris yaptiniz. Lutfen tekrar deneyin!");
                        System.out.println("Islem sonlandiriliyor!");
                        // hatalı giriş sonrası işlem sonlandırılacaktır
                        System.exit(0);
                    }
                }
			
			} else { //0 veya eksi bir sayı girişinde hata mesajı yazdırılacaktır

				System.out.println("Girdiginiz gun sayisi ile sectiginiz plan kullanilamaz!!");
                System.out.println("Islem sonlandiriliyor!");
                // hatalı giriş sonrası işlem sonlandırılacaktır
                System.exit(0);

			}

         
        } else if (plan == 2) { // AYLIK PLAN SECILDIYSE

            System.out.println("Araç kiralamak istediğiniz toplam süreyi ay bazında giriniz:");
    	    double sure=sc.nextDouble();


			if(sure == 1) {     // sure 1 ay olarak girildiğinde bu bloktaki veriler işleyecektir
    		    
				int indirimYuzdesi=15;  // bu zaman aralığı için belirlenen indirim oranı
				
                indirimliFiyat=((fiyat*sure*30)-(fiyat*sure*30*indirimYuzdesi)/100);
				indirimliFiyatSon = indirimliFiyat;
    		    System.out.println("Toplam tutar = " +indirimliFiyat+" TL");
                System.out.println("");
    		    System.out.println("Yapmak istediğiniz ödeme seçeneğini giriniz: \n");
    		    System.out.println("1-HEMEN ÖDE *(Online öde,avantajlı fiyatla yola çık.)\n2-YERİNDE ÖDE *(Aracı teslim alırken ödeyene kadar istediğin değişiklikleri yap)");
    		    secim=sc.nextInt();

				if(secim == 1) {
					odeme=5;
    			    indirimliFiyatSon = (indirimliFiyat)-(indirimliFiyat*odeme)/100;
    			    System.out.println("Ödeyeceğiniz tutar = "+indirimliFiyatSon+" TL");
    			    System.out.println("<-------->");
    			    kazanc=(indirimliFiyat*odeme)/100;

                    // kullanıcıya, bu ödeme seçeneğinden elde ettiği kar bildirilecektir
    			    System.out.println("Online ödeme kazancınız = " +kazanc+" TL");
				
				} else if (secim == 2) {
					System.out.println("Ek bir indirim uygulanmayacaktır!");
    			 	System.out.println(" Toplam tutar = " +indirimliFiyat+" TL");
    			 	indirimliFiyatSon = indirimliFiyat;
				
				} else {
					
                    while (secim != 1 && secim != 2){
                                
                        System.out.println("Hatali giris yaptiniz!. Tekrar deneyin!");
                        System.out.println("");
                        System.out.println("Yapmak istediğiniz ödeme seçeneğini giriniz: \n");
                        System.out.println("1-HEMEN ÖDE *(Online öde,avantajlı fiyatla yola çık.)\n2-YERİNDE ÖDE *(Aracı teslim alırken ödeyene kadar istediğin değişiklikleri yap)");
                        secim=sc.nextInt();
                        
                        if(secim==1) {
                    
                            odeme=5;
                            indirimliFiyatSon = (indirimliFiyat)-(indirimliFiyat*odeme)/100;
                            System.out.println("Ödeyeceğiniz tutar : "+indirimliFiyatSon+" TL");
                            System.out.println("<-------->");
                            kazanc=(indirimliFiyat*odeme)/100;
                            System.out.println("Online ödeme kazancınız = " +kazanc+" TL");
                              
                        }
                        else if (secim == 2){
                            
                            System.out.println("Ek bir indirim uygulanmayacaktır!");
                            System.out.println(" Toplam tutar = " +indirimliFiyat+" TL");
                            indirimliFiyatSon = indirimliFiyat;
    
                        }
                    }				
				}
			
			} else if(sure == 2 || sure == 3){      // sure 2 veya 3 ay girildiğinde bu bloktaki veriler işleyecektir
				
				int indirimYuzdesi=20;      // bu zaman aralığı için belirlenen indirim oranı

				indirimliFiyat=((fiyat*sure*30)-(fiyat*sure*30*indirimYuzdesi)/100);
                indirimliFiyatSon = indirimliFiyat;
    		 	System.out.println("Toplam tutar = " +indirimliFiyat+" TL");
				System.out.println("");
				System.out.println("Yapmak istediğiniz ödeme seçeneğini giriniz: \n");
				System.out.println("1-HEMEN ÖDE *(Online öde,avantajlı fiyatla yola çık.)\n2-YERİNDE ÖDE *(Aracı teslim alırken ödeyene kadar istediğin değişiklikleri yap)");
				secim=sc.nextInt();

				if(secim == 1){ 
					
					odeme=5;
    			    indirimliFiyatSon = (indirimliFiyat)-(indirimliFiyat*odeme)/100;
    			    System.out.println("Ödeyeceğiniz tutar = "+indirimliFiyatSon+" TL");
    			    System.out.println("<-------->");
    			    kazanc=(indirimliFiyat*odeme)/100;
    			    System.out.println("Online ödeme kazancınız = " +kazanc+" TL");
				
				} else if (secim == 2){
					System.out.println("Ek bir indirim uygulanmayacaktır!");
    			 	System.out.println(" Toplam tutar = " +indirimliFiyat+" TL");
    			 	indirimliFiyatSon = indirimliFiyat;
				
				} else {

					while (secim != 1 && secim != 2){
                                
                        System.out.println("Hatali giris yaptiniz!. Tekrar deneyin!");
                        System.out.println("");
                        System.out.println("Yapmak istediğiniz ödeme seçeneğini giriniz: \n");
                        System.out.println("1-HEMEN ÖDE *(Online öde,avantajlı fiyatla yola çık.)\n2-YERİNDE ÖDE *(Aracı teslim alırken ödeyene kadar istediğin değişiklikleri yap)");
                        secim=sc.nextInt();
                        
                        if(secim==1) {
                    
                            odeme=5;
                            indirimliFiyatSon = (indirimliFiyat)-(indirimliFiyat*odeme)/100;
                            System.out.println("Ödeyeceğiniz tutar : "+indirimliFiyatSon+" TL");
                            System.out.println("<-------->");
                            kazanc=(indirimliFiyat*odeme)/100;
                            System.out.println("Online ödeme kazancınız = " +kazanc+" TL");
                              
                        }
                        else if (secim == 2){
                            
                            System.out.println("Ek bir indirim uygulanmayacaktır!");
                            System.out.println(" Toplam tutar = " +indirimliFiyat+" TL");
                            indirimliFiyatSon = indirimliFiyat;
    
                        }
                    }					
				}
				
			} else if(sure > 3 && sure <= 11){   // sure 3 ile 11 ay arasında girildiğinde bu bloktaki veriler işleyecektir
				
				int indirimYuzdesi=30;  // bu zaman aralığı için belirlenen indirim oranı

				indirimliFiyat=((fiyat*sure*30)-(fiyat*sure*30*indirimYuzdesi)/100);
                indirimliFiyatSon = indirimliFiyat;
    		 	System.out.println("Toplam tutar = " +indirimliFiyat+" TL");
				System.out.println("");
				System.out.println("Yapmak istediğiniz ödeme seçeneğini giriniz: \n");
				System.out.println("1-HEMEN ÖDE *(Online öde,avantajlı fiyatla yola çık.)\n2-YERİNDE ÖDE *(Aracı teslim alırken ödeyene kadar istediğin değişiklikleri yap)");
				secim=sc.nextInt();

				if(secim == 1){ 
					
					odeme=5;
    			    indirimliFiyatSon = (indirimliFiyat)-(indirimliFiyat*odeme)/100;
    			    System.out.println("Ödeyeceğiniz tutar = "+indirimliFiyatSon+" TL");
    			    System.out.println("<-------->");
    			    kazanc=(indirimliFiyat*odeme)/100;
    			    System.out.println("Online ödeme kazancınız = " +kazanc+" TL");
				
				} else if (secim == 2){
					System.out.println("Ek bir indirim uygulanmayacaktır!");
    			 	System.out.println(" Toplam tutar = " +indirimliFiyat+" TL");
    			 	indirimliFiyatSon = indirimliFiyat;
				
				} else {
					
                    while (secim != 1 && secim != 2){
                                
                                System.out.println("Hatali giris yaptiniz!. Tekrar deneyin!");
                                System.out.println("");
                                System.out.println("Yapmak istediğiniz ödeme seçeneğini giriniz: \n");
                                System.out.println("1-HEMEN ÖDE *(Online öde,avantajlı fiyatla yola çık.)\n2-YERİNDE ÖDE *(Aracı teslim alırken ödeyene kadar istediğin değişiklikleri yap)");
                                secim=sc.nextInt();
                                
                                if(secim==1) {
                            
                                    odeme=5;
                                    indirimliFiyatSon = (indirimliFiyat)-(indirimliFiyat*odeme)/100;
                                    System.out.println("Ödeyeceğiniz tutar : "+indirimliFiyatSon+" TL");
                                    System.out.println("<-------->");
                                    kazanc=(indirimliFiyat*odeme)/100;
                                    System.out.println("Online ödeme kazancınız = " +kazanc+" TL");
                                      
                                }
                                else if (secim == 2){
                                    
                                    System.out.println("Ek bir indirim uygulanmayacaktır!");
                                    System.out.println(" Toplam tutar = " +indirimliFiyat+" TL");
                                    indirimliFiyatSon = indirimliFiyat;
            
                                }
                            }				
				}

			} else if (sure >= 12){      // sure 12 ay ve üzeri girildiğinde bu bloktaki veriler işleyecektir
				
				System.out.println("Hatali Giris yaptiniz.(Girdiginiz deger 11'den buyuk olamaz!)");

                // yıllık plana yönlendirme yapılacaktır
                System.out.println("Araç kiralamak istediğiniz toplam süreyi yil bazında giriniz: ");
                sure=sc.nextDouble();
    
                if(sure == 1) {     //  sure 1 yıl olduğunda bu bloktaki veriler işleyecektir
                    
                    int indirimYuzdesi=30;  // bu zaman aralığı için belirlenen indirim oranı

                    indirimliFiyat=((fiyat*sure*365)-(fiyat*sure*365*indirimYuzdesi)/100);
                    indirimliFiyatSon = indirimliFiyat;
                    System.out.println("Toplam tutar = " +indirimliFiyat+" TL");
                    System.out.println("");
                    System.out.println("Yapmak istediğiniz ödeme seçeneğini giriniz: \n");
                    System.out.println("1-HEMEN ÖDE *(Online öde,avantajlı fiyatla yola çık.)\n2-YERİNDE ÖDE *(Aracı teslim alırken ödeyene kadar istediğin değişiklikleri yap)");
                    secim=sc.nextInt();
    
                    if(secim == 1) {
                        
                        odeme=5;
                        indirimliFiyatSon = (indirimliFiyat)-(indirimliFiyat*odeme)/100;
                        System.out.println("Ödeyeceğiniz tutar = "+indirimliFiyatSon+" TL");
                        System.out.println("<-------->");
                        kazanc=(indirimliFiyat*odeme)/100;
                        System.out.println("Online ödeme kazancınız = " +kazanc+" TL");
                    
                    } else if (secim == 2){
                        
                        System.out.println("Ek bir indirim uygulanmayacaktır!");
                        System.out.println(" Toplam tutar = " +indirimliFiyat+" TL");
                        indirimliFiyatSon = indirimliFiyat;
                    
                    } else {
                        
                        while (secim != 1 && secim != 2){
                                
                            System.out.println("Hatali giris yaptiniz!. Tekrar deneyin!");
                            System.out.println("");
                            System.out.println("Yapmak istediğiniz ödeme seçeneğini giriniz: \n");
                            System.out.println("1-HEMEN ÖDE *(Online öde,avantajlı fiyatla yola çık.)\n2-YERİNDE ÖDE *(Aracı teslim alırken ödeyene kadar istediğin değişiklikleri yap)");
                            secim=sc.nextInt();
                            
                            if(secim==1) {
                        
                                odeme=5;
                                indirimliFiyatSon = (indirimliFiyat)-(indirimliFiyat*odeme)/100;
                                System.out.println("Ödeyeceğiniz tutar : "+indirimliFiyatSon+" TL");
                                System.out.println("<-------->");
                                kazanc=(indirimliFiyat*odeme)/100;
                                System.out.println("Online ödeme kazancınız = " +kazanc+" TL");
                                  
                            }
                            else if (secim == 2){
                                
                                System.out.println("Ek bir indirim uygulanmayacaktır!");
                                System.out.println(" Toplam tutar = " +indirimliFiyat+" TL");
                                indirimliFiyatSon = indirimliFiyat;
        
                            }
                        }				
                    
                    }
                
                } else if(sure == 2 || sure == 3){      //  sure 2 ya da 3 yıl olduğunda bu bloktaki veriler işleyecektir
                    
                    int indirimYuzdesi=35;     // bu zaman aralığı için belirlenen indirim oranı

                    indirimliFiyat=((fiyat*sure*365)-(fiyat*sure*365*indirimYuzdesi)/100);
                    indirimliFiyatSon = indirimliFiyat;
                    System.out.println("Toplam tutar = " +indirimliFiyat+" TL");
                    System.out.println("");
                    System.out.println("Yapmak istediğiniz ödeme seçeneğini giriniz: \n");
                    System.out.println("1-HEMEN ÖDE *(Online öde,avantajlı fiyatla yola çık.)\n2-YERİNDE ÖDE *(Aracı teslim alırken ödeyene kadar istediğin değişiklikleri yap)");
                    secim=sc.nextInt();
    
                    if(secim == 1) {
                        
                        odeme=5;
                        indirimliFiyatSon = (indirimliFiyat)-(indirimliFiyat*odeme)/100;
                        System.out.println("Ödeyeceğiniz tutar = "+indirimliFiyatSon+" TL");
                        System.out.println("<-------->");
                        kazanc=(indirimliFiyat*odeme)/100;
                        System.out.println("Online ödeme kazancınız = " +kazanc+" TL");
                    
                    } else if (secim == 2){
                        
                        System.out.println("Ek bir indirim uygulanmayacaktır!");
                        System.out.println(" Toplam tutar = " +indirimliFiyat+" TL");
                        indirimliFiyatSon = indirimliFiyat;
                    
                    } else {
                        
                        while (secim != 1 && secim != 2){
                                
                            System.out.println("Hatali giris yaptiniz!. Tekrar deneyin!");
                            System.out.println("");
                            System.out.println("Yapmak istediğiniz ödeme seçeneğini giriniz: \n");
                            System.out.println("1-HEMEN ÖDE *(Online öde,avantajlı fiyatla yola çık.)\n2-YERİNDE ÖDE *(Aracı teslim alırken ödeyene kadar istediğin değişiklikleri yap)");
                            secim=sc.nextInt();
                            
                            if(secim==1) {
                        
                                odeme=5;
                                indirimliFiyatSon = (indirimliFiyat)-(indirimliFiyat*odeme)/100;
                                System.out.println("Ödeyeceğiniz tutar : "+indirimliFiyatSon+" TL");
                                System.out.println("<-------->");
                                kazanc=(indirimliFiyat*odeme)/100;
                                System.out.println("Online ödeme kazancınız = " +kazanc+" TL");
                                  
                            }
                            else if (secim == 2){
                                
                                System.out.println("Ek bir indirim uygulanmayacaktır!");
                                System.out.println(" Toplam tutar = " +indirimliFiyat+" TL");
                                indirimliFiyatSon = indirimliFiyat;
        
                            }
                        }					
                    
                    }
    
                } else if (sure == 4 || sure == 5){     //  sure 4 ya da 5 yıl olduğunda bu bloktaki veriler işleyecektir
    
                    int indirimYuzdesi=40;      // bu zaman aralığı için belirlenen indirim oranı

                    indirimliFiyat=((fiyat*sure*365)-(fiyat*sure*365*indirimYuzdesi)/100);
                    indirimliFiyatSon = indirimliFiyat;
                    System.out.println("Toplam tutar = " +indirimliFiyat+" TL");
                    System.out.println("");
                    System.out.println("Yapmak istediğiniz ödeme seçeneğini giriniz: \n");
                    System.out.println("1-HEMEN ÖDE *(Online öde,avantajlı fiyatla yola çık.)\n2-YERİNDE ÖDE *(Aracı teslim alırken ödeyene kadar istediğin değişiklikleri yap)");
                    secim=sc.nextInt();
    
                    if(secim == 1) {
                        
                        odeme=5;
                        indirimliFiyatSon = (indirimliFiyat)-(indirimliFiyat*odeme)/100;
                        System.out.println("Ödeyeceğiniz tutar = "+indirimliFiyatSon+" TL");
                        System.out.println("<-------->");
                        kazanc=(indirimliFiyat*odeme)/100;
                        System.out.println("Online ödeme kazancınız = " +kazanc+" TL");
                    
                    } else if (secim == 2){
                        
                        System.out.println("Ek bir indirim uygulanmayacaktır!");
                        System.out.println(" Toplam tutar = " +indirimliFiyat+" TL");
                        indirimliFiyatSon = indirimliFiyat;
                    
                    } else {
                        
                        while (secim != 1 && secim != 2){
                                
                            System.out.println("Hatali giris yaptiniz!. Tekrar deneyin!");
                            System.out.println("");
                            System.out.println("Yapmak istediğiniz ödeme seçeneğini giriniz: \n");
                            System.out.println("1-HEMEN ÖDE *(Online öde,avantajlı fiyatla yola çık.)\n2-YERİNDE ÖDE *(Aracı teslim alırken ödeyene kadar istediğin değişiklikleri yap)");
                            secim=sc.nextInt();
                            
                            if(secim==1) {
                        
                                odeme=5;
                                indirimliFiyatSon = (indirimliFiyat)-(indirimliFiyat*odeme)/100;
                                System.out.println("Ödeyeceğiniz tutar : "+indirimliFiyatSon+" TL");
                                System.out.println("<-------->");
                                kazanc=(indirimliFiyat*odeme)/100;
                                System.out.println("Online ödeme kazancınız = " +kazanc+" TL");
                                  
                            }
                            else if (secim == 2){
                                
                                System.out.println("Ek bir indirim uygulanmayacaktır!");
                                System.out.println(" Toplam tutar = " +indirimliFiyat+" TL");
                                indirimliFiyatSon = indirimliFiyat;
        
                            }
                        }					
                    
                    }
    
                } else if (sure > 5){       // sure 5 yıldan fazla olduğunda bu bloktaki veriler işleyecektir
    
                    while(sure > 5){
                        
                        // sistem 5 yıldan fazla kiralamaya izin vermeyektir, hata mesajı yazdırılır
                        System.out.println("5 yildan fazla arac kiralama mumkun degildir!!");
                        System.out.println("Lütfen tekrar deneyin!");
                        System.out.println("*******\n\n");

                        // kullanıcıdan tekrar yıl sayısı alınır
                        System.out.println("Araç kiralamak istediğiniz toplam süreyi yil bazında giriniz: ");
                        sure=sc.nextDouble();
    
                        if(sure == 1) {     // sure 1 yıl olduğunda bu bloktaki veriler işleyecektir
                    
                            int indirimYuzdesi=30;      // bu zaman aralığı için belirlenen indirim oranı

                            indirimliFiyat=((fiyat*sure*365)-(fiyat*sure*365*indirimYuzdesi)/100);
                            indirimliFiyatSon = indirimliFiyat;
                            System.out.println("Toplam tutar = " +indirimliFiyat+" TL");
                            System.out.println("");
                            System.out.println("Yapmak istediğiniz ödeme seçeneğini giriniz: \n");
                            System.out.println("1-HEMEN ÖDE *(Online öde,avantajlı fiyatla yola çık.)\n2-YERİNDE ÖDE *(Aracı teslim alırken ödeyene kadar istediğin değişiklikleri yap)");
                            secim=sc.nextInt();
    
                            if(secim == 1) {
                                
                                odeme=5;
                                indirimliFiyatSon = (indirimliFiyat)-(indirimliFiyat*odeme)/100;
                                System.out.println("Ödeyeceğiniz tutar = "+indirimliFiyatSon+" TL");
                                System.out.println("<-------->");
                                kazanc=(indirimliFiyat*odeme)/100;
                                System.out.println("Online ödeme kazancınız = " +kazanc+" TL");
                            
                            } else if (secim == 2){
                                
                                System.out.println("Ek bir indirim uygulanmayacaktır!");
                                System.out.println(" Toplam tutar = " +indirimliFiyat+" TL");
                                indirimliFiyatSon = indirimliFiyat;
                            
                            } else {
                                
                                while (secim != 1 && secim != 2){
                                    
                                    System.out.println("Hatali giris yaptiniz!. Tekrar deneyin!");
                                    System.out.println("");
                                    System.out.println("Yapmak istediğiniz ödeme seçeneğini giriniz: \n");
                                    System.out.println("1-HEMEN ÖDE *(Online öde,avantajlı fiyatla yola çık.)\n2-YERİNDE ÖDE *(Aracı teslim alırken ödeyene kadar istediğin değişiklikleri yap)");
                                    secim=sc.nextInt();
                                    if(secim==1) {
                                
                                        odeme=5;
                                        indirimliFiyatSon = (indirimliFiyat)-(indirimliFiyat*odeme)/100;
                                        System.out.println("Ödeyeceğiniz tutar : "+indirimliFiyatSon+" TL");
                                        System.out.println("<-------->");
                                        kazanc=(indirimliFiyat*odeme)/100;
                                        System.out.println("Online ödeme kazancınız = " +kazanc+" TL");
                                          
                                    }
                                    else if (secim == 2){
                                        
                                        System.out.println("Ek bir indirim uygulanmayacaktır!");
                                        System.out.println(" Toplam tutar = " +indirimliFiyat+" TL");
                                        indirimliFiyatSon = indirimliFiyat;
                
                                    }
                                }					
                            
                            }
                        
                        } else if(sure == 2 || sure == 3){      // sure 2 ya da 3 yıl olduğunda bu bloktaki veriler işleyecektir
    
                            int indirimYuzdesi=35;      // bu zaman aralığı için belirlenen indirim oranı

                            indirimliFiyat=((fiyat*sure*365)-(fiyat*sure*365*indirimYuzdesi)/100);
                            indirimliFiyatSon = indirimliFiyat;
                            System.out.println("Toplam tutar = " +indirimliFiyat+" TL");
                            System.out.println("");
                            System.out.println("Yapmak istediğiniz ödeme seçeneğini giriniz: \n");
                            System.out.println("1-HEMEN ÖDE *(Online öde,avantajlı fiyatla yola çık.)\n2-YERİNDE ÖDE *(Aracı teslim alırken ödeyene kadar istediğin değişiklikleri yap)");
                            secim=sc.nextInt();
    
                            if(secim == 1) {
                                
                                odeme=5;
                                indirimliFiyatSon = (indirimliFiyat)-(indirimliFiyat*odeme)/100;
                                System.out.println("Ödeyeceğiniz tutar = "+indirimliFiyatSon+" TL");
                                System.out.println("<-------->");
                                kazanc=(indirimliFiyat*odeme)/100;
                                System.out.println("Online ödeme kazancınız = " +kazanc+" TL");
                            
                            } else if (secim == 2){
                                
                                System.out.println("Ek bir indirim uygulanmayacaktır!");
                                System.out.println(" Toplam tutar = " +indirimliFiyat+" TL");
                                indirimliFiyatSon = indirimliFiyat;
                            
                            } else {
                                
                                while (secim != 1 && secim != 2){
                                    
                                    System.out.println("Hatali giris yaptiniz!. Tekrar deneyin!");
                                    System.out.println("");
                                    System.out.println("Yapmak istediğiniz ödeme seçeneğini giriniz: \n");
                                    System.out.println("1-HEMEN ÖDE *(Online öde,avantajlı fiyatla yola çık.)\n2-YERİNDE ÖDE *(Aracı teslim alırken ödeyene kadar istediğin değişiklikleri yap)");
                                    secim=sc.nextInt();
                                    if(secim==1) {
                                
                                        odeme=5;
                                        indirimliFiyatSon = (indirimliFiyat)-(indirimliFiyat*odeme)/100;
                                        System.out.println("Ödeyeceğiniz tutar : "+indirimliFiyatSon+" TL");
                                        System.out.println("<-------->");
                                        kazanc=(indirimliFiyat*odeme)/100;
                                        System.out.println("Online ödeme kazancınız = " +kazanc+" TL");
                                          
                                    }
                                    else if (secim == 2){
                                        
                                        System.out.println("Ek bir indirim uygulanmayacaktır!");
                                        System.out.println(" Toplam tutar = " +indirimliFiyat+" TL");
                                        indirimliFiyatSon = indirimliFiyat;
                
                                    }
                                }				
                            
                            }
    
                        } else if (sure == 4 || sure == 5){     // sure 4 ya da 5 yıl olduğunda bu bloktaki veriler işleyecektir
    
                            int indirimYuzdesi=40;      // bu zaman aralığı için belirlenen indirim oranı

                            indirimliFiyat=((fiyat*sure*365)-(fiyat*sure*365*indirimYuzdesi)/100);
                            indirimliFiyatSon = indirimliFiyat;
                            System.out.println("Toplam tutar = " +indirimliFiyat+" TL");
                            System.out.println("");
                            System.out.println("Yapmak istediğiniz ödeme seçeneğini giriniz: \n");
                            System.out.println("1-HEMEN ÖDE *(Online öde,avantajlı fiyatla yola çık.)\n2-YERİNDE ÖDE *(Aracı teslim alırken ödeyene kadar istediğin değişiklikleri yap)");
                            secim=sc.nextInt();
    
                            if(secim == 1) {
                                
                                odeme=5;
                                indirimliFiyatSon = (indirimliFiyat)-(indirimliFiyat*odeme)/100;
                                System.out.println("Ödeyeceğiniz tutar = "+indirimliFiyatSon+" TL");
                                System.out.println("<-------->");
                                kazanc=(indirimliFiyat*odeme)/100;
                                System.out.println("Online ödeme kazancınız = " +kazanc+" TL");
                            
                            } else if (secim == 2){
                                
                                System.out.println("Ek bir indirim uygulanmayacaktır!");
                                System.out.println(" Toplam tutar = " +indirimliFiyat+" TL");
                                indirimliFiyatSon = indirimliFiyat;
                            
                            } else {
                                
                                while (secim != 1 && secim != 2){
                                    
                                    System.out.println("Hatali giris yaptiniz!. Tekrar deneyin!");
                                    System.out.println("");
                                    System.out.println("Yapmak istediğiniz ödeme seçeneğini giriniz: \n");
                                    System.out.println("1-HEMEN ÖDE *(Online öde,avantajlı fiyatla yola çık.)\n2-YERİNDE ÖDE *(Aracı teslim alırken ödeyene kadar istediğin değişiklikleri yap)");
                                    secim=sc.nextInt();
                                    if(secim==1) {
                                
                                        odeme=5;
                                        indirimliFiyatSon = (indirimliFiyat)-(indirimliFiyat*odeme)/100;
                                        System.out.println("Ödeyeceğiniz tutar : "+indirimliFiyatSon+" TL");
                                        System.out.println("<-------->");
                                        kazanc=(indirimliFiyat*odeme)/100;
                                        System.out.println("Online ödeme kazancınız = " +kazanc+" TL");
                                          
                                    }
                                    else if (secim == 2){
                                        
                                        System.out.println("Ek bir indirim uygulanmayacaktır!");
                                        System.out.println(" Toplam tutar = " +indirimliFiyat+" TL");
                                        indirimliFiyatSon = indirimliFiyat;
                
                                    }
                                }
                    
                            }
                        }
                    }
    
                } else {        // aylık plandan yıllık plana aktarılan kullanıcı bu kez de yıllık plana uygun
                                // giriş yapmazsa işlem sonlandırılır
    
                    System.out.println("Hatali giris yaptiniz!!");
                    System.out.println("Islem sonlandiriliyor!");
                    System.exit(0);
    
                }
			
			} else {    // 0 ya da - degerde ay girisi yapılırsa işlem sonlandırılır
				
				System.out.println("Girdiginiz ay sayisi ile sectiginiz kiralama plani kullanilamaz!!");
                System.out.println("Islem sonlandiriliyor!");
			
			}


        } else if (plan == 3) { // YILLIK PLAN SECILDIYSE

            System.out.println("Araç kiralamak istediğiniz toplam süreyi yil bazında giriniz: ");
    	    double sure=sc.nextDouble();

			if(sure == 1) {     // sure olarak 1 yıl girildiyse bu bloktaki veriler işleyecektir
    		    
				int indirimYuzdesi=30;      // bu zaman aralığı için belirlenen indirim oranı

				indirimliFiyat=((fiyat*sure*365)-(fiyat*sure*365*indirimYuzdesi)/100);
				indirimliFiyatSon = indirimliFiyat;
    		    System.out.println("Toplam tutar = " +indirimliFiyat+" TL");
                System.out.println("");
    		    System.out.println("Yapmak istediğiniz ödeme seçeneğini giriniz: \n");
    		    System.out.println("1-HEMEN ÖDE *(Online öde,avantajlı fiyatla yola çık.)\n2-YERİNDE ÖDE *(Aracı teslim alırken ödeyene kadar istediğin değişiklikleri yap)");
    		    secim=sc.nextInt();

				if(secim == 1) {
					
					odeme=5;
    			    indirimliFiyatSon = (indirimliFiyat)-(indirimliFiyat*odeme)/100;
    			    System.out.println("Ödeyeceğiniz tutar = "+indirimliFiyatSon+" TL");
    			    System.out.println("<-------->");
    			    kazanc=(indirimliFiyat*odeme)/100;
    			    System.out.println("Online ödeme kazancınız = " +kazanc+" TL");
				
				} else if (secim == 2){
					
					System.out.println("Ek bir indirim uygulanmayacaktır!");
    			 	System.out.println(" Toplam tutar = " +indirimliFiyat+" TL");
    			 	indirimliFiyatSon = indirimliFiyat;
				
				} else {
					
					while (secim != 1 && secim != 2){
                                
                        System.out.println("Hatali giris yaptiniz!. Tekrar deneyin!");
                        System.out.println("");
                        System.out.println("Yapmak istediğiniz ödeme seçeneğini giriniz: \n");
                        System.out.println("1-HEMEN ÖDE *(Online öde,avantajlı fiyatla yola çık.)\n2-YERİNDE ÖDE *(Aracı teslim alırken ödeyene kadar istediğin değişiklikleri yap)");
                        secim=sc.nextInt();
                        
                        if(secim==1) {
                    
                            odeme=5;
                            indirimliFiyatSon = (indirimliFiyat)-(indirimliFiyat*odeme)/100;
                            System.out.println("Ödeyeceğiniz tutar : "+indirimliFiyatSon+" TL");
                            System.out.println("<-------->");
                            kazanc=(indirimliFiyat*odeme)/100;
                            System.out.println("Online ödeme kazancınız = " +kazanc+" TL");
                              
                        }
                        else if (secim == 2){
                            
                            System.out.println("Ek bir indirim uygulanmayacaktır!");
                            System.out.println(" Toplam tutar = " +indirimliFiyat+" TL");
                            indirimliFiyatSon = indirimliFiyat;
    
                        }
                    }					
				
				}
                
			} else if(sure == 2 || sure == 3){       // sure olarak 2 yada 3 yıl girildiyse bu bloktaki veriler işleyecektir

				int indirimYuzdesi=35;      // bu zaman aralığı için belirlenen indirim oranı

				indirimliFiyat=((fiyat*sure*365)-(fiyat*sure*365*indirimYuzdesi)/100);
				indirimliFiyatSon = indirimliFiyat;
    		    System.out.println("Toplam tutar = " +indirimliFiyat+" TL");
                System.out.println("");
    		    System.out.println("Yapmak istediğiniz ödeme seçeneğini giriniz: \n");
    		    System.out.println("1-HEMEN ÖDE *(Online öde,avantajlı fiyatla yola çık.)\n2-YERİNDE ÖDE *(Aracı teslim alırken ödeyene kadar istediğin değişiklikleri yap)");
    		    secim=sc.nextInt();

				if(secim == 1) {
					
					odeme=5;
    			    indirimliFiyatSon = (indirimliFiyat)-(indirimliFiyat*odeme)/100;
    			    System.out.println("Ödeyeceğiniz tutar = "+indirimliFiyatSon+" TL");
    			    System.out.println("<-------->");
    			    kazanc=(indirimliFiyat*odeme)/100;
    			    System.out.println("Online ödeme kazancınız = " +kazanc+" TL");
				
				} else if (secim == 2){
					
					System.out.println("Ek bir indirim uygulanmayacaktır!");
    			 	System.out.println(" Toplam tutar = " +indirimliFiyat+" TL");
    			 	indirimliFiyatSon = indirimliFiyat;
				
				} else {
					
					while (secim != 1 && secim != 2){
                                
                        System.out.println("Hatali giris yaptiniz!. Tekrar deneyin!");
                        System.out.println("");
                        System.out.println("Yapmak istediğiniz ödeme seçeneğini giriniz: \n");
                        System.out.println("1-HEMEN ÖDE *(Online öde,avantajlı fiyatla yola çık.)\n2-YERİNDE ÖDE *(Aracı teslim alırken ödeyene kadar istediğin değişiklikleri yap)");
                        secim=sc.nextInt();
                        
                        if(secim==1) {
                    
                            odeme=5;
                            indirimliFiyatSon = (indirimliFiyat)-(indirimliFiyat*odeme)/100;
                            System.out.println("Ödeyeceğiniz tutar : "+indirimliFiyatSon+" TL");
                            System.out.println("<-------->");
                            kazanc=(indirimliFiyat*odeme)/100;
                            System.out.println("Online ödeme kazancınız = " +kazanc+" TL");
                              
                        }
                        else if (secim == 2){
                            
                            System.out.println("Ek bir indirim uygulanmayacaktır!");
                            System.out.println(" Toplam tutar = " +indirimliFiyat+" TL");
                            indirimliFiyatSon = indirimliFiyat;
    
                        }
                    }				
				
				}

			} else if (sure == 4 || sure == 5){     // sure olarak 4 yada 5 yıl girildiyse bu bloktaki veriler işleyecektir

				int indirimYuzdesi=40;      // bu zaman aralığı için belirlenen indirim oranı

				indirimliFiyat=((fiyat*sure*365)-(fiyat*sure*365*indirimYuzdesi)/100);
				indirimliFiyatSon = indirimliFiyat;
    		    System.out.println("Toplam tutar = " +indirimliFiyat+" TL");
                System.out.println("");
    		    System.out.println("Yapmak istediğiniz ödeme seçeneğini giriniz: \n");
    		    System.out.println("1-HEMEN ÖDE *(Online öde,avantajlı fiyatla yola çık.)\n2-YERİNDE ÖDE *(Aracı teslim alırken ödeyene kadar istediğin değişiklikleri yap)");
    		    secim=sc.nextInt();

				if(secim == 1) {
					
					odeme=5;
    			    indirimliFiyatSon = (indirimliFiyat)-(indirimliFiyat*odeme)/100;
    			    System.out.println("Ödeyeceğiniz tutar = "+indirimliFiyatSon+" TL");
    			    System.out.println("<-------->");
    			    kazanc=(indirimliFiyat*odeme)/100;
    			    System.out.println("Online ödeme kazancınız = " +kazanc+" TL");
				
				} else if (secim == 2){
					
					System.out.println("Ek bir indirim uygulanmayacaktır!");
    			 	System.out.println(" Toplam tutar = " +indirimliFiyat+" TL");
    			 	indirimliFiyatSon = indirimliFiyat;
				
				} else {
					
					while (secim != 1 && secim != 2){
                                
                        System.out.println("Hatali giris yaptiniz!. Tekrar deneyin!");
                        System.out.println("");
                        System.out.println("Yapmak istediğiniz ödeme seçeneğini giriniz: \n");
                        System.out.println("1-HEMEN ÖDE *(Online öde,avantajlı fiyatla yola çık.)\n2-YERİNDE ÖDE *(Aracı teslim alırken ödeyene kadar istediğin değişiklikleri yap)");
                        secim=sc.nextInt();
                        
                        if(secim==1) {
                    
                            odeme=5;
                            indirimliFiyatSon = (indirimliFiyat)-(indirimliFiyat*odeme)/100;
                            System.out.println("Ödeyeceğiniz tutar : "+indirimliFiyatSon+" TL");
                            System.out.println("<-------->");
                            kazanc=(indirimliFiyat*odeme)/100;
                            System.out.println("Online ödeme kazancınız = " +kazanc+" TL");
                              
                        }
                        else if (secim == 2){
                            
                            System.out.println("Ek bir indirim uygulanmayacaktır!");
                            System.out.println(" Toplam tutar = " +indirimliFiyat+" TL");
                            indirimliFiyatSon = indirimliFiyat;
    
                        }
                    }					
				
				}

			} else if (sure > 5){

                while(sure > 5){       // kullanıcı sure olarak 5 yıldan fazla giriş yaparsa hata mesajı alacaktır
										
                    System.out.println("5 yildan fazla arac kiralama mumkun degildir!!");
                    System.out.println("Lütfen tekrar deneyin!");
                    System.out.println("*******\n\n");
                    
                    // kullanıcıdan tekrar yıl sayısı alınır
                    System.out.println("Araç kiralamak istediğiniz toplam süreyi yil bazında giriniz: ");
                    sure=sc.nextDouble();

                    if(sure == 1) {     // kullanıcı sure olarak 1 yıl giriş yaparsa bu kod bloğu işleyecektir
										
                        int indirimYuzdesi=30;      // bu zaman aralığı için belirlenen indirim oranı

                        indirimliFiyat=((fiyat*sure*365)-(fiyat*sure*365*indirimYuzdesi)/100);
                        indirimliFiyatSon = indirimliFiyat;
                        System.out.println("Toplam tutar = " +indirimliFiyat+" TL");
                        System.out.println("");
                        System.out.println("Yapmak istediğiniz ödeme seçeneğini giriniz: \n");
                        System.out.println("1-HEMEN ÖDE *(Online öde,avantajlı fiyatla yola çık.)\n2-YERİNDE ÖDE *(Aracı teslim alırken ödeyene kadar istediğin değişiklikleri yap)");
                        secim=sc.nextInt();

                        if(secim == 1) {
                            
                            odeme=5;
                            indirimliFiyatSon = (indirimliFiyat)-(indirimliFiyat*odeme)/100;
                            System.out.println("Ödeyeceğiniz tutar = "+indirimliFiyatSon+" TL");
                            System.out.println("<-------->");
                            kazanc=(indirimliFiyat*odeme)/100;
                            System.out.println("Online ödeme kazancınız = " +kazanc+" TL");
                        
                        } else if (secim == 2){
                            
                            System.out.println("Ek bir indirim uygulanmayacaktır!");
                             System.out.println(" Toplam tutar = " +indirimliFiyat+" TL");
                             indirimliFiyatSon = indirimliFiyat;
                        
                        } else {
                            
                            while (secim != 1 && secim != 2){
                                
                                System.out.println("Hatali giris yaptiniz!. Tekrar deneyin!");
                                System.out.println("");
                                System.out.println("Yapmak istediğiniz ödeme seçeneğini giriniz: \n");
                                System.out.println("1-HEMEN ÖDE *(Online öde,avantajlı fiyatla yola çık.)\n2-YERİNDE ÖDE *(Aracı teslim alırken ödeyene kadar istediğin değişiklikleri yap)");
                                secim=sc.nextInt();
                                if(secim==1) {
                            
                                    odeme=5;
                                    indirimliFiyatSon = (indirimliFiyat)-(indirimliFiyat*odeme)/100;
                                    System.out.println("Ödeyeceğiniz tutar : "+indirimliFiyatSon+" TL");
                                    System.out.println("<-------->");
                                    kazanc=(indirimliFiyat*odeme)/100;
                                    System.out.println("Online ödeme kazancınız = " +kazanc+" TL");
                                      
                                }
                                else if (secim == 2){
                                    
                                    System.out.println("Ek bir indirim uygulanmayacaktır!");
                                    System.out.println(" Toplam tutar = " +indirimliFiyat+" TL");
                                    indirimliFiyatSon = indirimliFiyat;
            
                                }
                            }					
                        
                        }
                    
                    } else if(sure == 2 || sure == 3){      // kullanıcı sure olarak 2 ya da 3 yıl giriş yaparsa bu kod bloğu işleyecektir    

                        int indirimYuzdesi=35;      // bu zaman aralığı için belirlenen indirim oranı

                        indirimliFiyat=((fiyat*sure*365)-(fiyat*sure*365*indirimYuzdesi)/100);
                        indirimliFiyatSon = indirimliFiyat;
                        System.out.println("Toplam tutar = " +indirimliFiyat+" TL");
                        System.out.println("");
                        System.out.println("Yapmak istediğiniz ödeme seçeneğini giriniz: \n");
                        System.out.println("1-HEMEN ÖDE *(Online öde,avantajlı fiyatla yola çık.)\n2-YERİNDE ÖDE *(Aracı teslim alırken ödeyene kadar istediğin değişiklikleri yap)");
                        secim=sc.nextInt();

                        if(secim == 1) {
                            
                            odeme=5;
                            indirimliFiyatSon = (indirimliFiyat)-(indirimliFiyat*odeme)/100;
                            System.out.println("Ödeyeceğiniz tutar = "+indirimliFiyatSon+" TL");
                            System.out.println("<-------->");
                            kazanc=(indirimliFiyat*odeme)/100;
                            System.out.println("Online ödeme kazancınız = " +kazanc+" TL");
                        
                        } else if (secim == 2){
                            
                            System.out.println("Ek bir indirim uygulanmayacaktır!");
                             System.out.println(" Toplam tutar = " +indirimliFiyat+" TL");
                             indirimliFiyatSon = indirimliFiyat;
                        
                        } else {
                            
                            while (secim != 1 && secim != 2){
                                
                                System.out.println("Hatali giris yaptiniz!. Tekrar deneyin!");
                                System.out.println("");
                                System.out.println("Yapmak istediğiniz ödeme seçeneğini giriniz: \n");
                                System.out.println("1-HEMEN ÖDE *(Online öde,avantajlı fiyatla yola çık.)\n2-YERİNDE ÖDE *(Aracı teslim alırken ödeyene kadar istediğin değişiklikleri yap)");
                                secim=sc.nextInt();
                                if(secim==1) {
                            
                                    odeme=5;
                                    indirimliFiyatSon = (indirimliFiyat)-(indirimliFiyat*odeme)/100;
                                    System.out.println("Ödeyeceğiniz tutar : "+indirimliFiyatSon+" TL");
                                    System.out.println("<-------->");
                                    kazanc=(indirimliFiyat*odeme)/100;
                                    System.out.println("Online ödeme kazancınız = " +kazanc+" TL");
                                      
                                }
                                else if (secim == 2){
                                    
                                    System.out.println("Ek bir indirim uygulanmayacaktır!");
                                    System.out.println(" Toplam tutar = " +indirimliFiyat+" TL");
                                    indirimliFiyatSon = indirimliFiyat;
            
                                }
                            }				
                        
                        }

                    } else if (sure == 4 || sure == 5){     // kullanıcı sure olarak 4 ya da 5 yıl giriş yaparsa bu kod bloğu işleyecektir

                        int indirimYuzdesi=40;          // bu zaman aralığı için belirlenen indirim oranı

                        indirimliFiyat=((fiyat*sure*365)-(fiyat*sure*365*indirimYuzdesi)/100);
                        indirimliFiyatSon = indirimliFiyat;
                        System.out.println("Toplam tutar = " +indirimliFiyat+" TL");
                        System.out.println("");
                        System.out.println("Yapmak istediğiniz ödeme seçeneğini giriniz: \n");
                        System.out.println("1-HEMEN ÖDE *(Online öde,avantajlı fiyatla yola çık.)\n2-YERİNDE ÖDE *(Aracı teslim alırken ödeyene kadar istediğin değişiklikleri yap)");
                        secim=sc.nextInt();

                        if(secim == 1) {
                            
                            odeme=5;
                            indirimliFiyatSon = (indirimliFiyat)-(indirimliFiyat*odeme)/100;
                            System.out.println("Ödeyeceğiniz tutar = "+indirimliFiyatSon+" TL");
                            System.out.println("<-------->");
                            kazanc=(indirimliFiyat*odeme)/100;
                            System.out.println("Online ödeme kazancınız = " +kazanc+" TL");
                        
                        } else if (secim == 2){
                            
                            System.out.println("Ek bir indirim uygulanmayacaktır!");
                            System.out.println(" Toplam tutar = " +indirimliFiyat+" TL");
                            indirimliFiyatSon = indirimliFiyat;
                        
                        } else {
                            
                            while (secim != 1 && secim != 2){
                                
                                System.out.println("Hatali giris yaptiniz!. Tekrar deneyin!");
                                System.out.println("");
                                System.out.println("Yapmak istediğiniz ödeme seçeneğini giriniz: \n");
                                System.out.println("1-HEMEN ÖDE *(Online öde,avantajlı fiyatla yola çık.)\n2-YERİNDE ÖDE *(Aracı teslim alırken ödeyene kadar istediğin değişiklikleri yap)");
                                secim=sc.nextInt();
                                if(secim==1) {
                            
                                    odeme=5;
                                    indirimliFiyatSon = (indirimliFiyat)-(indirimliFiyat*odeme)/100;
                                    System.out.println("Ödeyeceğiniz tutar : "+indirimliFiyatSon+" TL");
                                    System.out.println("<-------->");
                                    kazanc=(indirimliFiyat*odeme)/100;
                                    System.out.println("Online ödeme kazancınız = " +kazanc+" TL");
                                      
                                }
                                else if (secim == 2){
                                    
                                    System.out.println("Ek bir indirim uygulanmayacaktır!");
                                    System.out.println(" Toplam tutar = " +indirimliFiyat+" TL");
                                    indirimliFiyatSon = indirimliFiyat;
            
                                }
                            }
                
                        }
                    }
                }

			} else {        // kullanıcı 0 ya da - değer girerse hata mesajı alacaktır

				System.out.println("Hatali giris yaptiniz!!");
                System.out.println("Islem sonlandiriliyor!");

                // işlem sonlandırılacaktır
                System.exit(0);

			}


        } else {    // PLAN SECIMI DOGRU YAPILMADIYSA

            // kullanıcı günlük - aylık veya yıllık plandan birini seçmediyse işlem sonlandırılacaktır
            
            System.out.println("Hatali giris yaptiniz!");
            System.out.println("Islem sonlandiriliyor. Lutfen islemi yeniden baslatiniz!");
            
            // işlem sonlandırılır
            System.exit(0);
        
        }

          
    }
     
    
    public double sendFiyat() {         // indirim işlemleri (hemen ödeme indirimi ve seçilen plana göre ayrı ayrı yapılan indirim)
                                        // uygulandıktan sonra son oluşan değer main'e fonksiyonla gönderilir
    	 return indirimliFiyatSon;
    }
    
    
 
}

