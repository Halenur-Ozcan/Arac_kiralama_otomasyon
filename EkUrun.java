
import java.util.Scanner;			// gerekli import işlemleri yapılır


public class EkUrun extends DiscountYedek { // subclass 

	private int secenek ;
	private int adet ;
	private double tutar;
	private double sonTutar;
	 
	DiscountYedek d1 = new DiscountYedek();
	Scanner sc=new Scanner(System.in);
	 
	 
	public EkUrun() {
		super();
		
	}
	
	
	public EkUrun(double sure, int indirimYuzdesi, double fiyat) {
		super(sure, indirimYuzdesi, fiyat);
		
	}
	

	
	public void sec() {
		
		int i=0;			// gerekli değişkenler tanımlanır
		double fiyat;
		
		while(i<2){			// iki ayrı sorgulama yapılacağı için döngü iki defa çalışacak şekilde ayarlanmıştır

			
			System.out.println("İstediğiniz ek ürünü seçiniz: \n\n1-Ek sürücü(80.00TL)[Aracın,kiralayan şahıs dışındaki kişi ve/veya kişilerce kullanılabilmesini sağlamaktadır.]");
			System.out.println("2-Bebek koltuğu(150.00TL)[Belirli bir yaş ve kilo altındaki bebeklerin ve çocukların araç içerisinde yolculukarı esnasında bebek koltuğu kullanması zorunludur]");
			System.out.println("3-Genç sürücü(480.00TL)[Genç sürücü paketi,yaş grubunuzun bir üst grubundaki aracı kiralayabilmenizi sağlamaktadır.]");
			System.out.println("4- 7/24 Yol yardım asistanı (250.00TL)[Kiralama süresince güvence kapsamı dışındaki; lastik patlaması,yakıt-akü bitimi gibi durumlarda en yakın servis bölgesine çekici hizmeti sağlamaktadır.]");
			System.out.println("5-Kapsamlı Tam Güvence Paketi(600.00TL)[İhtiyari mali mesuliyet güvencesi + Süper mini hasar güvencesi + Ferdi kaza güvencesi]");
			System.out.println("6-Kapsamlı Süper Mini Hasar Paketi(450.00TL)[Süper mini hasar güvencesi + Lastik-cam-far-ayna güvencesi]");
			System.out.println("0-Ek ürün istemiyorum.");
			
			// kullanıcıdan istediği hizmete ait numara alınır bu işlem iki sefer gerçekleşir 
			secenek=sc.nextInt();
			
			if(secenek==1) {	// seçime göre gerekli bilgilendirmeler yapılır
				
				System.out.println("Seçtiğiniz 'EK SÜRÜCÜ' ek ürününün birim fiyatı 80.00Tl'dir.\n Lütfen dahil etmek istediğiniz ek ürün adedini giriniz:(!Max 2)");
				adet=sc.nextInt();
				fiyat=(80*adet);
				System.out.println("Ek ürün tutarı " +fiyat+" TL");
				System.out.println("");
				tutar=tutar+fiyat;
			}
			else if(secenek==2) {
				System.out.println("Seçtiğiniz 'BEBEK KOLTUĞU' ek ürününün birim fiyatı 150.00TL'dir.\n Lütfen dahil etmek istediğiniz ek ürün adedini giriniz(max 2):");
				adet=sc.nextInt();
				fiyat=(150*adet);
				System.out.println("Ek ürün tutarı: " + fiyat+" TL");
				System.out.println("");
				tutar=tutar+fiyat;
				
			}
			else if(secenek==3){
				System.out.println("Seçtiğiniz 'GENÇ SÜRÜCÜ' ek ürününün birim fiyatı 480.00TL'dir.\n Lütfen dahil etmek istediğiniz ek ürün adedini giriniz(max 2):");
				adet=sc.nextInt();
				fiyat=(480*adet);
				System.out.println("Ek ürün tutarı: " +fiyat+" TL");
				System.out.println("");
				tutar=tutar+fiyat;
			}
			else if(secenek==4) {
				System.out.println("Seçtiğiniz '7/24 YOL YARDIM' ek ürününün birim fiyatı 250.00TL'dir.\n Lütfen dahil etmek istediğiniz ek ürün adedini giriniz(max 2):");
				adet=sc.nextInt();
				fiyat=(250*adet);
				System.out.println("Ek ürün tutarı :"+fiyat+"TL");
				System.out.println("");
				tutar=tutar+fiyat;
			}
			else if(secenek==5) {
				System.out.println("Seçtiğiniz 'Kapsamlı Tam Güvence Paketi' ek ürününün birim fiyatı 600.00TL'dir.");
				adet = 1;
				fiyat=(600*adet);
				System.out.println("Ek ürün tutarı :"+fiyat+"TL");
				System.out.println("");
				tutar=tutar+fiyat;
			}
			else if(secenek==6) {
				System.out.println("Seçtiğiniz 'Kapsamlı Süper Mini Hasar Paketi' ek ürününün birim fiyatı 450.00TL'dir.");
				fiyat=(450*adet);
				System.out.println("Ek ürün tutarı :"+fiyat+"TL");
				System.out.println("");
				tutar=tutar+fiyat;
			}
			
			else if(secenek==0){ 	// ek ürün tercih etmezse fiyata etkisi olmadan işlem devam eder
				System.out.println("Ek ürün tercihi yapılmadı...");
				
			}
			i++;
		
		}
		
		
		// son tutar yazdırılır
		System.out.println("Toplam ek ürün tutarınız: "+ tutar+" TL");
		
		// fonksiyonla göndermek üzere yeni değişkene atanır
		sonTutar = tutar;
			 
	}
	


	public double sendTutar() {		// ek ürün bedelini main'de almak için fonksiyonla son tutar gönderilir
		return sonTutar;
	}
	
	
}



