import java.util.Scanner;			// gerekli import işlemleri yapılır

public class Main {
	public static void main(String[]args) {
    	
		Scanner sc= new Scanner(System.in);

		
//      bilgi alma 
		MusteriKayit m1=new MusteriKayit();
		m1.kisiBilgisiGetir();

//      istayson
		Istasyon s1 = new Istasyon();
		s1.ist();

		IstasyonAl a1 = new IstasyonAl();
		a1.ist();

		IstasyonBirak b1 = new IstasyonBirak();
		b1.ist();
		

// 		indirim hesaplama
		DiscountYedek d2 = new DiscountYedek();
		d2.indirim();
		
//      ek urun secimi 
		EkUrun e1=new EkUrun();
		e1.sec();
		
		System.out.println("Toplam son tutar: "+(d2.sendFiyat()+e1.sendTutar())+" TL"); // fonksiyonlari islem yapildiktan 
																						// sonra cagirilir
		// send fiyat ve send tutar fonksiyonlarından gelen
		// değerler (toplam kiralama bedeli + ek ürün bedeli) main altında toplanır 
		// ve son tutar kullanıcıya bildirilir
				
		System.out.println("");
		System.out.println("Kiralama işlemi başarıyla tamamlandı. İyi yolculuklar...");
		// kiralama işleminin tamamlandığına dair mesaj yazdırılır

		

		
	}
}

	
	
