
import java.util.Scanner;		// gerekli import işlemleri yapılır
import java.lang.System;

public class MusteriKayit {		// gerekli değişken tanımlamaları yapılır
	
	private String isim;
	private String soyad;
	private String tc;
	private String email;
	private String sifre;
	
	
	public MusteriKayit() {
		
	}
	
	public MusteriKayit(String isim,String soyad,String tc,String email,String sifre) {
		this.isim=isim;
		this.soyad=soyad;
		this.tc=tc;
		this.email=email;
		this.sifre=sifre;
	}
	
	public void kisiBilgisiGetir() {		
		Scanner sc= new Scanner(System.in);
		
		
		System.out.println("Tc kimlik numaranızı giriniz:");
		String tc=sc.nextLine();  // kullanıcıdan kimlik numarası alınır
		

		if(tc.length() == 11){		// kimlik numarası 11 hane ise blok çalışır
			
			// diğer gerekli bilgiler alınır

			System.out.println("İsminizi giriniz:(ehliyetinizde yer aldığı gibi)");
			String isim=sc.nextLine();
	    	System.out.println("Soyadınızı giriniz:(ehliyetinizde yer aldığı gibi)");
	    	String soyad=sc.nextLine();				
			System.out.println("E-Mail adresinizi giriniz:");
			String email=sc.nextLine();
			System.out.println("Bir şifre oluşturun: (min. 6 hane)");
	    	String sifre=sc.nextLine();

			while(sifre.length() <= 5){
				
				System.out.println("Sifre 6 haneden küçük olamaz. Tekrar deneyin!");
				System.out.println("");
				System.out.println("Bir şifre oluşturun: (min. 6 hane)");
				sifre=sc.nextLine();

				if(sifre.length() >= 6){
					
					if(isim.equals(null)||soyad.equals(null)||email.equals(null)||sifre.equals(null)) {
					
						System.out.println("Eksik bilgi nedeniyle kayıt tamamlanamadı! Tekrar dene...");
					
					}
					else 
					{
						System.out.println("Kayıt başarıyla tamamlandı! Bir sonraki sayfaya yönlendiriliyorsunuz...");
						System.out.println("");
		
					}
				}
			}
		}

		while (tc.length() != 11){		// kimlik numarası hatalı ise döngü bloğu çalışır
			
			// hata mesajı yazdırılır
			System.out.println("Hatali giris yaptiniz. Lutfen tekrar deneyin!");
			System.out.println("");

			// tekrar kimlik numarası istenir
			System.out.println("Tc kimlik numaranızı giriniz:");
			tc=sc.nextLine(); 

			if(tc.length() == 11){		// doğru girerse işleme devam edilir	
				
				System.out.println("İsminizi giriniz: (ehliyetinizde yer aldığı gibi)");
		    	String isim=sc.nextLine();
		    	System.out.println("Soyadınızı giriniz: (ehliyetinizde yer aldığı gibi)");
		    	String soyad=sc.nextLine();
				System.out.println("E-Mail adresinizi giriniz:");
		    	String email=sc.nextLine();
				System.out.println("Bir şifre oluşturun: (min. 6 hane)");
		    	String sifre=sc.nextLine();

				while(sifre.length() <= 5){		// şiffrenin uzunluğu uygun değilse hata mesajları döngüsü çalışır
					
					System.out.println("Sifre 6 haneden küçük olamaz. Tekrar deneyin!");
					System.out.println("");
					System.out.println("Bir şifre oluşturun: (min. 6 hane)");
		    		sifre=sc.nextLine();

					if(sifre.length() >= 6){		// şifre uygun girildiğinde işlem devam eder
						
						if(isim.equals(null)||soyad.equals(null)||email.equals(null)||sifre.equals(null)) {
					
							// veriler eksik bilgi içeriyorsa hata mesajı yazdırılır
							System.out.println("Eksik bilgi nedeniyle kayıt tamamlanamadı! "); 
							// işlem sonlandırılır
							System.exit(0);
						
						}
						else 
						{	// kaydın tamamlandığına dair mesaj ekrana getirilir
							System.out.println("Kayıt başarıyla tamamlandı! Bir sonraki sayfaya yönlendiriliyorsunuz...");
							System.out.println("");
		
						}

					}

				}
				
			}

		}

	}

}